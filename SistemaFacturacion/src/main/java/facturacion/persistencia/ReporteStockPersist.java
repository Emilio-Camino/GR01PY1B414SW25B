package facturacion.persistencia;

import facturacion.elementos.ReporteStock;
import java.util.ArrayList;
import java.util.List;

public class ReporteStockPersist {

    /**
     * Lista estática única que almacena todos los reportes de stock generados.
     */
    private static List<ReporteStock> reportesStock = new ArrayList<>();

    /**
     * Agrega un nuevo reporte de stock a la lista de persistencia.
     * @param reporte El reporte a guardar.
     */
    public static void agregarReporte(ReporteStock reporte) {
        if (reporte != null) {
            reportesStock.add(reporte);
        }
    }

    /**
     * Devuelve una copia de la lista de todos los reportes generados.
     * @return Un ArrayList<ReporteStock> con los reportes.
     */
    public static List<ReporteStock> getListaReportes() {
        return new ArrayList<>(reportesStock);
    }

    /**
     * Obtiene el último reporte generado para calcular el siguiente ID.
     * @return El último ReporteStock, o null si la lista está vacía.
     */
    public static ReporteStock getUltimoReporte() {
        if (reportesStock.isEmpty()) {
            return null;
        }
        // Retorna el último elemento de la lista
        return reportesStock.get(reportesStock.size() - 1);
    }
}