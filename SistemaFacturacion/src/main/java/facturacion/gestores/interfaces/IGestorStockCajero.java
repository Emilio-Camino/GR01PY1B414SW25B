package facturacion.gestores.interfaces;

import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

public interface IGestorStockCajero {
    public int buscarRecipiente(TipoRecipiente tipoRecipiente);
    public int buscarBolasHelado(SaborHelado saborHelado);
}