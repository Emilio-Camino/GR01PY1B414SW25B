package facturacion.gestores.interfaces;

import facturacion.elementos.Factura;
import facturacion.elementos.Pedido; // <-- Importar Pedido
import facturacion.gestores.GestorCliente;
import facturacion.gestores.GestorPedido;
import facturacion.gestores.GestorPromocion;

public interface IGestorFacturaCajero {

    /**
     * Genera una factura para un pedido y cliente específicos.
     * @param pedidoID El ID del pedido a facturar.
     * @param clienteCedula La cédula del cliente.
     */
    Factura generarFactura(int pedidoID, String clienteCedula,
                           GestorPedido gestorPedido, GestorCliente gestorCliente,
                           GestorPromocion gestorPromocion);

    /**
     * Calcula el precio total de un pedido (aplicando promociones).
     * @param pedido El pedido del cual calcular el total.
     */
    double calcularPrecio(Pedido pedido, GestorPromocion promocion);
}