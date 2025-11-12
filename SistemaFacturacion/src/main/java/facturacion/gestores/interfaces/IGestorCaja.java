package facturacion.gestores.interfaces;

import facturacion.elementos.Factura;
import facturacion.elementos.ReporteCierreCaja;
import facturacion.gestores.GestorFactura;

import java.util.ArrayList;

public interface IGestorCaja {
    /**
     * Calcula el total de ventas en efectivo de todas las facturas no anuladas.
     * @return El monto total.
     */
    public double calcularTotalEfectivo();

    /**
     * Compara los totales, genera un ReporteCierreCaja, lo guarda
     * en persistencia y lo devuelve.
     * @param totalIngresado El valor que el cajero ingresó manualmente.
     * @param totalEfectivo El valor calculado por el sistema.
     * @return El objeto ReporteCierreCaja que se generó y guardó.
     */
    public ReporteCierreCaja verificarEstadoCaja (double totalIngresado, double totalEfectivo);
}
