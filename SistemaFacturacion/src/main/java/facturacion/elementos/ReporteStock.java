package facturacion.elementos;

import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte Stock #: ").append(idReporte).append("\n");
        sb.append("Fecha de Reporte: ").append(fechaReporte).append("\n");
        sb.append("Stock Sabores: ").append("\n");
        for (Map.Entry<SaborHelado, Integer> entry : stockSabores.entrySet()) {
            SaborHelado sabor = entry.getKey();
            Integer cantidad = entry.getValue();
            sb.append(sabor.toString()).append(": ").append(cantidad).append("\n");
        }
        sb.append("Stock Recipientes: ").append("\n");
        for (Map.Entry<TipoRecipiente, Integer> entry : stockRecipiente.entrySet()) {
            TipoRecipiente tipo = entry.getKey();
            Integer cantidad = entry.getValue();
            sb.append(tipo.toString()).append(": ").append(cantidad).append("\n");
        }
        return sb.toString();
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

    public String getFechaReporte() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fechaReporte.format(formatter);
    }

    public void setFechaReporte(LocalDateTime fechaReporte) {
        this.fechaReporte = fechaReporte;
    }
}
