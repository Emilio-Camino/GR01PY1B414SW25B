package facturacion.gestores.interfaces;

import facturacion.elementos.Promocion;
import facturacion.elementos.enumeraciones.SaborHelado;

import java.util.List;

public interface IGestorPromocionHeladero {
    //public Promocion buscarPromocion(int idPromocion);
    public boolean agregarPromocion(SaborHelado sabor, double porcentaje);
    public boolean eliminarPromocion(int idPromocion);
    public List<Promocion> getListaPromociones();

}
