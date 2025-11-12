package facturacion.persistencia;

import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;
import java.util.HashMap;
import java.util.Map;

public class StockPersist {

    //Contiene el stock cambiante
    private static Map<SaborHelado, Integer> stockSabores;
    private static Map<TipoRecipiente, Integer> stockRecipiente;

    /**
     * Bloque estático para inicializar el inventario una sola vez.
     */
    static {
        stockSabores = new HashMap<>();
        stockSabores.put(SaborHelado.CHOCOLATE, 20);
        stockSabores.put(SaborHelado.FRESA, 15);
        stockSabores.put(SaborHelado.VAINILLA, 25);
        stockSabores.put(SaborHelado.COOKIESNCREAM, 30);
        stockSabores.put(SaborHelado.RONPASAS, 15);
        stockSabores.put(SaborHelado.CHICLE, 2);

        stockRecipiente = new HashMap<>();
        stockRecipiente.put(TipoRecipiente.VASO, 3);
        stockRecipiente.put(TipoRecipiente.CONO, 40);
        stockRecipiente.put(TipoRecipiente.TULIPAN, 30);
    }

    // --- MÉTODOS DE ACCESO A DATOS  ---

    /**
     * Obtiene el stock actual de un sabor.
     * @param saborHelado El sabor a consultar.
     * @return La cantidad de stock.
     */
    public static int getStockSabor(SaborHelado saborHelado) {
        return stockSabores.getOrDefault(saborHelado, 0);
    }

    /**
     * Obtiene el stock actual de un recipiente.
     * @param tipoRecipiente El recipiente a consultar.
     * @return La cantidad de stock.
     */
    public static int getStockRecipiente(TipoRecipiente tipoRecipiente) {
        return stockRecipiente.getOrDefault(tipoRecipiente, 0);
    }

    /**
     * Actualiza (sobrescribe) el stock de un sabor.
     * @param saborHelado El sabor a actualizar.
     * @param nuevaCantidad La nueva cantidad total.
     */
    public static void actualizarStockSabor(SaborHelado saborHelado, int nuevaCantidad) {
        stockSabores.put(saborHelado, nuevaCantidad);
    }

    /**
     * Actualiza (sobrescribe) el stock de un recipiente.
     * @param tipoRecipiente El recipiente a actualizar.
     * @param nuevaCantidad La nueva cantidad total.
     */
    public static void actualizarStockRecipiente(TipoRecipiente tipoRecipiente, int nuevaCantidad) {
        stockRecipiente.put(tipoRecipiente, nuevaCantidad);
    }

    /**
     * Devuelve una copia del mapa de stock de sabores.
     * @return Un nuevo HashMap con el stock actual de sabores.
     */
    public static Map<SaborHelado, Integer> getStockSaboresMap() {
        return new HashMap<>(stockSabores);
    }

    /**
     * Devuelve una copia del mapa de stock de recipientes.
     * @return Un nuevo HashMap con el stock actual de recipientes.
     */
    public static Map<TipoRecipiente, Integer> getStockRecipientesMap() {
        return new HashMap<>(stockRecipiente);
    }
}