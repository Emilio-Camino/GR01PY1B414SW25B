package facturacion.gestores;
import facturacion.elementos.Factura;
import java.util.ArrayList;

public class GestorCaja {
    private double totalEfectivo;

    public GestorCaja() {
        this.totalEfectivo = 0;
    }

    public double getTotalEfectivo() {
        return totalEfectivo;
    }

    public void setTotalEfectivo(ArrayList<Factura> facturas) {
        double total = 0;
        for (Factura factura : facturas) {
            total += factura.getTotal();
        }
        this.totalEfectivo = total;
    }

    public boolean verificarEstadoCaja () {
        // TODO: obtener el total ingresado en la caja desde la interfaz y validar entrada
        double totalIngresado = 0;
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
