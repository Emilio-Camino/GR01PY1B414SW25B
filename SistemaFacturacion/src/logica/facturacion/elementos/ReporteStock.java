package logica.facturacion.elementos;

import logica.facturacion.elementos.enumeraciones.SaborHelado;
import logica.facturacion.elementos.enumeraciones.TipoRecipiente;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class ReporteStock {

    private int idReporte;
    private Map<SaborHelado, Integer> stockSabores;
    private Map<TipoRecipiente, Integer> stockRecipiente;
    private List<ReporteStock> listaReporte;

    public ReporteStock() {
        this.stockSabores = new HashMap<>();
        this.stockRecipiente = new HashMap<>();
        this.listaReporte = new ArrayList<>();
    }

    public String toStringReporteStock() {
        return "Reporte ID: " + idReporte +
                ", Sabores: " + stockSabores.size() +
                ", Recipientes: " + stockRecipiente.size();
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

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

    public List<ReporteStock> getListaReporte() {
        return listaReporte;
    }

    public void setListaReporte(List<ReporteStock> listaReporte) {
        this.listaReporte = listaReporte;
    }
}
