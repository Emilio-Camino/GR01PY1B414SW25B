package facturacion.persistencia;

import facturacion.elementos.ReporteCierreCaja;
import java.util.ArrayList;
import java.util.List;

public class ReporteCierreCajaPersist {

    /**
     * Lista estática única que almacena todos los reportes de cierre de caja.
     */
    private static List<ReporteCierreCaja> listaReportes = new ArrayList<>();

    /**
     * Agrega un nuevo reporte de cierre a la lista de persistencia.
     * @param reporte El reporte a guardar.
     */
    public static void agregarReporte(ReporteCierreCaja reporte) {
        if (reporte != null) {
            listaReportes.add(reporte);
        }
    }

    /**
     * Devuelve una copia de la lista de todos los reportes generados.
     * @return Un ArrayList<ReporteCierreCaja> con los reportes.
     */
    public static List<ReporteCierreCaja> getListaReportes() {
        return new ArrayList<>(listaReportes);
    }
}