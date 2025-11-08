package logica.facturacion.gestores.interfaces;

import logica.facturacion.elementos.ReporteStock;
import logica.facturacion.elementos.enumeraciones.SaborHelado;
import logica.facturacion.elementos.enumeraciones.TipoRecipiente;

public interface IGestorStockHeladero {
    public int buscarRecipiente(TipoRecipiente tipoRecipiente);
    public int buscarBolasHelado(SaborHelado saborHelado);
    public boolean actualizarHelados(SaborHelado saborHelado, int numHelados);
    public boolean actualizarRecipiente(TipoRecipiente tipoRecipiente, int numRecipientes);
    public ReporteStock generarReporteStock();
}
