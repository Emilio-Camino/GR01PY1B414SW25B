package facturacion.gestores.interfaces;

import facturacion.elementos.ReporteStock;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

public interface IGestorStockHeladero {
    public int buscarRecipiente(TipoRecipiente tipoRecipiente);
    public int buscarBolasHelado(SaborHelado saborHelado);
    public boolean actualizarHelados(SaborHelado saborHelado, int numHelados);
    public boolean actualizarRecipiente(TipoRecipiente tipoRecipiente, int numRecipientes);
    public ReporteStock generarReporteStock();
}