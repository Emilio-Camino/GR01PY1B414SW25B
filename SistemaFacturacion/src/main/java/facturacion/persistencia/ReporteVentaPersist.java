package facturacion.persistencia;

import facturacion.elementos.ReporteVenta;
import java.util.ArrayList;
import java.util.List;

public class ReporteVentaPersist {

    //Lista estática que almacena todos los reportes de venta.
    private static List<ReporteVenta> listaReporte = new ArrayList<>();

    /**
     * Agrega un nuevo reporte de venta a la lista de persistencia.
     * @param reporte El reporte a guardar.
     */
    public static void agregarReporte(ReporteVenta reporte) {
        if (reporte != null) {
            listaReporte.add(reporte);
        }
    }

    /**
     * Devuelve una copia de la lista de todos los reportes generados.
     * @return Un ArrayList<ReporteVenta> con los reportes.
     */
    public static List<ReporteVenta> getListaReportes() {
        return new ArrayList<>(listaReporte);
    }

    /**
     * Obtiene el último reporte generado (útil para IDs, aunque no se usa aquí).
     * @return El último ReporteVenta, o null si la lista está vacía.
     */
    public static ReporteVenta getUltimoReporte() {
        if (listaReporte.isEmpty()) {
            return null;
        }
        return listaReporte.get(listaReporte.size() - 1);
    }
}