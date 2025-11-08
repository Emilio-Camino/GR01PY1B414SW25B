package facturacion.gestores.interfaces;

import facturacion.elementos.Factura;
import facturacion.elementos.ReporteVenta;

public interface IGestorFacturaHeladero {

    ReporteVenta generarReporteVenta();

    /**
     * Busca una factura por su ID.
     * @param idFactura El ID de la factura a buscar.
     */
    Factura buscarFactura(int idFactura);

    /**
     * Anula una factura por su ID.
     * @param idFactura El ID de la factura a anular.
     */
    void anularFactura(int idFactura);
}