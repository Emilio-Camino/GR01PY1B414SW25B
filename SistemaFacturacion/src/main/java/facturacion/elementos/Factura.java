package facturacion.elementos;

import java.util.Date;

public class Factura {

    private static int contadorFactura = 0;

    private int idFactura;
    private Pedido pedidos;
    private Cliente cliente;
    private double total;
    private Date fechaEmision;
    private double impuestoIVA;
    private double pago;
    private double cambio;
    private String tipoPago;

    public Factura() {
        // Inicializa la fecha al momento de la creación
        this.fechaEmision = new Date();
    }

    public Factura(int idFactura, Pedido pedido, Cliente cliente, double total, double impuestoIVA, double pago, double cambio, String tipoPago) {
        this.idFactura = ++contadorFactura;
        this.pedidos = pedido;
        this.cliente = cliente;
        this.total = total;
        this.impuestoIVA = impuestoIVA;
        this.pago = pago;
        this.cambio = cambio;
        this.tipoPago = tipoPago;

    }

    public void imprimirFactura() {
    }


    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Pedido getPedido() {
        return pedidos;
    }

    public void setPedidos(Pedido pedido) {
        this.pedidos = pedidos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getImpuestoIVA() {
        return impuestoIVA;
    }

    public void setImpuestoIVA(double impuestoIVA) {
        this.impuestoIVA = impuestoIVA;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
}
