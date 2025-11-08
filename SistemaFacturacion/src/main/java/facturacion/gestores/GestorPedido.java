package facturacion.gestores;

// Importaciones de Java
import java.util.ArrayList;
import java.util.List;

// Importaciones de elementos
import facturacion.elementos.Pedido;

/**
 * GestorPedido: Se encarga de la creación, búsqueda,
 * actualización y eliminación de pedidos.
 */
public class GestorPedido {

    // --- 1. Atributos ---
    private List<Pedido> pedidos;

    // --- 2. Constructor ---
    public GestorPedido() {
        // Inicializamos la lista
        this.pedidos = new ArrayList<>();
    }
    
    // --- 3. Métodos del Diagrama (con lógica) ---

    /**
     * Inicia un nuevo pedido vacío y lo añade a la lista.
     * Usa el constructor de Pedido.java.
     * @return El Pedido recién creado.
     */
    public Pedido iniciarNuevoPedido() {
        // Tu constructor de Pedido pide un ID (que ignora) y un estado inicial.
        // Le pasamos '0' como ID dummy y "EN_PROCESO" como estado inicial.
        Pedido nuevoPedido = new Pedido(0, "EN_PROCESO");
        
        // Añadimos el pedido a nuestra lista
        this.pedidos.add(nuevoPedido);
        
        System.out.println("Nuevo pedido iniciado. ID: " + nuevoPedido.getPedidoID());
        return nuevoPedido;
    }

    /**
     * Busca un pedido en la lista usando su ID.
     * (Modificamos el método para que acepte el ID).
     * @param pedidoID El ID del pedido a buscar.
     * @return El Pedido si se encuentra, o null si no.
     */
    public Pedido buscarPedido(int pedidoID) {
        for (Pedido pedido : this.pedidos) {
            // Usamos el getter de tu clase Pedido
            if (pedido.getPedidoID() == pedidoID) {
                return pedido; // Encontrado
            }
        }
        return null; // No encontrado
    }

    /**
     * Actualiza el estado de un pedido existente.
     * (Modificamos el método para que acepte el ID y el nuevo estado).
     * @param pedidoID El ID del pedido a actualizar.
     * @param nuevoEstado El nuevo estado (ej: "COMPLETADO", "FACTURADO").
     */
    public void actualizarPedido(int pedidoID, String nuevoEstado) {
        // 1. Usamos nuestro método de búsqueda
        Pedido pedidoAActualizar = buscarPedido(pedidoID);

        // 2. Verificamos si se encontró
        if (pedidoAActualizar != null) {
            // 3. Usamos el setter de tu clase Pedido
            pedidoAActualizar.setEstado(nuevoEstado);
            System.out.println("Pedido " + pedidoID + " actualizado a estado: " + nuevoEstado);
        } else {
            System.out.println("No se pudo actualizar: Pedido " + pedidoID + " no encontrado.");
        }
    }

    /**
     * Elimina un pedido de la lista usando su ID.
     * (Modificamos el método para que acepte el ID).
     * @param pedidoID El ID del pedido a eliminar.
     */
    public void eliminarPedido(int pedidoID) {
        
        // Usamos removeIf con la cédula
        boolean eliminado = this.pedidos.removeIf(
            pedido -> pedido.getPedidoID() == pedidoID
        );

        if (eliminado) {
            System.out.println("Pedido " + pedidoID + " eliminado.");
        } else {
            System.out.println("No se pudo eliminar: Pedido " + pedidoID + " no encontrado.");
        }
    }
}