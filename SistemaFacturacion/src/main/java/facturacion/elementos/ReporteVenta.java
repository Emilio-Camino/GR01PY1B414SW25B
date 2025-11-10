package facturacion.elementos;

import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class ReporteVenta {
private double totalVentas;
    private int facturasProcesadas;
    private SaborHelado saborMasVendido;
    private TipoRecipiente recipienteMasVendido;
    private LocalDateTime fechaReporte;
    
    // Almacenamos los mapas para usarlos en el método de impresión
    private Map<SaborHelado, Integer> conteoSabor;
    private Map<TipoRecipiente, Integer> conteoRecipiente;

    // Constructor actualizado para guardar todos los datos
    public ReporteVenta(double totalVentas, int facturasProcesadas,
                        SaborHelado saborMasVendido, TipoRecipiente recipienteMasVendido,
                        Map<SaborHelado, Integer> conteoSabor,
                        Map<TipoRecipiente, Integer> conteoRecipiente) {
        this.totalVentas = totalVentas;
        this.facturasProcesadas = facturasProcesadas;
        this.saborMasVendido = saborMasVendido;
        this.recipienteMasVendido = recipienteMasVendido;
        this.conteoSabor = conteoSabor;
        this.conteoRecipiente = conteoRecipiente;
        this.fechaReporte = LocalDateTime.now();
    }

    // --- Getters (Ahora son necesarios para que el método de impresión acceda a los datos) ---

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
    
    @Override
    public String toString() {
        // Usamos StringBuilder para construir eficientemente el String final
        StringBuilder sb = new StringBuilder();

        // Manejo de nulos para la impresión
        String sabor = (this.saborMasVendido != null) ? this.saborMasVendido.toString() : "N/A";
        String recipiente = (this.recipienteMasVendido != null) ? this.recipienteMasVendido.toString() : "N/A";

        // --- Inicio del Formato de Impresión ---
        
        sb.append("=================================\n");
        sb.append("===== RESUMEN REPORTE DE VENTA ====\n");
        sb.append("=================================\n");
        
        sb.append(String.format("Fecha: " + getFechaReporte()));
        // Resumen General
        // Usamos String.format para el dinero y lo añadimos al StringBuilder
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
            // Iteramos y añadimos cada línea al StringBuilder
            this.conteoSabor.forEach((s, cantidad) -> 
                sb.append("Sabor " + s + ": " + cantidad + " bolas\n"));
        }
        
        // Listado Detallado de Recipientes
        sb.append("\n--- Reporte Detallado de Recipientes Vendidos ---\n");
        if (this.conteoRecipiente.isEmpty()) {
            sb.append(" (No se vendieron recipientes)\n");
        } else {
            // Iteramos y añadimos cada línea al StringBuilder
            this.conteoRecipiente.forEach((r, cantidad) -> 
                sb.append("Recipiente " + r + ": " + cantidad + " unidades\n"));
        }
        
        sb.append("=================================\n");

        // Devolvemos el String completo
        return sb.toString();
    }

        public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }
}
