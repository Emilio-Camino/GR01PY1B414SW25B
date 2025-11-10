package facturacion.gestores;

import facturacion.elementos.Factura;
import facturacion.elementos.ReporteVenta;
import facturacion.elementos.Pedido;
import facturacion.elementos.Cliente;
import facturacion.elementos.Helado;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

import facturacion.gestores.interfaces.IGestorFacturaHeladero;
import facturacion.gestores.interfaces.IGestorFacturaCajero;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class GestorFactura implements IGestorFacturaHeladero, IGestorFacturaCajero {

    private ArrayList<Factura> listaFacturas;
    private ArrayList<ReporteVenta> listaReporte;


    // --- 3. Constructor ---
    public GestorFactura(GestorCliente gestorCliente, GestorPedido gestorPedido) {
        // Constructor
        this.listaFacturas = new ArrayList<>();
        this.listaReporte = new ArrayList<>();
        quemarDatosFacturas(gestorCliente, gestorPedido);
    }

    // --- 4. Métodos de IGestorFacturaCajero ---

    @Override
    public Factura generarFactura(int pedidoID, String clienteCedula,
                                  GestorPedido gestorPedido, GestorCliente gestorCliente,
                                  GestorPromocion gestorPromocion) {

        // 1. Consulta
        Pedido pedidoAFacturar = gestorPedido.buscarPedido(pedidoID); // Usa el parámetro

        // 2. Busqueda
        Cliente clienteFactura = gestorCliente.buscarCliente(clienteCedula); // Usa el parámetro

        // 3. Verificacion
        if (pedidoAFacturar == null) {
            System.err.println("Error: No se encontró el pedido con ID " + pedidoID);
            return null;
        }
        if (clienteFactura == null) {
            System.err.println("Error: No se encontró el cliente con cédula " + clienteCedula);
            return null;
        }

        // 4. Calculo
        double totalCalculado = this.calcularPrecio(pedidoAFacturar, gestorPromocion);

        double iva = totalCalculado * 0.12;

        // 5. Crear la Factura
        Factura nuevaFactura = new Factura();
        nuevaFactura.setFechaEmision(new Date());
        nuevaFactura.setPedidos(pedidoAFacturar);
        nuevaFactura.setCliente(clienteFactura);
        nuevaFactura.setTotal(totalCalculado);
        nuevaFactura.setImpuestoIVA(iva);
        nuevaFactura.setTipoPago("PENDIENTE");
        nuevaFactura.setPago(0.0);
        nuevaFactura.setCambio(0.0);

        // 6. Almacenar y devolver
        this.listaFacturas.add(nuevaFactura);

        // Actualizar Estado ddel Pedido
        gestorPedido.actualizarPedido(pedidoID, "FACTURADO");

        System.out.println("Factura generada para el pedido " + pedidoID);
        return nuevaFactura;
    }


    @Override
    public double calcularPrecio(Pedido pedido, GestorPromocion gestorPromocion) {

        double subtotal = 0.0;
        if (pedido.getHelados().size() > 0) {
            subtotal = pedido.getHelados().size() * 3.50; //TODO calcularSubtotal
        }

        double descuento = 0.0;

        return subtotal - descuento;
    }


    // --- 5. Métodos de IGestorFacturaHeladero ---

    @Override
        public ReporteVenta generarReporteVenta() {
        double totalVentas = 0.0;
        int facturasProcesadas = 0;

        // Mapas para llevar el conteo
        Map<SaborHelado, Integer> conteoSabor = new HashMap<>();
        Map<TipoRecipiente, Integer> conteoRecipiente = new HashMap<>();

        for (Factura f : this.listaFacturas) {
            if (!f.getTipoPago().equals("ANULADA")) {
                totalVentas += f.getTotal();
                facturasProcesadas++;

                Pedido pedido = f.getPedido();

                if (pedido != null) {
                    // Iterar los helados de ese pedido
                    for (Helado helado : pedido.getHelados()) {

                        TipoRecipiente tr = helado.getRecipiente().getTipo();
                        conteoRecipiente.put(tr, conteoRecipiente.getOrDefault(tr, 0) + 1);

                        // Contar los sabores
                        for (SaborHelado sabor : helado.getSaborHelado()) {
                            conteoSabor.put(sabor, conteoSabor.getOrDefault(sabor, 0) + 1);
                        }
                    }
                }
            }
        }

        // Encontrar el más vendido
        SaborHelado saborMasVendido = conteoSabor.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        TipoRecipiente recipienteMasVendido = conteoRecipiente.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        // Crear el reporte con TODOS los datos (incluyendo los mapas)
        ReporteVenta reporte = new ReporteVenta(
                totalVentas,
                facturasProcesadas,
                saborMasVendido,
                recipienteMasVendido,
                conteoSabor,
                conteoRecipiente
        );

        this.listaReporte.add(reporte);
        return reporte;
    }

    @Override
    public Factura buscarFactura(int idFactura) {
        for (Factura f : this.listaFacturas) {
            if (f.getIdFactura() == idFactura) {
                return f;
            }
        }
        System.err.println("Factura " + idFactura + " no encontrada.");
        return null;
    }

    @Override
    public boolean anularFactura(int idFactura) {
        Factura factura = buscarFactura(idFactura);
        if (factura != null) {
            factura.setTipoPago("ANULADA");
            factura.setPago(0.0);
            factura.setCambio(0.0);
            System.out.println("Factura " + idFactura + " anulada.");
            return true;
        }
        return false;
    }

    private void quemarDatosFacturas(GestorCliente gestorCliente, GestorPedido gestorPedido) {

        // --- Factura 1 (Cliente Ana Gomez, Pedido 1) ---
        Cliente c1 = gestorCliente.buscarCliente("1712345675");
        Pedido p1 = gestorPedido.buscarPedido(1);
        p1.setEstado("FACTURADO");

        // Usamos el constructor completo
        // (El ID '0' es ignorado y se autoincrementa)
        Factura f1 = new Factura(
                p1, c1,
                5.00, // total
                0.60, // iva
                10.00, // pago
                4.40, // cambio
                "EFECTIVO"
        );
        f1.setFechaEmision(new Date());
        this.listaFacturas.add(f1);


        // --- Factura 2 (Cliente Luis Parra, Pedido 2) ---
        Cliente c2 = gestorCliente.buscarCliente("0920012341");
        Pedido p2 = gestorPedido.buscarPedido(2);
        p2.setEstado("FACTURADO");

        Factura f2 = new Factura(
                p2, c2,
                1.50, // total
                0.18, // iva
                1.50, // pago
                0.00, // cambio
                "EFECTIVO"
        );
        f2.setFechaEmision(new Date());
        this.listaFacturas.add(f2);


        // --- Factura 3 (Consumidor Final, Pedido 3) ---
        Cliente c3 = gestorCliente.buscarCliente("9999999999");
        Pedido p3 = gestorPedido.buscarPedido(3);
        p3.setEstado("FACTURADO");

        Factura f3 = new Factura(
                p3, c3,
                2.00, // total (precio del helado de fresa con promo)
                0.24, // iva
                2.00, // pago
                0.00, // cambio
                "EFECTIVO"
        );
        f3.setFechaEmision(new Date());
        this.listaFacturas.add(f3);
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public ArrayList<ReporteVenta> getListaReporte() {
        return listaReporte;
    }
}