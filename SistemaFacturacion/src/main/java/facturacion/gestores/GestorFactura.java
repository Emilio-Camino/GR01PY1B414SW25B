package facturacion.gestores;

import facturacion.elementos.*;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;
import facturacion.gestores.interfaces.IGestorFacturaHeladero;
import facturacion.gestores.interfaces.IGestorFacturaCajero;

// Importar TODAS las clases de persistencia necesarias
import facturacion.persistencia.ClientePersist;
import facturacion.persistencia.FacturaPersist;
import facturacion.persistencia.PedidoPersist;
import facturacion.persistencia.PromocionPersist;
import facturacion.persistencia.ReporteVentaPersist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class GestorFactura implements IGestorFacturaHeladero, IGestorFacturaCajero {

    public GestorFactura() {

    }

    // --- Métodos de IGestorFacturaCajero ---
    @Override
    public Factura generarFactura(int pedidoID, String clienteCedula, boolean aplicaPromocion) {

        //Consultar datos de persistencia
        Pedido pedidoAFacturar = PedidoPersist.buscarPedido(pedidoID);
        Cliente clienteFactura = ClientePersist.buscarCliente(clienteCedula);

        //Verificación
        if (pedidoAFacturar == null) {
            System.err.println("Error: No se encontró el pedido con ID " + pedidoID);
            return null;
        }
        if (clienteFactura == null) {
            System.err.println("Error: No se encontró el cliente con cédula " + clienteCedula);
            return null;
        }
        if (pedidoAFacturar.getEstado().equals("FACTURADO")) {
            System.err.println("Error: El pedido " + pedidoID + " ya fue facturado.");
            // En una aplicación real, esto mostraría un JOptionPane
            return null;
        }

        //Cálculo de precios
        double subtotal = calcularSubtotal(pedidoAFacturar);
        double descuento = 0.0;
        if (aplicaPromocion) {
            descuento = calcularDescuento(pedidoAFacturar);
        }

        double baseImponible = subtotal - descuento;
        double iva = baseImponible * 0.15; // 15% como en la GUI
        double totalCalculado = baseImponible + iva;

        //Crear la Factura (usando el constructor)
        Factura nuevaFactura = new Factura(
                pedidoAFacturar,
                clienteFactura,
                totalCalculado,
                iva,
                0.0,
                0.0,
                "PENDIENTE"
        );

        // 5. Lógica de persistencia: Asignar ID y Guardar
        nuevaFactura.asignarIDFinal();
        FacturaPersist.agregarFactura(nuevaFactura);

        // 6. Lógica de negocio: Actualizar Estado del Pedido
        pedidoAFacturar.setEstado("FACTURADO");

        System.out.println("Factura " + nuevaFactura.getIdFactura() + " generada para el pedido " + pedidoID);
        return nuevaFactura;
    }

    // --- Métodos de IGestorFacturaHeladero ---

    /**
     * Genera un reporte de ventas procesando todas las facturas
     * activas de la capa de persistencia.
     */
    @Override
    public ReporteVenta generarReporteVenta() {
        double totalVentas = 0.0;
        int facturasProcesadas = 0;
        Map<SaborHelado, Integer> conteoSabor = new HashMap<>();
        Map<TipoRecipiente, Integer> conteoRecipiente = new HashMap<>();

        // 1. Obtener datos de persistencia
        List<Factura> todasLasFacturas = FacturaPersist.getListaFacturas();

        // 2. Lógica de negocio: filtrar y procesar
        for (Factura f : todasLasFacturas) {
            if (!f.getTipoPago().equals("ANULADA")) {
                totalVentas += f.getTotal();
                facturasProcesadas++;
                Pedido pedido = f.getPedido();

                if (pedido != null) {
                    for (Helado helado : pedido.getHelados()) {
                        TipoRecipiente tr = helado.getRecipiente().getTipo();
                        conteoRecipiente.put(tr, conteoRecipiente.getOrDefault(tr, 0) + 1);
                        for (SaborHelado sabor : helado.getSaborHelado()) {
                            conteoSabor.put(sabor, conteoSabor.getOrDefault(sabor, 0) + 1);
                        }
                    }
                }
            }
        }

        // 3. Lógica de negocio: encontrar más vendidos
        SaborHelado saborMasVendido = conteoSabor.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        TipoRecipiente recipienteMasVendido = conteoRecipiente.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        // 4. Lógica de negocio: Crear el reporte
        ReporteVenta reporte = new ReporteVenta(
                totalVentas,
                facturasProcesadas,
                saborMasVendido,
                recipienteMasVendido,
                conteoSabor,
                conteoRecipiente
        );

        // 5. Lógica de persistencia: Asignar ID y guardar
        reporte.asignarIDFinal();
        ReporteVentaPersist.agregarReporte(reporte);

        return reporte;
    }

    /**
     * Busca una factura en la capa de persistencia.
     */
    @Override
    public Factura buscarFactura(int idFactura) {
        Factura f = FacturaPersist.buscarFactura(idFactura);
        if (f == null) {
            System.err.println("Factura " + idFactura + " no encontrada.");
        }
        return f;
    }

    /**
     * Anula una factura. Busca la factura en persistencia y modifica
     * su estado en memoria. (La persistencia la mantiene modificada).
     */
    @Override
    public boolean anularFactura(int idFactura) {
        // 1. Lógica de negocio: Buscar el objeto
        Factura factura = FacturaPersist.buscarFactura(idFactura);

        // 2. Lógica de negocio: Modificar el objeto
        if (factura != null) {
            factura.setTipoPago("ANULADA");
            factura.setPago(0.0);
            factura.setCambio(0.0);
            System.out.println("Factura " + idFactura + " anulada.");
            return true;
        }
        return false;
    }

    /**
     * Obtiene la lista completa de facturas desde la persistencia.
     */
    @Override
    public ArrayList<Factura> getListaFacturas() {
        return FacturaPersist.getListaFacturas();
    }


    // --- Métodos Privados de Lógica de Negocio ---

    /**
     * Calcula el subtotal (suma de precios de helados) de un pedido.
     */
    private double calcularSubtotal(Pedido pedido) {
        double subtotal = 0.0;
        if (pedido == null || pedido.getHelados() == null) {
            return 0.0;
        }
        for (Helado helado : pedido.getHelados()) {
            subtotal += helado.getPrecio();
        }
        return subtotal;
    }

    /**
     * Calcula el descuento para un pedido basándose en la promoción
     * activa (obtenida de persistencia).
     */
    private double calcularDescuento(Pedido pedido) {
        double descuento = 0.0;
        if (pedido == null || pedido.getHelados() == null) {
            return 0.0;
        }

        // Asume que la promoción se busca de persistencia.
        // Tu GUI parece hardcodear la promo 1
        Promocion promo = PromocionPersist.buscarPromocion(1);

        if (promo != null) {
            SaborHelado saborEnPromo = promo.getSaborPromocion();
            double porcentajeDesc = promo.getPorcentajeDescuento(); // Ej. 0.15

            for (Helado helado : pedido.getHelados()) {
                for (BolaHelado bola : helado.getBolasHelado()) {
                    if (bola.getSabor() == saborEnPromo) {
                        descuento += bola.getPrecio() * porcentajeDesc;
                    }
                }
            }
        }
        return descuento;
    }
}