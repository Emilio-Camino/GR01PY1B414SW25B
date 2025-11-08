package logica.facturacion.gestores;

// Importaciones de Elementos (Entidades)
import logica.facturacion.elementos.Factura;
import logica.facturacion.elementos.ReporteVenta;
import logica.facturacion.elementos.Pago;

// Importaciones de Interfaces
import logica.facturacion.interfaces.IGestorFacturaHeladero;
import logica.facturacion.interfaces.IGestorFacturaCajero;
import logica.facturacion.interfaces.Impuesto;
import logica.facturacion.interfaces.IGestorPromocionCajero;

// Importaciones de otros Gestores (Clases)
import logica.facturacion.gestores.GestorPedido;
import logica.facturacion.gestores.GestorClientes;
import logica.facturacion.gestores.GestorCaja;
import logica.facturacion.gestores.GestorPromocion;
import logica.facturacion.gestores.GestorEfectivo;
import logica.facturacion.gestores.GestorDeUna;

// Importaciones de Java
import java.util.ArrayList;
import java.util.List;

/**
 * GestorFactura: Clase que traduce el diagrama de clases.
 * Implementa las interfaces para Cajero y Heladero
 * y coordina con otros gestores para el proceso de facturación.
 */
public class GestorFactura implements IGestorFacturaHeladero, IGestorFacturaCajero {

    // --- 1. Atributos del Diagrama ---

    // Atributos propios (asociación de composición/agregación)
    private List<Factura> listaFacturas;
    private List<ReporteVenta> listaReporte;

    // Dependencias (<<use>>, <<busca>>, <<realiza>>)
    private GestorPedido gestorPedido;
    private GestorClientes gestorClientes;
    private GestorCaja gestorCaja;
    private GestorPromocion gestorPromocion;
    private Impuesto impuesto;
    private GestorEfectivo gestorEfectivo;
    private GestorDeUna gestorDeUna;
    private IGestorPromocionCajero gestorPromocionCajero;


    // --- 2. Constructor ---

    /**
     * Constructor para inicializar el gestor.
     * La forma estándar de "conectar" las dependencias (<<use>>)
     * es pasándolas al constructor (Inyección de Dependencias).
     */
    public GestorFactura(GestorPedido gestorPedido, GestorClientes gestorClientes,
                         GestorCaja gestorCaja, GestorPromocion gestorPromocion,
                         Impuesto impuesto, GestorEfectivo gestorEfectivo,
                         GestorDeUna gestorDeUna, IGestorPromocionCajero gestorPromocionCajero) {

        // Inicializa las listas propias
        this.listaFacturas = new ArrayList<>();
        this.listaReporte = new ArrayList<>();

        // Asigna las dependencias que "usa"
        this.gestorPedido = gestorPedido;
        this.gestorClientes = gestorClientes;
        this.gestorCaja = gestorCaja;
        this.gestorPromocion = gestorPromocion;
        this.impuesto = impuesto;
        this.gestorEfectivo = gestorEfectivo;
        this.gestorDeUna = gestorDeUna;
        this.gestorPromocionCajero = gestorPromocionCajero;
    }

    // --- 3. Métodos de la Interfaz IGestorFacturaCajero ---

    @Override
    public Factura generarFactura() {
        System.out.println("Lógica de generarFactura aún no implementada.");
        return null;
    }

    @Override
    public double calcularPrecio() {
        System.out.println("Lógica de calcularPrecio aún no implementada.");
        return 0.0;
    }

    @Override
    public Pago acordarEfectivo() {
        System.out.println("Lógica de acordarEfectivo aún no implementada.");
        return null;
    }

    @Override
    public Pago acordarDeUna() {
        System.out.println("Lógica de acordarDeUna aún no implementada.");
        return null;
    }

    // --- 4. Métodos de la Interfaz IGestorFacturaHeladero ---

    @Override
    public ReporteVenta generarReporteVenta() {
        System.out.println("Lógica de generarReporteVenta aún no implementada.");
        return null;
    }

    @Override
    public Factura buscarFactura() {
        System.out.println("Lógica de buscarFactura aún no implementada.");
        return null;
    }

    @Override
    public void anularFactura() {
        System.out.println("Lógica de anularFactura aún no implementada.");
    }
}