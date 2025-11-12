package facturacion.elementos; // O tu paquete de elementos

import java.time.LocalDateTime;

public class ReporteCierreCaja {

    private static int contadorReporte = 0;
    private int idReporte;
    private LocalDateTime fechaReporte;
    private String estado;
    private double valorCajaCalculado;
    private double valorIngresado;
    private double descuadre;

    public ReporteCierreCaja(String estado, double valorCajaCalculado, double valorIngresado, double descuadre) {
        this.idReporte = 0; // ID Temporal
        this.fechaReporte = LocalDateTime.now();
        this.estado = estado;
        this.valorCajaCalculado = valorCajaCalculado;
        this.valorIngresado = valorIngresado;
        this.descuadre = descuadre;
    }

    //Asigna el ID final e incrementa el contador.
    public void asignarIDFinal() {
        this.idReporte = ++contadorReporte;
    }

    // --- Getters ---

    public int getIdReporte() {
        return idReporte;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    public String getEstado() {
        return estado;
    }

    public double getValorCajaCalculado() {
        return valorCajaCalculado;
    }

    public double getValorIngresado() {
        return valorIngresado;
    }

    public double getDescuadre() {
        return descuadre;
    }
}