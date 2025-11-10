package facturacion.gestores;

// Importaciones de Elementos (Entidades)
import facturacion.elementos.Factura;
import facturacion.elementos.ReporteVenta;
import facturacion.elementos.Pedido;
import facturacion.elementos.Cliente;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

// Importaciones de Interfaces
// Nota: Estas interfaces tendrían que ser refactorizadas también
// para que coincidan con las nuevas firmas de los métodos.
import facturacion.gestores.interfaces.IGestorFacturaHeladero;
import facturacion.gestores.interfaces.IGestorFacturaCajero;

// Importaciones de Java
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase refactorizada para usar "Uso" (parámetros de método)
 * en lugar de "Agregación" (campos).
 */
public class GestorFactura implements IGestorFacturaHeladero, IGestorFacturaCajero {

    private ArrayList<Factura> listaFacturas;
    private ArrayList<ReporteVenta> listaReporte;


    // --- 3. Constructor ---
    public GestorFactura(GestorCliente gestorCliente, GestorPedido gestorPedido) {
        // Constructor ahora solo inicializa sus propias listas
        this.listaFacturas = new ArrayList<>();
        this.listaReporte = new ArrayList<>();
        quemarDatosFacturas(gestorCliente, gestorPedido);
    }

    // --- 4. Métodos de IGestorFacturaCajero ---

    /**
     * Lógica para generar una factura.
     * USA las dependencias: "consulta" a GestorPedido y "busca" a GestorClientes
     * pasadas como parámetros.
     */
    // @Override // <-- Comentado, la firma del método en la interfaz ya no coincide
    public Factura generarFactura(int pedidoID, String clienteCedula,
                                  GestorPedido gestorPedido, GestorCliente gestorCliente,
                                  GestorPromocion gestorPromocion) {

        // 1. "consulta" (Dependencia de GestorPedido)
        Pedido pedidoAFacturar = gestorPedido.buscarPedido(pedidoID); // Usa el parámetro

        // 2. "busca" (Dependencia de GestorClientes)
        Cliente clienteFactura = gestorCliente.buscarCliente(clienteCedula); // Usa el parámetro

        // 3. Verificación
        if (pedidoAFacturar == null) {
            System.err.println("Error: No se encontró el pedido con ID " + pedidoID);
            return null;
        }
        if (clienteFactura == null) {
            System.err.println("Error: No se encontró el cliente con cédula " + clienteCedula);
            return null;
        }

        // 4. Calcular el precio
        // Pasa la dependencia 'gestorPromocion' al método que la necesita
        double totalCalculado = this.calcularPrecio(pedidoAFacturar, gestorPromocion);

        // TODO: Aquí deberíamos calcular el IVA
        double iva = totalCalculado * 0.12; // Asumiendo 12%

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

        // Actualizamos el estado del pedido usando el parámetro
        gestorPedido.actualizarPedido(pedidoID, "FACTURADO");

        System.out.println("Factura generada para el pedido " + pedidoID);
        return nuevaFactura;
    }

    /**
     * Lógica para calcular el precio.
     * USA la dependencia: "GestorPromocion" pasada como parámetro.
     */
    // @Override // <-- Comentado, la firma del método en la interfaz ya no coincide
    public double calcularPrecio(Pedido pedido, GestorPromocion gestorPromocion) {

        // ... (Lógica de cálculo de subtotal) ...
        double subtotal = 0.0;
        if (pedido.getHelados().size() > 0) {
            subtotal = pedido.getHelados().size() * 3.50; // $3.50 por helado (temporal)
        }

        // 2. "GestorPromocion" (Dependencia usada como parámetro)
        // TODO: Lógica de GestorPromocion
        // Promocion promo = gestorPromocion.buscarPromocionAplicable(pedido); // Usa el parámetro

        double descuento = 0.0; // Sin promoción por ahora

        return subtotal - descuento;
    }


    // --- 5. Métodos de IGestorFacturaHeladero ---

    // @Override // <-- No requiere gestores externos, la firma no cambia
    public ReporteVenta generarReporteVenta() {
        // Lógica simple de reporte: Suma el total de todas las facturas
        double totalVentas = 0.0;
        int facturasProcesadas = 0;

        // ... (Lógica interna del reporte) ...

        for (Factura f : this.listaFacturas) {
            if (!f.getTipoPago().equals("ANULADA")) {
                totalVentas += f.getTotal();
                facturasProcesadas++;
            }
        }

        System.out.println("Reporte generado: " + totalVentas + " en " + facturasProcesadas + " facturas.");

        SaborHelado saborMasVendido = null;
        TipoRecipiente recipienteMasVendido = null;

        ReporteVenta reporte = new ReporteVenta(
                totalVentas,
                saborMasVendido,
                recipienteMasVendido
        );

        this.listaReporte.add(reporte);
        return reporte;
    }

    // @Override // <-- No requiere gestores externos, la firma no cambia
    public Factura buscarFactura(int idFactura) {
        for (Factura f : this.listaFacturas) {
            if (f.getIdFactura() == idFactura) {
                return f;
            }
        }
        System.err.println("Factura " + idFactura + " no encontrada.");
        return null;
    }

    // @Override // <-- Comentado, la firma del método en la interfaz ya no coincide
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
        Cliente c1 = gestorCliente.buscarCliente("1755580402");
        Pedido p1 = gestorPedido.buscarPedido(1); // El primer pedido que creamos
        p1.setEstado("FACTURADO"); // Actualizamos el estado del pedido

        // Usamos el constructor completo
        // (El ID '0' es ignorado y se autoincrementa)
        Factura f1 = new Factura(
                0, p1, c1,
                5.00, // total
                0.60, // iva
                10.00, // pago
                4.40, // cambio
                "EFECTIVO"
        );
        f1.setFechaEmision(new Date()); // El constructor completo no asigna fecha
        this.listaFacturas.add(f1);


        // --- Factura 2 (Cliente Luis Parra, Pedido 2) ---
        Cliente c2 = gestorCliente.buscarCliente("1755580428");
        Pedido p2 = gestorPedido.buscarPedido(2);
        p2.setEstado("FACTURADO");

        Factura f2 = new Factura(
                0, p2, c2,
                1.50, // total
                0.18, // iva
                1.50, // pago
                0.00, // cambio
                "TARJETA"
        );
        f2.setFechaEmision(new Date());
        this.listaFacturas.add(f2);


        // --- Factura 3 (Consumidor Final, Pedido 3) ---
        Cliente c3 = gestorCliente.buscarCliente("9999999999");
        Pedido p3 = gestorPedido.buscarPedido(3);
        p3.setEstado("FACTURADO");

        Factura f3 = new Factura(
                0, p3, c3,
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