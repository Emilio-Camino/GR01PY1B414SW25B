package facturacion.elementos;

import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;
import java.util.Map;
import java.time.LocalDateTime;

public class ReporteVenta {

    private static int contadorReporte = 0; // Añadido
    private int idReporte;

    private double totalVentas;
    private int facturasProcesadas;
    private SaborHelado saborMasVendido;
    private TipoRecipiente recipienteMasVendido;
    private LocalDateTime fechaReporte;

    private Map<SaborHelado, Integer> conteoSabor;
    private Map<TipoRecipiente, Integer> conteoRecipiente;

    public ReporteVenta(double totalVentas, int facturasProcesadas,
                        SaborHelado saborMasVendido, TipoRecipiente recipienteMasVendido,
                        Map<SaborHelado, Integer> conteoSabor,
                        Map<TipoRecipiente, Integer> conteoRecipiente) {

        this.idReporte = 0;
        this.totalVentas = totalVentas;
        this.facturasProcesadas = facturasProcesadas;
        this.saborMasVendido = saborMasVendido;
        this.recipienteMasVendido = recipienteMasVendido;
        this.conteoSabor = conteoSabor;
        this.conteoRecipiente = conteoRecipiente;
        this.fechaReporte = LocalDateTime.now();
    }

    // --- Getters y Setters

    public int getIdReporte() {
        return idReporte;
    }

    public double getTotalVentas() {
        return totalVentas;
    }
    public int getFacturasProcesadas() {
        return facturasProcesadas;
    }

    public SaborHelado getSaborMasVendido() {
        return saborMasVendido;
    }

    public TipoRecipiente getRecipienteMasVendido() {
        return recipienteMasVendido;
    }

    public Map<SaborHelado, Integer> getConteoSabor() {
        return conteoSabor;
    }

    public Map<TipoRecipiente, Integer> getConteoRecipiente() {
        return conteoRecipiente;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }
    //Asigna el ID final e incrementa el contador.

    public void asignarIDFinal() {
        this.idReporte = ++contadorReporte;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Manejo de nulos
        String sabor = (this.saborMasVendido != null) ? this.saborMasVendido.toString() : "N/A";
        String recipiente = (this.recipienteMasVendido != null) ? this.recipienteMasVendido.toString() : "N/A";

        // --- Inicio del Formato de Impresión ---
        
        sb.append("=================================\n");
        sb.append("===== RESUMEN REPORTE DE VENTA ====\n");
        sb.append("=================================\n");
        
        sb.append(String.format("Fecha: " + getFechaReporte()));
        // Resumen General
        sb.append(String.format("Total de Ventas: $%.2f\n", this.totalVentas));
        sb.append("Facturas Procesadas: " + this.facturasProcesadas + "\n");
        sb.append("---------------------------------\n");
        sb.append("Sabor Más Vendido: " + sabor + "\n");
        sb.append("Recipiente Más Vendido: " + recipiente + "\n");
        
        // Listado Detallado de Sabores
        sb.append("\n--- Reporte Detallado de Sabores Vendidos ---\n");
        if (this.conteoSabor.isEmpty()) {
            sb.append(" (No se vendieron sabores)\n");
        } else {
            // Iteración por linea
            this.conteoSabor.forEach((s, cantidad) -> 
                sb.append("Sabor " + s + ": " + cantidad + " bolas\n"));
        }
        
        // Listado Detallado de Recipientes
        sb.append("\n--- Reporte Detallado de Recipientes Vendidos ---\n");
        if (this.conteoRecipiente.isEmpty()) {
            sb.append(" (No se vendieron recipientes)\n");
        } else {
            // Iterar y aniadir al StringBuilder
            this.conteoRecipiente.forEach((r, cantidad) -> 
                sb.append("Recipiente " + r + ": " + cantidad + " unidades\n"));
        }
        
        sb.append("=================================\n");

        // Devolvemos el String completo
        return sb.toString();
    }
}
