package facturacion.elementos;

import facturacion.elementos.enumeraciones.SaborHelado;

public class BolaHelado {

    private SaborHelado sabor;
    private double precio;

    // (El diagrama muestra una relación con Promoción,
    // pero la clase Promocion no está definida aquí)

    public BolaHelado(SaborHelado sabor) {
        this.sabor = sabor;
        this.precio = 0.50;
    }

    public SaborHelado getSabor() {
        return sabor;
    }

    public void setSabor(SaborHelado sabor) {
        this.sabor = sabor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
