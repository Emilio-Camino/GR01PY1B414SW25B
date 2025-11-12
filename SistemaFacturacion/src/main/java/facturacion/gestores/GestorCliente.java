package facturacion.gestores;

import facturacion.elementos.Cliente;
import facturacion.gestores.interfaces.IGestorClienteCajero;
import facturacion.gestores.interfaces.IGestorClienteHeladero;
import facturacion.persistencia.ClientePersist;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestorCliente implements IGestorClienteCajero, IGestorClienteHeladero {

    public GestorCliente() {
    }

    // --- METODOS ---
    //Nota: Si bien los metodos se llaman igual a los correspondientes a la clase de persistencia, estos solo delegan la tarea a ella

    @Override
    public Cliente buscarCliente(String cedula) {
        // Delegar la búsqueda a la capa de persistencia
        return ClientePersist.buscarCliente(cedula);
    }

    @Override
    public void modificarCliente(Cliente cliente, String nombreMod, String cedulaMod, String direccionMod, String telefonoMod, String correoMod) {
        // Validacion y muestra de errores

        if (cliente == null){
            System.out.println("Error, el cliente es nulo. revisar lógica");
            return;
        }

        StringBuilder errores = new StringBuilder();
        boolean cambios = false;

        if (!cliente.getNombre().trim().equals(nombreMod)) {
            if (validarNombre(nombreMod)) {
                cliente.setNombre(nombreMod);
                cambios = true;
            } else {
                errores.append("- Nombre: ").append("El nombre ingresado no es válido").append("\n");
            }
        }

        if (!cliente.getCedula().trim().equals(cedulaMod)) {
            if (validarCedula(cedulaMod)) {
                // Valida si la nueva cédula ya existe
                if (ClientePersist.buscarCliente(cedulaMod) == null) {
                    cliente.setCedula(cedulaMod);
                    cambios = true;
                } else {
                    errores.append("- Cédula: ").append("La nueva cédula ya está registrada a nombre de otro cliente.").append("\n");
                }
            } else {
                errores.append("- Cédula: ").append("La cédula ingresada no es válida").append("\n");
            }
        }

        if (!cliente.getTelefono().trim().equals(telefonoMod)) {
            if (validarTelefono(telefonoMod)) {
                cliente.setTelefono(telefonoMod);
                cambios = true;
            } else {
                errores.append("- Teléfono: ").append("El teléfono ingresado no es válido").append("\n");
            }
        }

        if (!cliente.getDireccion().trim().equals(direccionMod)) {
            if (validarDireccion(direccionMod)) {
                cliente.setDireccion(direccionMod);
                cambios = true;
            } else {
                errores.append("- Dirección: ").append("La dirección ingresada no es válida").append("\n");
            }
        }

        if (!cliente.getCorreoElectronico().trim().equals(correoMod)) {
            if (validarCorreo(correoMod)) {
                cliente.setCorreoElectronico(correoMod);
                cambios = true;
            } else {
                errores.append("- Correo: ").append("El correo ingresado no es válido").append("\n");
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
            JOptionPane.showMessageDialog(
                    null, "¡Información del cliente actualizada con éxito!",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void eliminarCliente(String cedula) {
        boolean eliminado = ClientePersist.eliminarCliente(cedula);

        if (!eliminado){
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
        }
    }

    @Override
    public boolean registrarCliente(String nombre, String cedula, String correo, String direccion, String telefono) {
        StringBuilder errores = new StringBuilder();
        if (!validarCedula(cedula)) {
            errores.append("- Cédula: ").append("La cédula ingresada no es válida").append("\n");
        }
        if (!validarNombre(nombre)) {
            errores.append("- Nombre: ").append("El nombre ingresado no es válido").append("\n");
        }
        if (!validarCorreo(correo)) {
            errores.append("- Correo: ").append("El correo ingresado no es válido").append("\n");
        }
        if (!validarTelefono(telefono)) {
            errores.append("- Teléfono: ").append("El teléfono ingresado no es válido").append("\n");
        }
        if (!validarDireccion(direccion)) {
            errores.append("- Dirección: ").append("La dirección ingresada no es válida").append("\n");
        }

        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(null, "Errores de validación:\n" + errores.toString(), "Error al Guardar", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // 2. Verificar duplicados
        if (ClientePersist.buscarCliente(cedula) != null) {
            JOptionPane.showMessageDialog(null,
                    "La cédula " + cedula + " ya está registrada.",
                    "Error al Guardar",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // 3. Creación del objeto
        Cliente cliente = new Cliente(nombre, cedula, correo, direccion, telefono);

        // 4. Llamada a Persistencia
        ClientePersist.agregarCliente(cliente);
        JOptionPane.showMessageDialog(null, "Cliente " + nombre + " añadido con éxito.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    @Override
    public boolean validarCedula(String cedula) {
        // Expone el método de validación estático a través de la interfaz.
        return GestorCliente.validarCedulaAlgoritmo(cedula);
    }

    // --- MÉTODOS DE VALIDACIÓN (LÓGICA DE NEGOCIO) ---

    private static boolean validarCedulaAlgoritmo(String cedula) {
        //Algortimo para la verificación de cedula
        int suma = 0;
        if (cedula.length() != 10) {
            return false;
        }
        else {
            int a[] = new int[cedula.length() / 2];
            int b[] = new int[(cedula.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < cedula.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(cedula.charAt(c)));
                c = c + 2;
                if (i < (cedula.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(cedula.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(cedula.charAt(cedula.length() - 1))))
                return true;
            else if (suma % 10 == 0 && cedula.charAt(cedula.length() - 1) == '0') {
                return true;
            }
            else {
                return false;
            }
        }
    }

    private static boolean validarNombre (String nombre) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚÑñ ]+$";
        Pattern patron = Pattern.compile(regex);
        Matcher coincidencia = patron.matcher(nombre);
        return coincidencia.matches();
    }

    private static boolean validarCorreo (String correo) {
        String regex = "^[\\w.!#$%&'*+/=?`{|}~^-]+@[a-zA-Z0-9.-]+$";
        Pattern patron = Pattern.compile(regex);
        Matcher coincidencia = patron.matcher(correo);
        return coincidencia.matches();
    }

    private static boolean validarTelefono (String telefono) {
        // Acepta telefonos con el prefijo 09 con 10 digitos en total y la opcion N/A
        String regex = "^(09[0-9]{8}|N/A)$";
        Pattern patron = Pattern.compile(regex);
        Matcher coincidencia = patron.matcher(telefono);
        return coincidencia.matches();
    }

    private static boolean validarDireccion(String direccion) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚÑñ0-9 ,.-/#°]+$";
        Pattern patron = Pattern.compile(regex);
        Matcher coincidencia = patron.matcher(direccion);
        return coincidencia.matches();
    }
}