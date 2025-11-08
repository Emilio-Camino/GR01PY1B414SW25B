package facturacion.gestores;

import facturacion.elementos.Cliente;
import facturacion.gestores.interfaces.IGestorClienteCajero;
import facturacion.gestores.interfaces.IGestorClienteHeladero;

import java.util.ArrayList;


public class GestorCliente implements IGestorClienteCajero, IGestorClienteHeladero {
    private ArrayList<Cliente> clientes;

    @Override
    public Cliente buscarCliente(String cedula) {
        for  (Cliente cliente : clientes) {
            if(cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

// TODO: Necesito los items que se van a mostrar en la interfaz y que contendrán los cambios
    @Override
    public void modificarCliente(String cedula) {
        for (Cliente cliente : clientes) {
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
        clientes.removeIf(cliente -> cliente.getCedula().equals(cedula));
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
        clientes.add(clienteNuevo);
    }
}
