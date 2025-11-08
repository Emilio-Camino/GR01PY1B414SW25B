/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfazGrafica;

import facturacion.gestores.*;

/**
 *
 * @author emili
 */
public class AppFacturacion {
   
    public static void main(String args[]) {

        GestorStock gestorStock = new GestorStock();
        GestorPedido gestorPedido = new GestorPedido();
        GestorCaja gestorCaja = new GestorCaja();
        GestorPromocion gestorPromocion = new GestorPromocion();
        GestorCliente gestorCliente = new GestorCliente();

        GestorFactura gestorFactura = new GestorFactura(gestorCliente, gestorPedido);
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginVentana(gestorStock, gestorPedido, gestorCaja, gestorPromocion, gestorCliente).setVisible(true);
            }
        });
    }
}
