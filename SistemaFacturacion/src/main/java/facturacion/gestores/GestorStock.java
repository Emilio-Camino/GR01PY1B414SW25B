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
        stockSabores.put(SaborHelado.CHOCOLATE, 20);
        stockSabores.put(SaborHelado.FRESA, 15);
        stockSabores.put(SaborHelado.VAINILLA, 25);
        stockSabores.put(SaborHelado.COOKIESNCREAM, 30);
        stockSabores.put(SaborHelado.RONPASAS, 15);
        stockSabores.put(SaborHelado.CHICLE, 2);

        // Inicialización de tipos de recipiente con stock inicial
        stockRecipiente.put(TipoRecipiente.VASO, 3);
        stockRecipiente.put(TipoRecipiente.CONO, 40);
        stockRecipiente.put(TipoRecipiente.TULIPAN, 30);
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
        int cantidadHelado = stockSabores().getOrDefault(saborHelado, 0);
        return cantidadHelado;
    }
    
    /* Actualiza cantidad de bolas de helado de acuerdo a su tipo. Retorna un booleano que verifica si se pudo actualizar o no.*/
    @Override
    public boolean actualizarHelados(SaborHelado saborHelado, int numHelados) {
        if (numHelados >= 0) {
            stockSabores.put(saborHelado, numHelados);
            return true;
        }
        return false;
    }


    /* Actualiza cantidad de recipientes de acuerdo a su tipo. Retorna un booleano que verifica si se pudo actualizar o no.*/
    @Override
    public boolean actualizarRecipiente(TipoRecipiente tipoRecipiente, int numRecipientes) {
        if (numRecipientes >= 0) {
            stockRecipiente.put(tipoRecipiente, numRecipientes);
            return true;
        }
        return false;
    }

    /*Genera un reporte de stock tomando en cuenta el estado actual del stock*/
    @Override
    public ReporteStock generarReporteStock() {
        int nuevoIdReporte = obtenerUltimoIdReporte() + 1;
        return new ReporteStock(nuevoIdReporte, stockSabores(), getStockRecipiente());
    }

    //Método que sirve para obtener cuál es la ID del ultimo registro en la lista de Reportes
    public int obtenerUltimoIdReporte() {
        if (getReportesStock().isEmpty()) {
            return 0;
        }
        ReporteStock ultimo = getReportesStock().get(getReportesStock().size() - 1);
        return ultimo != null ? ultimo.getIdReporte() : 0;
    }
    
    @Override
    public boolean decrementarStockSabor(SaborHelado saborHelado, int cantidadADecrementar) {
        
        // 1. Obtener el stock actual usando tu método
        int stockActual = this.buscarBolasHelado(saborHelado);

        // 2. Validar que se puede decrementar
        // (La cantidad debe ser positiva y debe haber suficiente stock)
        if (cantidadADecrementar > 0 && stockActual >= cantidadADecrementar) {
            
            // 3. Calcular el nuevo stock
            int nuevoStock = stockActual - cantidadADecrementar;
            
            // 4. Usar tu método existente para actualizar el stock en el mapa
            // Tu método 'actualizarHelados' ya maneja el .put()
            return this.actualizarHelados(saborHelado, nuevoStock);
            
        } else {
            // No hay suficiente stock o la cantidad a restar es inválida (ej. 0 o negativa)
            return false;
        }
    }
    
    @Override
    public boolean decrementarStockRecipiente(TipoRecipiente tipoRecipiente, int cantidadADecrementar) {
        
        // 1. Obtener el stock actual usando tu método
        int stockActual = this.buscarRecipiente(tipoRecipiente);

        // 2. Validar que se puede decrementar
        // (La cantidad debe ser positiva y debe haber suficiente stock)
        if (cantidadADecrementar > 0 && stockActual >= cantidadADecrementar) {
            
            // 3. Calcular el nuevo stock
            int nuevoStock = stockActual - cantidadADecrementar;
            
            // 4. Usar tu método existente para actualizar el stock en el mapa
            // Tu método 'actualizarRecipiente' ya maneja el .put()
            return this.actualizarRecipiente(tipoRecipiente, nuevoStock);
            
        } else {
            // No hay suficiente stock o la cantidad a restar es inválida (ej. 0 o negativa)
            return false;
        }
    }
    
    @Override
        public boolean aumentarStockSabor(SaborHelado saborHelado, int cantidadAAumentar) {
        
        // 1. Obtener el stock actual 
        int stockActual = this.buscarBolasHelado(saborHelado);

        // 2. Aumentar
        // (La cantidad debe ser positiva)
        if (cantidadAAumentar > 0) {
            
            // 3. Calcular el nuevo stock
            int nuevoStock = stockActual + cantidadAAumentar;
            
            // 4. Usar tu método existente para actualizar el stock en el mapa
            // Tu método 'actualizarHelados' ya maneja el .put()
            return this.actualizarHelados(saborHelado, nuevoStock);
            
        } else {
            // No se puede aumentar stock
            return false;
        }
    }
    
    
    @Override
    public boolean aumentarStockRecipiente(TipoRecipiente tipoRecipiente, int cantidadAAumentar) {
        
        // 1. Obtener el stock actual
        int stockActual = this.buscarRecipiente(tipoRecipiente);

        // 2. Aumentar
        // (La cantidad debe ser positiva y debe haber suficiente stock)
        if (cantidadAAumentar > 0) {
            
        // 3. Calcular el nuevo stock
            int nuevoStock = stockActual + cantidadAAumentar;
            
        // 4. ActualizarStock
            return this.actualizarRecipiente(tipoRecipiente, nuevoStock);
            
        } else {
            // No se puede aumentar
            return false;
        }
    }
    
    

    // --------------------------------------------------------
    // Getters y Setters
    // --------------------------------------------------------

    public Map<SaborHelado, Integer> stockSabores() {
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