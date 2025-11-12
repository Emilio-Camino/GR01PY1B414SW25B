package facturacion.gestores;

import facturacion.elementos.Helado;
import facturacion.elementos.Pedido;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;
import facturacion.gestores.interfaces.IGestorPedido;
import facturacion.gestores.interfaces.IGestorStockCajero; // Importar
import facturacion.persistencia.PedidoPersist;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GestorPedido implements IGestorPedido {

    private Pedido pedidoEnConstruccion; // El "carrito" ahora vive aquí
    private IGestorStockCajero gestorStock;

    /**
     * Constructor que recibe la dependencia del GestorStock.
     * @param gestorStock Una instancia de IGestorStockCajero.
     */
    public GestorPedido(IGestorStockCajero gestorStock) {
        this.gestorStock = gestorStock;
        // La persistencia se maneja estáticamente
    }

    // --- MÉTODOS DEL "CARRITO" ---

    @Override
    public void iniciarNuevoPedido() {
        this.pedidoEnConstruccion = new Pedido(); // Crea un carrito vacío
    }

    @Override
    public boolean agregarHelado(TipoRecipiente tipo, ArrayList<SaborHelado> sabores) {

        // 1. Lógica de validación de stock (MOVIDA DESDE VENTANACAJERO)
        Map<SaborHelado, Integer> conteoRequerido = new HashMap<>();
        for (SaborHelado sabor : sabores) {
            conteoRequerido.put(sabor, conteoRequerido.getOrDefault(sabor, 0) + 1);
        }

        // 2. Verificar Stock de Sabores
        for (Map.Entry<SaborHelado, Integer> entry : conteoRequerido.entrySet()) {
            if (!verificarStockSabor(entry.getKey(), entry.getValue())) {
                return false; // El método interno ya mostró el error
            }
        }

        // 3. Verificar Stock de Recipiente
        if (!verificarStockRecipiente(tipo, 1)) {
            return false; // El método interno ya mostró el error
        }

        // 4. Si hay stock, DECREMENTAR stock y CREAR el helado
        Helado nuevoHelado = new Helado(tipo);
        gestorStock.decrementarStockRecipiente(tipo, 1);

        for (SaborHelado sabor : sabores) {
            nuevoHelado.agregarBola(sabor);
            gestorStock.decrementarStockSabor(sabor, 1);
        }

        // 5. Agregar al pedido en construcción
        this.pedidoEnConstruccion.getHelados().add(nuevoHelado);
        return true;
    }

    @Override
    public boolean eliminarHelado(int pedidoID) {
        if (pedidoID < 0 || pedidoID >= this.pedidoEnConstruccion.getHelados().size()) {
            return false; // Índice no válido
        }

        // 1. Obtener el helado que se va a eliminar
        Helado heladoElim = this.pedidoEnConstruccion.getHelados().get(pedidoID);

        // 2. Lógica de RESTOCK (MOVIDA DESDE VENTANACAJERO)
        for (SaborHelado sabor : heladoElim.getSaborHelado()) {
            gestorStock.aumentarStockSabor(sabor, 1);
        }
        gestorStock.aumentarStockRecipiente(heladoElim.getRecipiente().getTipo(), 1);

        // 3. Eliminar helado del carrito
        this.pedidoEnConstruccion.getHelados().remove(pedidoID);
        return true;
    }

    @Override
    public ArrayList<Helado> getHeladosDelPedidoActual() {
        return this.pedidoEnConstruccion.getHelados();
    }

    @Override
    public Pedido registrarPedidoActual() {
        if (this.pedidoEnConstruccion.getHelados().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay helados en el pedido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        //1. Asignar el ID final al pedido
        this.pedidoEnConstruccion.asignarIDFinal();

        // 1. Guardar el pedido en persistencia
        PedidoPersist.agregarPedido(this.pedidoEnConstruccion);

        // Lógica de feedback (MOVIDA DESDE VENTANACAJERO)
        JOptionPane.showMessageDialog(null, "Se añadió el pedido #" + this.pedidoEnConstruccion.getPedidoID() + ".");

        Pedido guardado = this.pedidoEnConstruccion;

        // 2. Resetear el carrito para el siguiente cliente
        iniciarNuevoPedido();

        return guardado;
    }

    /**
     * Devuelve todos los ítems del carrito al stock y resetea el carrito.
     * Esto se llama cuando el usuario "abandona" el carrito (ej. cierra la ventana).
     */
    @Override
    public void cancelarPedidoActual() {
        if (this.pedidoEnConstruccion != null && !this.pedidoEnConstruccion.getHelados().isEmpty()) {

            // Itera sobre cada helado en el carrito
            for (Helado helado : this.pedidoEnConstruccion.getHelados()) {

                // Devuelve los sabores de ese helado al stock
                for (SaborHelado sabor : helado.getSaborHelado()) {
                    gestorStock.aumentarStockSabor(sabor, 1);
                }

                // Devuelve el recipiente de ese helado al stock
                gestorStock.aumentarStockRecipiente(helado.getRecipiente().getTipo(), 1);
            }
        }

        // Finalmente, crea un nuevo carrito vacio
        iniciarNuevoPedido();
    }

    // --- MÉTODOS DE PEDIDOS GUARDADOS ---

    @Override
    public Pedido buscarPedido(int pedidoID) {
        return PedidoPersist.buscarPedido(pedidoID);
    }

    @Override
    public void actualizarPedido(int pedidoID, String nuevoEstado) {
        Pedido pedidoAActualizar = PedidoPersist.buscarPedido(pedidoID);
        if (pedidoAActualizar != null) {
            pedidoAActualizar.setEstado(nuevoEstado);
            System.out.println("Pedido " + pedidoID + " actualizado a estado: " + nuevoEstado);
        } else {
            System.out.println("No se pudo actualizar: Pedido " + pedidoID + " no encontrado.");
        }
    }

    @Override
    public void eliminarPedido(int pedidoID) {
        boolean eliminado = PedidoPersist.eliminarPedido(pedidoID);
        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Pedido " + pedidoID + " eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar: Pedido " + pedidoID + " no encontrado.");
        }
    }

    // --- MÉTODOS PRIVADOS DE AYUDA

    private boolean verificarStockSabor(SaborHelado sabor, int cantidadRequerida) {
        int stockDisponible = gestorStock.buscarBolasHelado(sabor);
        if (cantidadRequerida > stockDisponible) {
            JOptionPane.showMessageDialog(null,
                    "¡Stock insuficiente para " + sabor + "!\n" +
                            "Requerido: " + cantidadRequerida + "\n" +
                            "Disponible: " + stockDisponible,
                    "Error de Stock",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean verificarStockRecipiente(TipoRecipiente tipo, int cantidadRequerida) {
        int stockDisponible = gestorStock.buscarRecipiente(tipo);
        if (cantidadRequerida > stockDisponible) {
            JOptionPane.showMessageDialog(null,
                    "¡Stock insuficiente para " + tipo + "!\n" +
                            "Requerido: " + cantidadRequerida + "\n" +
                            "Disponible: " + stockDisponible,
                    "Error de Stock",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}