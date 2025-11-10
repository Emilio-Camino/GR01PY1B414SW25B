package facturacion.gestores;

import facturacion.elementos.Promocion;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.gestores.interfaces.IGestorPromocionCajero;
import facturacion.gestores.interfaces.IGestorPromocionHeladero;

import java.util.List;
import java.util.ArrayList;

public class GestorPromocion implements IGestorPromocionCajero, IGestorPromocionHeladero {

    private List<Promocion> listaPromociones;

    public GestorPromocion() {
        this.listaPromociones = new ArrayList<>();
        quemarDatosPromociones();
    }

    // --- Implementación de Métodos ---

    @Override
    public Promocion buscarPromocion(int idPromocion) {
        for (Promocion promocion : this.listaPromociones) {
            if (promocion.getIdPromocion() == idPromocion) {
                return promocion;
            }
        }
        return null;
    }

    @Override
    public boolean agregarPromocion(SaborHelado sabor, double porcentaje) {
        Promocion promocion = new Promocion(porcentaje, sabor);
        listaPromociones.add(promocion);
        return true;
    }

    @Override
    public boolean eliminarPromocion(int idPromocion) {
        for (Promocion promocion : this.listaPromociones) {
            if (promocion.getIdPromocion() == idPromocion) {
                listaPromociones.remove(promocion);
                return true;
            }
        }
        return false;
    }

    private void quemarDatosPromociones() {
        // El 15% de descuento se representa como 0.15
        Promocion promoFresa = new Promocion(0.15, SaborHelado.FRESA);
        this.listaPromociones.add(promoFresa);
    }

    // --- Getters y Setters (Esqueleto) ---

    public List<Promocion> getListaPromociones() {
        return listaPromociones;
    }

    public void setListaPromociones(List<Promocion> listaPromociones) {
        this.listaPromociones = listaPromociones;
    }
}
