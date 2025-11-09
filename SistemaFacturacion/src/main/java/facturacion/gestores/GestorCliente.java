package facturacion.gestores;

import facturacion.elementos.Cliente;
import facturacion.gestores.interfaces.IGestorClienteCajero;
import facturacion.gestores.interfaces.IGestorClienteHeladero;

import javax.swing.*;
import java.util.ArrayList;


public class GestorCliente implements IGestorClienteCajero, IGestorClienteHeladero {
    private ArrayList<Cliente> listaClientes;

    public GestorCliente() {
        this.listaClientes = new ArrayList<>();
        quemarDatosClientes();
    }

    @Override
    public Cliente buscarCliente(String cedula) {
        for  (Cliente cliente : listaClientes) {
            if(cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        return null;
    }

// TODO: Necesito los items que se van a mostrar en la interfaz y que contendrán los cambios
    @Override
    public void modificarCliente(String cedula) {
        for (Cliente cliente : listaClientes) {
            if(cliente.getCedula().equals(cedula)) {
                // TODO: relacionar con labels
                String nombre = "";
                String cedulaNueva = "";
                String direccion = "";
                String telefono = "";
                String correo = "";

                try {
                    cliente.setNombre(nombre);
                    cliente.setCedula(cedulaNueva);
                    cliente.setDireccion(direccion);
                    cliente.setTelefono(telefono);
                    cliente.setCorreoElectronico(correo);
                }
                catch (IllegalArgumentException e) {
                    // lanzar algun cuadro de dialogo
                }
            }
        }
    }

    @Override
    public void eliminarCliente(String cedula) {
        boolean eliminado = listaClientes.removeIf(cliente -> cliente.getCedula().equals(cedula));
        if (!eliminado){
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        }
    }

    @Override
    public void registrarCliente () {
        String nombre = "";
        String cedula = "";
        String direccion = "";
        String telefono = "";
        String correo = "";

        Cliente clienteNuevo = new Cliente();

        try {
            clienteNuevo.setNombre(nombre);
            clienteNuevo.setCedula(cedula);
            clienteNuevo.setDireccion(direccion);
            clienteNuevo.setTelefono(telefono);
            clienteNuevo.setCorreoElectronico(correo);
        }
        catch (IllegalArgumentException e) {
            // lanzar algun cuadro de dialogo
        }
        listaClientes.add(clienteNuevo);
    }

    private void quemarDatosClientes() {
        // 1. Cliente Válido 1
        Cliente c1 = new Cliente(
                "Ana Gómez",
                "1718013350",
                "ana.gomez@mail.com",
                "Av. Amazonas 123, Quito",
                "0987654321"
        );
        this.listaClientes.add(c1);

        // 2. Cliente Válido 2
        Cliente c2 = new Cliente(
                "Luis Parra",
                "0925804008",
                "luis.parra@mail.com",
                "Av. Foch y Reina Victoria, Quito",
                "0991234567"
        );
        this.listaClientes.add(c2);

        // 3. Cliente Válido 3
        Cliente c3 = new Cliente(
                "María Sol",
                "1715806936",
                "maria.sol@mail.com",
                "Cumbayá, Quito",
                "0988888888"
        );
        this.listaClientes.add(c3);

        // 4. Consumidor Final
        Cliente cf = new Cliente(
                "Consumidor Final",
                "9999999999",
                "consumidor@final.com",
                "N/A",
                "0999999999"
        );
        this.listaClientes.add(cf);
    }

}
