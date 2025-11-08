package logica.facturacion.elementos;

import logica.facturacion.elementos.enumeraciones.SaborHelado;
import logica.facturacion.elementos.enumeraciones.TipoRecipiente;


public class ReporteVenta {
    private static int contadorReporte = 0;
    private int idReporte;
    private double totalVentas;
    private SaborHelado saborMasVendido;
    private TipoRecipiente recipienteMasVendido;

    public ReporteVenta(double totalVentas,SaborHelado saborMasVendido,TipoRecipiente recipienteMasVendido) {
        this.idReporte = ++contadorReporte;
        this.totalVentas = totalVentas;
        this.saborMasVendido = saborMasVendido;
        this.recipienteMasVendido = recipienteMasVendido;

    }

    public String toStringReporteVentas() {
    return "";
    }
}
