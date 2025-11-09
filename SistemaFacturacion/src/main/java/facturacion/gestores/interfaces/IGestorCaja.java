package facturacion.gestores.interfaces;

import facturacion.elementos.Factura;
import facturacion.gestores.GestorFactura;

import java.util.ArrayList;

public interface IGestorCaja {
    public boolean verificarEstadoCaja (double totalIngresado, double totalEfectivo);
    public double calcularTotalEfectivo(GestorFactura gestorFactura);
}
