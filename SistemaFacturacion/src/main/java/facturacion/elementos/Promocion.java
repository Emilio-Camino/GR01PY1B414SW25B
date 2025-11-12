package facturacion.elementos;

import facturacion.elementos.enumeraciones.SaborHelado;

public class Promocion {
    private static int contadorPromocion = 0;
    private int idPromocion;
    private double porcentajeDescuento;
    private SaborHelado saborPromocion;

    //Constructor que asigna un ID temporal (0) y no incrementa el contador.
    public Promocion(double porcentajeDescuento, SaborHelado saborPromocion) {
        this.idPromocion = 0; // ID Temporal
        this.saborPromocion = saborPromocion;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    //Asigna el ID final el pedido
    public void asignarIDFinal() {
        this.idPromocion = ++contadorPromocion;
    }

    public void mostrarDetallesPromocion() {
    }
    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public SaborHelado getSaborPromocion() {
        return saborPromocion;
    }

    public void setSaborPromocion(SaborHelado saborPromocion) {
        this.saborPromocion = saborPromocion;
    }
}