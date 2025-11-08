package facturacion.gestores;

import facturacion.elementos.ReporteStock;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;
import facturacion.gestores.interfaces.IGestorStockCajero;
import facturacion.gestores.interfaces.IGestorStockHeladero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorStock implements IGestorStockCajero, IGestorStockHeladero {

    // Atributos
    private Map<SaborHelado, Integer> stockSabores = new HashMap<SaborHelado, Integer>();
    private Map<TipoRecipiente, Integer> stockRecipiente = new HashMap<TipoRecipiente, Integer>();
    private List<ReporteStock> reportesStock = new ArrayList<ReporteStock>();

    public GestorStock() {
        // Inicialización de sabores con stock inicial
        getStockSabores().put(SaborHelado.CHOCOLATE, 20);
        getStockSabores().put(SaborHelado.FRESA, 15);
        getStockSabores().put(SaborHelado.VAINILLA, 25);
        getStockSabores().put(SaborHelado.COOKIESNCREAM, 30);
        getStockSabores().put(SaborHelado.RONPASAS, 15);
        getStockSabores().put(SaborHelado.CHICLE, 12);

        // Inicialización de tipos de recipiente con stock inicial
        getStockRecipiente().put(TipoRecipiente.VASO, 50);
        getStockRecipiente().put(TipoRecipiente.CONO, 40);
        getStockRecipiente().put(TipoRecipiente.TULIPAN, 30);

        getReportesStock().add(generarReporteStock());
    }

    /* Busca la cantidad de recipientes de acuerdo a su tipo. Si no existe la entrada en el Map, retorna 0.*/
    @Override
    public int buscarRecipiente(TipoRecipiente tipoRecipiente) {
        int cantidadRecipiente = getStockRecipiente().getOrDefault(tipoRecipiente, 0);
        return cantidadRecipiente;
    }

    /* Busca la cantidad de bolas de Helado de acuerdo a su tipo. Si no existe la entrada en el Map, retorna 0.*/
    @Override
    public int buscarBolasHelado(SaborHelado saborHelado) {
        int cantidadHelado = getStockSabores().getOrDefault(saborHelado, 0);
        return cantidadHelado;
    }

    /* Actualiza cantidad de bolas de helado de acuerdo a su tipo. Retorna un booleano que verifica si se pudo actualizar o no.*/
    @Override
    public boolean actualizarHelados(SaborHelado saborHelado, int numHelados) {
        if (numHelados >= 0) {
            getStockSabores().put(saborHelado, numHelados);
            return true;
        }
        return false;
    }

    /* Actualiza cantidad de recipientes de acuerdo a su tipo. Retorna un booleano que verifica si se pudo actualizar o no.*/
    @Override
    public boolean actualizarRecipiente(TipoRecipiente tipoRecipiente, int numRecipientes) {
        if (numRecipientes >= 0) {
            getStockRecipiente().put(tipoRecipiente, numRecipientes);
            return true;
        }
        return false;
    }

    /*Genera un reporte de stock tomando en cuenta el estado actual del stock*/
    @Override
    public ReporteStock generarReporteStock() {
        int nuevoIdReporte = obtenerUltimoIdReporte() + 1;
        return new ReporteStock(nuevoIdReporte, getStockSabores(), getStockRecipiente());
    }

    //Método que sirve para obtener cuál es la ID del ultimo registro en la lista de Reportes
    public int obtenerUltimoIdReporte() {
        if (getReportesStock().isEmpty()) {
            return 0;
        }
        ReporteStock ultimo = getReportesStock().get(getReportesStock().size() - 1);
        return ultimo != null ? ultimo.getIdReporte() : 0;
    }

    // --------------------------------------------------------
    // Getters y Setters
    // --------------------------------------------------------

    public Map<SaborHelado, Integer> getStockSabores() {
        return stockSabores;
    }

    public void setStockSabores(Map<SaborHelado, Integer> stockSabores) {
        this.stockSabores = stockSabores;
    }

    public Map<TipoRecipiente, Integer> getStockRecipiente() {
        return stockRecipiente;
    }

    public void setStockRecipiente(Map<TipoRecipiente, Integer> stockRecipiente) {
        this.stockRecipiente = stockRecipiente;
    }

    public List<ReporteStock> getReportesStock() {
        return reportesStock;
    }

    public void setReportesStock(List<ReporteStock> reportesStock) {
        this.reportesStock = reportesStock;
    }
}