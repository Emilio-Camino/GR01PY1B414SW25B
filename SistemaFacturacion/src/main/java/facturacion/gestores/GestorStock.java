package facturacion.gestores;

import facturacion.elementos.ReporteStock;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;
import facturacion.gestores.interfaces.IGestorStockCajero;
import facturacion.gestores.interfaces.IGestorStockHeladero;
import facturacion.persistencia.ReporteStockPersist;
import facturacion.persistencia.StockPersist;

import java.util.Map;

public class GestorStock implements IGestorStockCajero, IGestorStockHeladero {

    /**
     * Constructor vacío. El inventario se inicializa estáticamente
     * en StockPersist.
     */
    public GestorStock() {
        // Los atributos y la inicialización fueron movidos a las clases Persist.
    }

    // --- MÉTODOS DE IGestorStockCajero ---

    @Override
    public int buscarRecipiente(TipoRecipiente tipoRecipiente) {
        // Delega la lectura a la persistencia
        return StockPersist.getStockRecipiente(tipoRecipiente);
    }

    @Override
    public int buscarBolasHelado(SaborHelado saborHelado) {
        // Delega la lectura a la persistencia
        return StockPersist.getStockSabor(saborHelado);
    }

    @Override
    public boolean decrementarStockSabor(SaborHelado saborHelado, int cantidadADecrementar) {
        // 1. Lógica de negocio: Leer el dato
        int stockActual = StockPersist.getStockSabor(saborHelado);

        // 2. Lógica de negocio: Validar
        if (cantidadADecrementar > 0 && stockActual >= cantidadADecrementar) {
            int nuevoStock = stockActual - cantidadADecrementar;

            // 3. Lógica de negocio: Escribir el dato
            StockPersist.actualizarStockSabor(saborHelado, nuevoStock);
            return true;
        }
        return false;
    }

    @Override
    public boolean decrementarStockRecipiente(TipoRecipiente tipoRecipiente, int cantidadADecrementar) {
        int stockActual = StockPersist.getStockRecipiente(tipoRecipiente);
        if (cantidadADecrementar > 0 && stockActual >= cantidadADecrementar) {
            int nuevoStock = stockActual - cantidadADecrementar;
            StockPersist.actualizarStockRecipiente(tipoRecipiente, nuevoStock);
            return true;
        }
        return false;
    }

    @Override
    public boolean aumentarStockSabor(SaborHelado saborHelado, int cantidadAAumentar) {
        if (cantidadAAumentar <= 0) {
            return false; // Lógica de negocio: no se puede aumentar 0 o negativo
        }
        int stockActual = StockPersist.getStockSabor(saborHelado);
        int nuevoStock = stockActual + cantidadAAumentar;
        StockPersist.actualizarStockSabor(saborHelado, nuevoStock);
        return true;
    }

    @Override
    public boolean aumentarStockRecipiente(TipoRecipiente tipoRecipiente, int cantidadAAumentar) {
        if (cantidadAAumentar <= 0) {
            return false;
        }
        int stockActual = StockPersist.getStockRecipiente(tipoRecipiente);
        int nuevoStock = stockActual + cantidadAAumentar;
        StockPersist.actualizarStockRecipiente(tipoRecipiente, nuevoStock);
        return true;
    }

    // --- MÉTODOS DE IGestorStockHeladero ---

    @Override
    public boolean actualizarHelados(SaborHelado saborHelado, int numHelados) {
        // Lógica de negocio: validar que el stock no sea negativo
        if (numHelados >= 0) {
            StockPersist.actualizarStockSabor(saborHelado, numHelados);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarRecipiente(TipoRecipiente tipoRecipiente, int numRecipientes) {
        // Lógica de negocio: validar que el stock no sea negativo
        if (numRecipientes >= 0) {
            StockPersist.actualizarStockRecipiente(tipoRecipiente, numRecipientes);
            return true;
        }
        return false;
    }

    @Override
    public ReporteStock generarReporteStock() {
        // 1. Lógica de negocio: Obtener el ID
        int nuevoIdReporte = obtenerUltimoIdReporte() + 1;

        // 2. Lógica de negocio: Obtener los datos actuales de persistencia
        Map<SaborHelado, Integer> saboresActuales = StockPersist.getStockSaboresMap();
        Map<TipoRecipiente, Integer> recipientesActuales = StockPersist.getStockRecipientesMap();

        // 3. Lógica de negocio: Crear el nuevo objeto
        ReporteStock nuevoReporte = new ReporteStock(nuevoIdReporte, saboresActuales, recipientesActuales);

        // 4. Lógica de persistencia: Guardar el nuevo reporte
        ReporteStockPersist.agregarReporte(nuevoReporte);

        return nuevoReporte;
    }

    @Override
    public String obtenerStockSaboresHelado() {
        // 1. Obtener datos de persistencia
        Map<SaborHelado, Integer> stockSabores = StockPersist.getStockSaboresMap();

        // 2. Lógica de negocio: Formatear los datos para la GUI
        StringBuilder stockH = new StringBuilder("\tStock Sabores de Helado\n");
        for (Map.Entry<SaborHelado, Integer> stockSabor : stockSabores.entrySet()) {
            SaborHelado sabor = stockSabor.getKey();
            Integer stock = stockSabor.getValue();
            stockH.append(String.format("-> %s : %d\n", sabor.toString(), stock));
        }
        return stockH.toString();
    }

    @Override
    public String obtenerStockRecipiente() {
        // 1. Obtener datos de persistencia
        Map<TipoRecipiente, Integer> stockRecipiente = StockPersist.getStockRecipientesMap();

        // 2. Lógica de negocio: Formatear los datos para la GUI
        StringBuilder stockR = new StringBuilder("\tStock Sabores de Helado\n");
        for (Map.Entry<TipoRecipiente, Integer> entry : stockRecipiente.entrySet()) {
            TipoRecipiente sabor = entry.getKey();
            Integer stock = entry.getValue();
            stockR.append(String.format("-> %s : %d\n", sabor.toString(), stock));
        }
        return stockR.toString();
    }

    // --- MÉTODOS PRIVADOS DEL GESTOR ---

    /**
     * Obtiene el ID del último reporte de stock guardado en persistencia.
     * @return El último ID, o 0 si no hay reportes.
     */
    private int obtenerUltimoIdReporte() {
        ReporteStock ultimo = ReporteStockPersist.getUltimoReporte();
        return ultimo != null ? ultimo.getIdReporte() : 0;
    }
}