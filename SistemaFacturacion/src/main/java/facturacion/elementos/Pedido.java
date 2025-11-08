package facturacion.elementos;

import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

import java.util.ArrayList;

public class Pedido {

    private static int contadorPedido = 0;
    private int pedidoID;
    private String estado;
    private ArrayList<Helado> helados;

    public Pedido(int pedidoID, String estado) {
        this.pedidoID = ++contadorPedido;
        this.estado = estado;
        this.helados = new ArrayList<>();
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Helado> getHelados() {
        return helados;
    }

    public void setHelados(ArrayList<Helado> helados) {
        this.helados = helados;
    }

    public void agregarHelado(TipoRecipiente tipo, int numBolas, SaborHelado[] sabores) {
        Helado nuevoHelado = new Helado(tipo);
        for (int i = 0; i < numBolas; i++) {
            nuevoHelado.agregarBola(sabores[i]);
        }
        this.helados.add(nuevoHelado);
    }

}

