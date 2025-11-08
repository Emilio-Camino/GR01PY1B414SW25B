package facturacion.gestores;

import facturacion.elementos.BolaHelado;
import facturacion.elementos.Helado;
import facturacion.elementos.Pedido;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GestorPedido {
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public boolean iniciarNuevoPedido(int idPedido, String estado, List<Helado> helados, GestorStock gestorStock) {
        int nuevaId = obtenerUltimoIdPedido() + 1;
        Map<SaborHelado, Integer> stockAnterior = gestorStock.getStockSabores();
        Map<TipoRecipiente, Integer> stockRecipienteAnterior = gestorStock.getStockRecipiente();

        for (Helado helado : helados) {
            TipoRecipiente tipo = helado.getRecipiente().getTipo();
            List<BolaHelado> bolasHelado = helado.getBolasHelado();

            if (gestorStock.buscarRecipiente(tipo) <= 0) {
                System.out.println("No hay el recipiente indicado: " + tipo);
                gestorStock.setStockRecipiente(stockRecipienteAnterior);
                return false;
            }

            gestorStock.actualizarRecipiente(tipo, gestorStock.buscarRecipiente(tipo) - 1);

            for (BolaHelado bola : bolasHelado) {
                int bolasRestantes = gestorStock.buscarBolasHelado(bola.getSabor());
                if (bolasRestantes <= 0) {
                    System.out.println("No hay bolas de " + bola.getSabor());
                    gestorStock.setStockSabores(stockAnterior);
                    return false;
                }
                gestorStock.actualizarHelados(bola.getSabor(), bolasRestantes - 1);
            }
        }

        Pedido nuevoPedido = new Pedido(nuevaId, estado);
        SaborHelado[] sabores =  new SaborHelado[3];
        for (Helado helado : helados) {
            for(int i = 0; i < 3; i++){
                sabores[i] = helado.getBolasHelado().get(i).getSabor();
            }
            nuevoPedido.agregarHelado(helado.getRecipiente().getTipo(), helado.getBolasHelado().size(), sabores);
        }
        pedidos.add(nuevoPedido);
        System.out.println("Pedido añadido satisfactoriamente");
        return true;
    }

    public Pedido buscarPedido(int id){
        for(Pedido pedido : pedidos){
            if(pedido.getPedidoID() == id){
                return pedido;
            }
        }
        return null;
    }

    public boolean actualizarPedido(int idPedido, String estado, List<Helado> helados, GestorStock gestorStock){
    return false;
    }

    public boolean eliminarPedido(int id){
        Pedido pedidoEliminar = buscarPedido(id);
        if(pedidoEliminar != null){
            pedidos.remove(pedidoEliminar);
            return true;
        }
        return false;
    }

    //Método que sirve para obtener cuál es la ID del ultimo registro en la lista de pedidos
    public int obtenerUltimoIdPedido() {
        if (getPedidos().isEmpty()) {
            return 0;
        }
        Pedido ultimo = getPedidos().get(getPedidos().size() - 1);
        return ultimo != null ? ultimo.getPedidoID() : 0;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
