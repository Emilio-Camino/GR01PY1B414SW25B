package facturacion.gestores.interfaces;

import facturacion.elementos.Promocion;
import facturacion.elementos.enumeraciones.SaborHelado;

public interface IGestorPromocionHeladero {
    public Promocion buscarPromocion(int idPromocion);
    public void agregarPromocion(SaborHelado sabor, double porcentaje);
    public void eliminarPromocion(int idPromocion);
}
