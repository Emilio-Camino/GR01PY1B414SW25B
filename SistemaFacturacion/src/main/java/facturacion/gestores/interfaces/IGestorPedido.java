package facturacion.gestores.interfaces;

import facturacion.elementos.Helado;
import facturacion.elementos.Pedido;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

import java.util.ArrayList;

public interface IGestorPedido {
    public void actualizarPedido(int pedidoID, String nuevoEstado);
    public boolean agregarHelado(TipoRecipiente tipo, ArrayList<SaborHelado> sabores);
    public ArrayList<Helado> getHeladosDelPedidoActual();
    public Pedido registrarPedidoActual();
    public Pedido buscarPedido(int pedidoID);
    public void iniciarNuevoPedido();
    public void eliminarPedido(int pedidoID);
    public boolean eliminarHelado(int indice);
    public void cancelarPedidoActual();
}
