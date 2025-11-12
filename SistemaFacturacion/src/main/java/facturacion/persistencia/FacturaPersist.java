package facturacion.persistencia;

import facturacion.elementos.Cliente;
import facturacion.elementos.Factura;
import facturacion.elementos.Pedido;

import java.util.ArrayList;
import java.util.Date;

public class FacturaPersist {

    private static ArrayList<Factura> listaFacturas = new ArrayList<>();

    static {

        quemarDatosFacturas();
    }

    public static void agregarFactura(Factura factura) {
        listaFacturas.add(factura);
    }

    public static Factura buscarFactura(int idFactura) {
        for (Factura f : listaFacturas) {
            if (f.getIdFactura() == idFactura) {
                return f;
            }
        }
        return null;
    }

    public static ArrayList<Factura> getListaFacturas() {
        return new ArrayList<>(listaFacturas);
    }

    //Carga datos quemados. Ahora usa las clases Persist
    private static void quemarDatosFacturas() {

        // --- Factura 1 (Cliente Ana Gomez, Pedido 1) ---
        Cliente c1 = ClientePersist.buscarCliente("1712345675");
        Pedido p1 = PedidoPersist.buscarPedido(1);
        if (p1 != null) p1.setEstado("FACTURADO");

        Factura f1 = new Factura(p1, c1, 5.00, 0.60, 10.00, 4.40, "EFECTIVO");
        f1.setFechaEmision(new Date());
        f1.asignarIDFinal(); // Asigna ID 1
        listaFacturas.add(f1);

        // --- Factura 2 (Cliente Luis Parra, Pedido 2) ---
        Cliente c2 = ClientePersist.buscarCliente("0920012341");
        Pedido p2 = PedidoPersist.buscarPedido(2);
        if (p2 != null) p2.setEstado("FACTURADO");

        Factura f2 = new Factura(p2, c2, 1.50, 0.18, 1.50, 0.00, "EFECTIVO");
        f2.setFechaEmision(new Date());
        f2.asignarIDFinal(); // Asigna ID 2
        listaFacturas.add(f2);

        // --- Factura 3 (Consumidor Final, Pedido 3) ---
        Cliente c3 = ClientePersist.buscarCliente("9999999999");
        Pedido p3 = PedidoPersist.buscarPedido(3);
        if (p3 != null) p3.setEstado("FACTURADO");

        Factura f3 = new Factura(p3, c3, 2.00, 0.24, 2.00, 0.00, "EFECTIVO");
        f3.setFechaEmision(new Date());
        f3.asignarIDFinal(); // Asigna ID 3
        listaFacturas.add(f3);
    }
}