package facturacion.gestores;

// Importaciones de Elementos (Entidades)
import facturacion.elementos.Factura;
import facturacion.elementos.ReporteVenta;
import facturacion.elementos.Pedido;
import facturacion.elementos.Cliente;  
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

// Importaciones de Interfaces
import facturacion.gestores.interfaces.IGestorFacturaHeladero;
import facturacion.gestores.interfaces.IGestorFacturaCajero;

// Importaciones de Gestores
import facturacion.gestores.GestorClientes;
import facturacion.gestores.GestorCaja;
import facturacion.gestores.GestorPedido;
import facturacion.gestores.GestorPromocion;

// Importaciones de Java
import java.util.ArrayList;
import java.util.Date; // <-- Importado
import java.util.List;

public class GestorFactura implements IGestorFacturaHeladero, IGestorFacturaCajero {

    // --- 1. Atributos Internos ---
    private List<Factura> listaFacturas;
    private List<ReporteVenta> listaReporte;

    // --- 2. Dependencias ---
    private GestorClientes gestorClientes;
    private GestorCaja gestorCaja;
    private GestorPedido gestorPedido;
    private GestorPromocion gestorPromocion;

    // --- 3. Constructor ---
    public GestorFactura(GestorClientes gestorClientes, GestorCaja gestorCaja,
                         GestorPedido gestorPedido, GestorPromocion gestorPromocion) {
        
        this.listaFacturas = new ArrayList<>();
        this.listaReporte = new ArrayList<>();

        // Asigna dependencias (Punto 2)
        this.gestorClientes = gestorClientes;
        this.gestorCaja = gestorCaja;
        this.gestorPedido = gestorPedido;
        this.gestorPromocion = gestorPromocion;
    }

    // --- 4. Métodos de IGestorFacturaCajero ---

    /**
     * Lógica para generar una factura.
     * USA las dependencias: "consulta" a GestorPedido y "busca" a GestorClientes.
     */
    @Override
    public Factura generarFactura(int pedidoID, String clienteCedula) {
        
        // 1. "consulta" (Dependencia de GestorPedido)
        Pedido pedidoAFacturar = gestorPedido.buscarPedido(pedidoID);
        
        // 2. "busca" (Dependencia de GestorClientes)
        Cliente clienteFactura = gestorClientes.buscarCliente(clienteCedula);

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
        double totalCalculado = this.calcularPrecio(pedidoAFacturar);
        
        // TODO: Aquí deberíamos calcular el IVA
        double iva = totalCalculado * 0.12; // Asumiendo 12%

        // 5. Crear la Factura (Usando el constructor vacío que añadimos)
        Factura nuevaFactura = new Factura();
        nuevaFactura.setFechaEmision(new Date()); // Tu constructor vacío lo hace, pero lo re-aseguramos
        
        // Usamos el contador estático de Factura.java
        // (Aunque tu constructor original lo hacía, el vacío no)
        // nuevaFactura.setIdFactura(...); // Tu clase Factura lo maneja con 'contadorFactura'
        
        nuevaFactura.setPedidos(pedidoAFacturar);
        nuevaFactura.setCliente(clienteFactura);
        nuevaFactura.setTotal(totalCalculado);
        nuevaFactura.setImpuestoIVA(iva);

        // Dejamos los campos de pago pendientes
        nuevaFactura.setTipoPago("PENDIENTE");
        nuevaFactura.setPago(0.0);
        nuevaFactura.setCambio(0.0);

        // 6. Almacenar y devolver
        this.listaFacturas.add(nuevaFactura);
        
        // Actualizamos el estado del pedido
        this.gestorPedido.actualizarPedido(pedidoID, "FACTURADO");
        
        System.out.println("Factura generada para el pedido " + pedidoID);
        return nuevaFactura;
    }

    /**
     * Lógica para calcular el precio.
     * USA las dependencias: "obtiene total" y "GestorPromocion".
     */
    @Override
    public double calcularPrecio(Pedido pedido) {
        // 1. "obtiene total" (Asumimos que el "total" viene del Pedido)
        // TODO: Necesitas un método 'getSubtotal()' en tu clase Pedido
        // que sume los precios de this.helados.
        // double subtotal = pedido.getSubtotal(); 
        
        // *** SOLUCIÓN TEMPORAL mientras añades getSubtotal() a Pedido ***
        // Vamos a calcular el subtotal aquí (aunque debería hacerlo Pedido)
        double subtotal = 0.0;
        // Asumimos que la clase Helado tiene un getPrecio()
        // for (Helado helado : pedido.getHelados()) {
        //     subtotal += helado.getPrecio();
        // }
        // Si no tenemos getPrecio(), usaremos un valor temporal:
        if (pedido.getHelados().size() > 0) {
             subtotal = pedido.getHelados().size() * 3.50; // $3.50 por helado (temporal)
        }
        
        // 2. "GestorPromocion" (Dependencia)
        // TODO: Lógica de GestorPromocion
        // Promocion promo = gestorPromocion.buscarPromocionAplicable(pedido);
        // double descuento = promo.calcularDescuento(subtotal);
        double descuento = 0.0; // Sin promoción por ahora

        return subtotal - descuento;
    }


    // --- 5. Métodos de IGestorFacturaHeladero ---

    @Override
    public ReporteVenta generarReporteVenta() {
        // Lógica simple de reporte: Suma el total de todas las facturas
        double totalVentas = 0.0;
        int facturasProcesadas = 0;
        
        // TODO: Lógica para encontrar el sabor/recipiente más vendido
        // Necesitaríamos Mapas (HashMap) para contar cada sabor y recipiente
        // Map<SaborHelado, Integer> contadorSabores = new HashMap<>();
        // Map<TipoRecipiente, Integer> contadorRecipientes = new HashMap<>();

        for (Factura f : this.listaFacturas) {
            // No sumar facturas anuladas
            if (!f.getTipoPago().equals("ANULADA")) {
                totalVentas += f.getTotal();
                facturasProcesadas++;
                
                // TODO: Aquí iría la lógica de conteo
                // Pedido p = f.getPedido();
                // for (Helado h : p.getHelados()) {
                //    ... (contar recipiente y bolas de sabor) ...
                // }
            }
        }
        
        System.out.println("Reporte generado: " + totalVentas + " en " + facturasProcesadas + " facturas.");

        // --- INICIO DE LA CORRECCIÓN ---
        
        // TODO: Implementar la lógica de búsqueda del más vendido.
        // Por ahora, pasamos 'null' como placeholder.
        SaborHelado saborMasVendido = null; 
        TipoRecipiente recipienteMasVendido = null;

        // Usamos el constructor que SÍ existe en ReporteVenta.java
        ReporteVenta reporte = new ReporteVenta(
            totalVentas, 
            saborMasVendido, 
            recipienteMasVendido
        ); 

        // --- FIN DE LA CORRECCIÓN ---
        
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
    public void anularFactura(int idFactura) {
        Factura factura = buscarFactura(idFactura);
        if (factura != null) {
            // Usamos el 'tipoPago' para marcarla como anulada
            // (Sería mejor tener un campo 'estado')
            factura.setTipoPago("ANULADA");
            
            // TODO: Devolver el pedido al estado "EN_PROCESO"
            // Pedido p = factura.getPedido();
            // gestorPedido.actualizarPedido(p.getPedidoID(), "EN_PROCESO");
            
            System.out.println("Factura " + idFactura + " anulada.");
        }
    }
}