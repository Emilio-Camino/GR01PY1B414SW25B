package facturacion.gestores;

import facturacion.elementos.Promocion;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.gestores.interfaces.IGestorPromocionCajero;
import facturacion.gestores.interfaces.IGestorPromocionHeladero;
import facturacion.persistencia.PromocionPersist; // Importar

import java.util.List;

public class GestorPromocion implements IGestorPromocionCajero, IGestorPromocionHeladero {

    public GestorPromocion() {
    }

    // --- Implementación de Métodos ---

    @Override
    public Promocion buscarPromocion(int idPromocion) {
        // Delega la búsqueda a la persistencia
        return PromocionPersist.buscarPromocion(idPromocion);
    }

    @Override
    public boolean agregarPromocion(SaborHelado sabor, double porcentaje) {
        // 1. Crear el objeto
        Promocion promocion = new Promocion(porcentaje, sabor);

        // 2. Asignar el ID final de la promocion
        promocion.asignarIDFinal();

        // 3.  Guardar el objeto
        PromocionPersist.agregarPromocion(promocion);
        return true;
    }

    @Override
    public boolean eliminarPromocion(int idPromocion) {
        // Delega la eliminación a la persistencia
        return PromocionPersist.eliminarPromocion(idPromocion);
    }

    @Override
    public List<Promocion> getListaPromociones() {
        // Delega la obtención de la lista a la persistencia
        return PromocionPersist.getListaPromociones();
    }
}