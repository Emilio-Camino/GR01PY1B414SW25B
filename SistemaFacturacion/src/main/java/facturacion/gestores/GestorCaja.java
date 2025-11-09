package facturacion.gestores;
import facturacion.elementos.Factura;
import facturacion.gestores.interfaces.IGestorCaja;
import java.util.ArrayList;

public class GestorCaja implements IGestorCaja {

    public GestorCaja() {
    }

    public double calcularTotalEfectivo(GestorFactura gestorFactura) {
        double total = 0;
        for (Factura factura : gestorFactura.getListaFacturas()) {
            total += factura.getTotal();
        }
        return total;
    }

    public boolean verificarEstadoCaja (double totalIngresado, double totalEfectivo) {
        if (totalIngresado == totalEfectivo) {
            //estado de la caja balanceado
            return true;
        }
        // estado de la caja desbalanceado
        else if (totalIngresado > totalEfectivo) {
            // estado de la caja con exceso de dinero
        } else {
            // estado de la caja con falta de dinero
        }
        return false;
    }


}
