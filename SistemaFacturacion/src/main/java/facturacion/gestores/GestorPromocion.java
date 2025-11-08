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
    public void agregarPromocion(SaborHelado sabor, double porcentaje) {
        listaPromociones.add(new Promocion(porcentaje, sabor));
    }

    @Override
    public void eliminarPromocion(int idPromocion) {
        for (Promocion promocion : this.listaPromociones) {
            if (promocion.getIdPromocion() == idPromocion) {
                listaPromociones.remove(promocion);
            }
        }
    }

    // --- Getters y Setters (Esqueleto) ---

    public List<Promocion> getListaPromociones() {
        return listaPromociones;
    }

    public void setListaPromociones(List<Promocion> listaPromociones) {
        this.listaPromociones = listaPromociones;
    }
}
