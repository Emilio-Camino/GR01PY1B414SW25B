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
    
    public ArrayList<SaborHelado> getSaborHelado() {
        ArrayList<SaborHelado> sabores = new ArrayList<>();
        for (BolaHelado bola : bolasHelado){
            sabores.add(bola.getSabor());
        }
        return sabores;
    }

    public void setBolasHelado(ArrayList<BolaHelado> bolasHelado) {
        this.bolasHelado = bolasHelado;
    }
    
    public double getPrecio() {
        double precioTotal = 0.0;
        if (this.recipiente != null) {
            precioTotal += this.recipiente.getPrecio(); // <-- Confirmado
        }
        if (this.bolasHelado != null) {
            for (BolaHelado bola : this.bolasHelado) {
                precioTotal += bola.getPrecio(); // <-- Confirmado
            }
        }
        return precioTotal;
    }
    
    @Override
    public String toString() {
        // 1. Obtiene el nombre del recipiente (confiando en Recipiente.toString())
        String nombreRecipiente = this.recipiente.toString();
        
        // 2. Obtiene el número de bolas
        int numBolas = this.bolasHelado.size();
        
        // 3. Obtiene la lista de sabores (confiando en BolaHelado.toString() 
        //    y en ArrayList.toString())
        // El .toString() de un ArrayList genera: [item1, item2, item3]
        String listaSabores = this.bolasHelado.toString();

        // 4. Combina todo en un string descriptivo
        return String.format("%s con %d bola(s): %s", 
                             nombreRecipiente, 
                             numBolas, 
                             listaSabores);
    }
    
}
