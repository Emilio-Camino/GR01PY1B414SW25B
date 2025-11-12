package facturacion.persistencia;

import facturacion.elementos.Pedido;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

import java.util.ArrayList;

public class PedidoPersist {

    //Lista estática única que almacena todos los pedidos de la aplicación.

    private static ArrayList<Pedido> listaPedidos;

    //Bloque estático para inicializar la lista y cargar los datos

    static {
        listaPedidos = new ArrayList<>();
        quemarDatosPedidos();
    }

    /**
     * Agrega un nuevo pedido a la lista de persistencia.
     * @param pedido El objeto Pedido a agregar.
     */
    public static void agregarPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    /**
     * Busca un pedido en la lista por su ID.
     * @param pedidoID El ID del pedido a buscar.
     * @return El objeto Pedido si se encuentra, o null si no existe.
     */
    public static Pedido buscarPedido(int pedidoID) {
        for (Pedido pedido : listaPedidos) {
            if (pedido.getPedidoID() == pedidoID) {
                return pedido; // Encontrado
            }
        }
        return null; // No encontrado
    }

    /**
     * Elimina un pedido de la lista usando su ID.
     * @param pedidoID El ID del pedido a eliminar.
     * @return true si el pedido fue encontrado y eliminado, false en caso contrario.
     */
    public static boolean eliminarPedido(int pedidoID) {
        return listaPedidos.removeIf(
                pedido -> pedido.getPedidoID() == pedidoID
        );
    }

    /**
     * Devuelve una copia de la lista de todos los pedidos.
     * @return Un ArrayList<Pedido> con todos los pedidos registrados.
     */
    public static ArrayList<Pedido> getListaPedidos() {
        return new ArrayList<>(listaPedidos);
    }

    /**
     * Carga datos de ejemplo en la lista de pedidos.
     */
    private static void quemarDatosPedidos() {
        // --- Pedido 1 (para Factura 1) ---
        Pedido p1 = new Pedido();
        SaborHelado[] saboresH1 = {SaborHelado.CHOCOLATE, SaborHelado.VAINILLA};
        p1.agregarHelado(TipoRecipiente.CONO, 2, saboresH1);
        SaborHelado[] saboresH2 = {SaborHelado.FRESA, SaborHelado.COOKIESNCREAM, SaborHelado.RONPASAS};
        p1.agregarHelado(TipoRecipiente.TULIPAN, 3, saboresH2);
        p1.asignarIDFinal();
        listaPedidos.add(p1);

        // --- Pedido 2 (para Factura 2) ---
        Pedido p2 = new Pedido();
        SaborHelado[] saboresH3 = {SaborHelado.CHICLE};
        p2.agregarHelado(TipoRecipiente.VASO, 1, saboresH3);
        p2.asignarIDFinal();
        listaPedidos.add(p2);

        // --- Pedido 3 (para Factura 3) ---
        Pedido p3 = new Pedido();
        SaborHelado[] saboresH4 = {SaborHelado.FRESA};
        p3.agregarHelado(TipoRecipiente.CONO, 1, saboresH4);
        p3.asignarIDFinal();
        listaPedidos.add(p3);
    }
}