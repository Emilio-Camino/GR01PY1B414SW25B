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
        return null;
    }


    @Override
    public void modificarCliente(Cliente cliente, String nombreMod, String cedulaMod, String direccionMod, String telefonoMod, String correoMod) {
        if (!listaClientes.contains(cliente)){
            System.out.println("Error, el cliente ya debería de existir. revisar lógica");
            return;
        }
        StringBuilder errores = new StringBuilder();
        boolean cambios = false;
        if (!cliente.getNombre().trim().equals(nombreMod)) {
            try {
                cliente.setNombre(nombreMod);
                cambios = true;
            } catch (IllegalArgumentException e) {
            errores.append("- Nombre: ").append(e.getMessage()).append("\n");
            }
        }
        
        if (!cliente.getCedula().trim().equals(cedulaMod)) {
            try {
                cliente.setCedula(cedulaMod);
                cambios = true;
            } catch (IllegalArgumentException e) {
                // Si falla la cedula, se aniade el error y se anula el cambio.
                errores.append("- Cédula: ").append(e.getMessage()).append("\n"); 
            }
        }
        
        if (!cliente.getTelefono().trim().equals(telefonoMod)) {
            try {
                cliente.setTelefono(telefonoMod);
                cambios = true;
            } catch (IllegalArgumentException e) {
                errores.append("- Teléfono: ").append(e.getMessage()).append("\n");
            }
        }

        if (!cliente.getDireccion().trim().equals(direccionMod)) {
            try {
                cliente.setDireccion(direccionMod);
                cambios = true;
            } catch (IllegalArgumentException e) {
                errores.append("- Dirección: ").append(e.getMessage()).append("\n");
            }
        }

        if (!cliente.getCorreoElectronico().trim().equals(correoMod)) {
            try {
                cliente.setCorreoElectronico(correoMod);
                cambios = true;
            } catch (IllegalArgumentException e) {
                errores.append("- Correo: ").append(e.getMessage()).append("\n");
            }
        }

        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(
                null,
                String.format("No se pudo actualizar la información del cliente debido a los siguientes errores:\n\n%s", errores.toString()),
                "Errores de Validación",
                JOptionPane.ERROR_MESSAGE
            );
        }
        else if (!cambios) {
            JOptionPane.showMessageDialog(
                null,
                "No se realizaron cambios en la información del cliente.",
                "Sin Cambios",
                JOptionPane.INFORMATION_MESSAGE
            );
        }

        else {
            // No hay errores: La actualización fue exitosa (los set de arriba funcionaron)
            JOptionPane.showMessageDialog(
                null, "¡Información del cliente actualizada con éxito!", 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    

    @Override
    public void eliminarCliente(String cedula) {
        boolean eliminado = listaClientes.removeIf(cliente -> cliente.getCedula().equals(cedula));
        if (!eliminado){
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        }
    }

    // Reemplaza el método buggy con este
    @Override
    public void registrarCliente(Cliente cliente) {
        // 1. Validar que el cliente que recibimos no sea nulo
        if (cliente == null) {
            System.out.println("GestorCliente: Se intentó registrar un cliente nulo.");
            return;
        }

        // 2. Verificar si ya existe
        if (this.buscarCliente(cliente.getCedula()) != null) {
            // Como buscarCliente es silencioso, podemos mostrar un JOptionPane aquí
            JOptionPane.showMessageDialog(null,
                    "La cédula " + cliente.getCedula() + " ya está registrada.",
                    "Error al Guardar",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Añadir el nuevo cliente (el que SÍ recibimos) a la lista
        this.listaClientes.add(cliente);
        System.out.println("GestorCliente: Cliente " + cliente.getNombre() + " añadido con éxito.");
        // (El JOptionPane de éxito ya lo muestra la VentanaCajero)
    }

    private void quemarDatosClientes() {
        // 1. Cliente Válido 1
        Cliente c1 = new Cliente(
                "Ana Gómez",
                "1712345675",
                "ana.gomez@mail.com",
                "Av. Amazonas 123, Quito",
                "0987654321"
        );
        this.listaClientes.add(c1);

        // 2. Cliente Válido 2
        Cliente c2 = new Cliente(
                "Luis Parra",
                "0920012341",
                "luis.parra@mail.com",
                "Av. Foch y Reina Victoria, Quito",
                "0991234567"
        );
        this.listaClientes.add(c2);

        // 3. Cliente Válido 3
        Cliente c3 = new Cliente(
                "María Sol",
                "0920012440",
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
