package facturacion.gestores;

// Importaciones de Java
import java.util.ArrayList;
import facturacion.elementos.enumeraciones.*;

// Importaciones de elementos
import facturacion.elementos.Pedido;
import facturacion.gestores.interfaces.IGestorPedido;

import javax.swing.*;


public class GestorPedido implements IGestorPedido {

    // --- 1. Atributos ---
    private ArrayList<Pedido> listaPedidos;

    // --- 2. Constructor ---
    public GestorPedido() {
        // Inicializamos la lista
        this.listaPedidos = new ArrayList<>();
        quemarDatosPedidos();
    }


    private void quemarDatosPedidos() {

        // --- Pedido 1 (para Factura 1) ---
        Pedido p1 = new Pedido();

        // Helado 1.1: Cono con Chocolate y Vainilla
        SaborHelado[] saboresH1 = {SaborHelado.CHOCOLATE, SaborHelado.VAINILLA};
        p1.agregarHelado(TipoRecipiente.CONO, 2, saboresH1);

        // Helado 1.2: Tulipán con Fresa, CookiesNCreate y RonPasas
        SaborHelado[] saboresH2 = {SaborHelado.FRESA, SaborHelado.COOKIESNCREAM, SaborHelado.RONPASAS};
        p1.agregarHelado(TipoRecipiente.TULIPAN, 3, saboresH2);

        this.listaPedidos.add(p1);

        // --- Pedido 2 (para Factura 2) ---
        Pedido p2 = new Pedido();
        // Helado 2.1: Vaso con Chicle
        SaborHelado[] saboresH3 = {SaborHelado.CHICLE};
        p2.agregarHelado(TipoRecipiente.VASO, 1, saboresH3);

        this.listaPedidos.add(p2);

        // --- Pedido 3 (para Factura 3) ---
        Pedido p3 = new Pedido();
        // Helado 3.1: Cono con Fresa (para probar la promoción)
        SaborHelado[] saboresH4 = {SaborHelado.FRESA};
        p3.agregarHelado(TipoRecipiente.CONO, 1, saboresH4);

        this.listaPedidos.add(p3);
    }

    // --- 3. Métodos del Diagrama (con lógica) ---

    /**
     * Inicia un nuevo pedido vacío y lo añade a la lista.
     * Usa el constructor de Pedido.java.
     * @return El Pedido recién creado.
     */
    @Override
    public void iniciarNuevoPedido(Pedido pedidoNuevo) {
        // Añadimos el pedido a nuestra lista
        this.listaPedidos.add(pedidoNuevo);
        JOptionPane.showMessageDialog(null, "Se añadió el pedido.");
    }

    /**
     * Busca un pedido en la lista usando su ID.
     * @param pedidoID El ID del pedido a buscar.
     * @return El Pedido si se encuentra, o null si no.
     */
    @Override
    public Pedido buscarPedido(int pedidoID) {
        for (Pedido pedido : this.listaPedidos) {
            // Usamos el getter de tu clase Pedido
            if (pedido.getPedidoID() == pedidoID) {
                return pedido; // Encontrado
            }
        }
        return null; // No encontrado
    }

    /**
     * Actualiza el estado de un pedido existente.
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
     * @param pedidoID El ID del pedido a eliminar.
     */
    public void eliminarPedido(int pedidoID) {
        
        // Usamos removeIf con la cédula
        boolean eliminado = this.listaPedidos.removeIf(
            pedido -> pedido.getPedidoID() == pedidoID
        );

        if (eliminado) {
            System.out.println("Pedido " + pedidoID + " eliminado.");
        } else {
            System.out.println("No se pudo eliminar: Pedido " + pedidoID + " no encontrado.");
        }
    }
}