package logica.facturacion.gestores.interfaces;

import logica.facturacion.elementos.BolaHelado;
import logica.facturacion.elementos.Recipiente;
import logica.facturacion.elementos.enumeraciones.SaborHelado;
import logica.facturacion.elementos.enumeraciones.TipoRecipiente;

public interface IGestorStockCajero {
    public int buscarRecipiente(TipoRecipiente tipoRecipiente);
    public int buscarBolasHelado(SaborHelado saborHelado);
}
