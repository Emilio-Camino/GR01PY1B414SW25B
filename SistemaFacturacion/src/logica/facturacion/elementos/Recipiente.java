package logica.facturacion.elementos;

import logica.facturacion.elementos.enumeraciones.TipoRecipiente;

public class Recipiente {

    private TipoRecipiente tipo;
    private double precio;

    public Recipiente(TipoRecipiente tipo) {
        this.tipo = tipo;

        switch (tipo) {
            case VASO ->  this.precio = 0.25;
            case CONO -> this.precio = 0.40;
            case TULIPAN ->   this.precio = 0.80;
        }
    }

    public TipoRecipiente getTipo() {
        return tipo;
    }

    public void setTipo(TipoRecipiente tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}