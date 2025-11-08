package logica.facturacion.gestores.interfaces;

import logica.facturacion.elementos.Promocion;
import logica.facturacion.elementos.enumeraciones.SaborHelado;

public interface IGestorPromocionHeladero {
    public Promocion buscarPromocion(int idPromocion);
    public void agregarPromocion(SaborHelado sabor, double porcentaje);
    public void eliminarPromocion(int idPromocion);
}
