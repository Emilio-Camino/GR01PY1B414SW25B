package facturacion.gestores.interfaces;

import facturacion.elementos.Factura;
import facturacion.elementos.Pedido; // <-- Importar Pedido
import facturacion.gestores.GestorCliente;
import facturacion.gestores.GestorPedido;
import facturacion.gestores.GestorPromocion;

import java.util.Map;

public interface IGestorFacturaCajero {

    /**
     * Genera una factura para un pedido y cliente específicos.
     * @param pedidoID El ID del pedido a facturar.
     * @param clienteCedula La cédula del cliente.
     */
    Factura generarFactura(int pedidoID, String clienteCedula, boolean aplicaPromocion);

    /**
     * Valida si el pago realizado es valido.
     * @param pago es el valor que paga el cliente.
     * @param total es el total de la factura.
     */
    public boolean validarPago(String pago, double total);
    /**
     * Calcula el cambio
     * * @param total es el total de la factura.
     * @param pago es el valor que paga el cliente.
     */
    public double calcularCambio(double total, double pago);

    /**
     * Calcula todos los totales para un pedido (subtotal, descuento, iva, total)
     * SIN generar una factura. Se usa para la previsualización en la GUI.
     * @param pedidoID El ID del pedido a calcular.
     * @param aplicaPromocion Si el cajero marcó la promoción.
     * @return Un Map<String, Double> con las claves "subtotal", "descuento", "iva", y "total".
     */
    public Map<String, Double> calcularTotalesPedido(int pedidoID, boolean aplicaPromocion);

}