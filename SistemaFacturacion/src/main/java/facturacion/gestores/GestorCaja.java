package facturacion.gestores;

import facturacion.elementos.Factura;
import facturacion.elementos.ReporteCierreCaja;
import facturacion.gestores.interfaces.IGestorCaja;
import facturacion.persistencia.FacturaPersist;
import facturacion.persistencia.ReporteCierreCajaPersist;
import java.util.ArrayList;

public class GestorCaja implements IGestorCaja {

    public GestorCaja() {
    }

    /**
     * Calcula el total de efectivo sumando todas las facturas
     * no anuladas de la persistencia.
     */
    @Override
    public double calcularTotalEfectivo() {
        double total = 0;

        // Obtiene las facturas desde la persistencia
        ArrayList<Factura> listaFacturas = FacturaPersist.getListaFacturas();

        for (Factura factura : listaFacturas) {
            // Solo se suma factura sin anular
            if (!factura.getTipoPago().equals("ANULADA")) {
                total += factura.getTotal();
            }
        }
        return total;
    }

    /**
     * Compara los totales, determina el estado y descuadre,
     * crea el reporte, lo guarda en persistencia y lo devuelve.
     */
    @Override
    public ReporteCierreCaja verificarEstadoCaja (double totalIngresado, double totalEfectivo) {

        double descuadre = totalIngresado - totalEfectivo;
        double tolerancia = 0.005;
        String estado;

        // Lógica de estado
        if ( (Math.abs(descuadre) < tolerancia)) {
            estado = "Balance";
        } else if (descuadre > 0) {
            estado = "Descuadre Sobrante";
        } else {
            estado = "Descuadre Faltante";
        }

        // 1. Crear el objeto
        ReporteCierreCaja reporte = new ReporteCierreCaja(
                estado,
                totalEfectivo,
                totalIngresado,
                descuadre
        );

        // 2. Asignar ID final
        reporte.asignarIDFinal();

        // 3. Guardar en persistencia
        ReporteCierreCajaPersist.agregarReporte(reporte);

        // 4. Devolver el reporte creado
        return reporte;
    }
}