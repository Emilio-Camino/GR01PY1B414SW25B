package facturacion.gestores.interfaces;

import facturacion.elementos.Pedido;

public interface IGestorPedido {
    public void actualizarPedido(int pedidoID, String nuevoEstado);
    public void eliminarPedido(int pedidoID);
    public Pedido buscarPedido(int pedidoID);
    public void iniciarNuevoPedido(Pedido pedidoNuevo);
}
