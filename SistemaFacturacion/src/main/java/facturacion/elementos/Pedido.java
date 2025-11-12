package facturacion.elementos;

import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

import java.util.ArrayList;

public class Pedido {

    private static int contadorPedido = 0;
    private int pedidoID;
    private String estado;
    private ArrayList<Helado> helados;

    //El constructor vacio permite que el gestor cree un pedido temporal (el recibir un llamado de la interfaz) sin que se afecte el contador de pedido
    public Pedido() {
        this.pedidoID = 0;
        this.estado = "RECIBIDO";
        this.helados = new ArrayList<>();
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void asignarIDFinal() {
        this.pedidoID = ++contadorPedido;
        this.estado = "RECIBIDO";
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        //Aniade la información principal del pedido
        sb.append("Pedido #").append(this.pedidoID);
        sb.append(" [Estado: ").append(this.estado).append("]\n");
        sb.append("---------------------------------\n");

        //Itera sobre la lista de helados y aniade sus detalles
        if (this.helados.isEmpty()) {
            sb.append("  (Este pedido no tiene helados)\n");
        } else {
            sb.append("  Contenido del Pedido (" + this.helados.size() + " helado(s)):\n");
            
            int contadorHelado = 1;
            for (Helado helado : this.helados) {
                sb.append("    ").append(contadorHelado).append(". ");
                
                sb.append(helado.toString()); 
                
                sb.append("\n");
                contadorHelado++;
            }
        }
        sb.append("---------------------------------\n");

        //Devuelve el string completo
        return sb.toString();
    }
    
    public static int getSiguienteNumPedido(){
        return Pedido.contadorPedido + 1;
    }
    
}

