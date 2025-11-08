package facturacion.elementos;

import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

import java.util.ArrayList;

public class Helado {

    private Recipiente recipiente;

    private ArrayList<BolaHelado> bolasHelado;

    public Helado(TipoRecipiente recipiente) {
        this.recipiente = new Recipiente(recipiente);
        this.bolasHelado = new ArrayList<>();
    }

    public void agregarBola(SaborHelado saborHelado) {

        if (this.bolasHelado.size() < 3) {
            this.bolasHelado.add(new BolaHelado(saborHelado));
        } else {
            System.out.println("No se pueden agregar más de 3 bolas de helado.");
        }
    }

    public Recipiente getRecipiente() {
        return recipiente;
    }

    public void setRecipiente(Recipiente recipiente) {
        this.recipiente = recipiente;
    }

    public ArrayList<BolaHelado> getBolasHelado() {
        return bolasHelado;
    }

    public void setBolasHelado(ArrayList<BolaHelado> bolasHelado) {
        this.bolasHelado = bolasHelado;
    }
}
