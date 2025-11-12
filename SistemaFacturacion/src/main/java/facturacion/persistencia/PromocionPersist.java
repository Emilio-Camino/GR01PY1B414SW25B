package facturacion.persistencia; // Asegúrate de ponerla en el paquete de persistencia

import facturacion.elementos.Promocion;
import facturacion.elementos.enumeraciones.SaborHelado;
import java.util.ArrayList;
import java.util.List;

public class PromocionPersist {

    //Lista estatica que almacena todas las promociones.
    private static List<Promocion> listaPromociones;

    //Bloque estático para inicializar la lista y cargar datos quemados
    static {
        listaPromociones = new ArrayList<>();
        quemarDatosPromociones();
    }

    /**
     * Busca una promocion en la lista por su ID.
     * @param idPromocion El ID a buscar.
     * @return La Promocion encontrada, o null.
     */
    public static Promocion buscarPromocion(int idPromocion) {
        for (Promocion promocion : listaPromociones) {
            if (promocion.getIdPromocion() == idPromocion) {
                return promocion;
            }
        }
        return null;
    }

    public static Promocion buscarPromocionPorSabor(SaborHelado sabor) {
        for (Promocion promo : listaPromociones) {
            // Compara el sabor de la promoción con el sabor de la bola
            if (promo.getSaborPromocion() == sabor) {
                return promo; // Promoción encontrada
            }
        }
        return null; // No hay promoción para este sabor
    }

    /**
     * Agrega una promoción completamente creada a la lista.
     * @param promocion La promoción a guardar.
     */
    public static void agregarPromocion(Promocion promocion) {
        listaPromociones.add(promocion);
    }

    /**
     * Elimina una promocion de la lista usando su ID.
     * @param idPromocion El ID de la promoción a eliminar.
     * @return true si se eliminó, false si no se encontró.
     */
    public static boolean eliminarPromocion(int idPromocion) {
        return listaPromociones.removeIf(promo -> promo.getIdPromocion() == idPromocion);
    }

    /**
     * Devuelve una copia de la lista de promociones.
     * @return Un nuevo ArrayList con las promociones.
     */
    public static List<Promocion> getListaPromociones() {
        return new ArrayList<>(listaPromociones);
    }

    /**
     * Carga los datos de ejemplo (movido del Gestor).
     */
    private static void quemarDatosPromociones() {
        // El 15% de descuento se representa como 0.15
        Promocion promoFresa = new Promocion(15, SaborHelado.FRESA);
        promoFresa.asignarIDFinal(); // Asigna el ID real
        listaPromociones.add(promoFresa);
    }
}