package facturacion.elementos;

import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ReporteStock {

    private int idReporte;
    private LocalDateTime fechaReporte;
    private Map<SaborHelado, Integer> stockSabores;
    private Map<TipoRecipiente, Integer> stockRecipiente;

    public ReporteStock(int id, Map<SaborHelado, Integer> stockSabores, Map<TipoRecipiente, Integer> stockRecipiente) {
        setIdReporte(id);
        setFechaReporte(LocalDateTime.now());
        setStockRecipiente(stockRecipiente);
        setStockSabores(stockSabores);
    }

    public String toStringReporteStock() {
        return "Reporte ID: " + idReporte +
                ", Sabores: " + stockSabores.size() +
                ", Recipientes: " + stockRecipiente.size() +
                ", Fecha del Reporte: " + fechaReporte.toString();

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

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDateTime fechaReporte) {
        this.fechaReporte = fechaReporte;
    }
}
