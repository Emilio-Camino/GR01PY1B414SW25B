package facturacion.elementos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {

    private String nombre;
    private String cedula;
    private String correoElectronico;
    private String direccion;
    private String telefono;

    public Cliente(){}
    public Cliente(String nombre, String cedula, String correoElectronico, String direccion, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Funciones para validar datos
    public boolean validarCedula(String cedula) {
        //Algortimo para la verificación de cedula tomado de Legion-Developers por Juan Pinzón

        int suma = 0;
        if (cedula.length() <= 9) {
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
    
    public boolean validarCorreo (String correo) {
        //Algoritmo de validacion de correo tomado de mailtrap
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern patron = Pattern.compile(regex);
        Matcher coincidencia = patron.matcher(correo);
        return coincidencia.matches();
    }

    public boolean validarTelefono (String telefono) {
        String regex = "^09\\d{8}$";
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

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (validarNombre(nombre)) {
            this.nombre = nombre;
        }
        else {
            throw new IllegalArgumentException("El nombre ingresado no es válido");
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) throws IllegalArgumentException{
        if (validarCedula(cedula)) {
            this.cedula = cedula;
        }
        else {
            throw new IllegalArgumentException("La cédula ingresada no es válida");
        }
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) throws IllegalArgumentException {
        if (validarCorreo(correoElectronico)) {
            this.correoElectronico = correoElectronico;
        }
        else {
            throw new IllegalArgumentException("El correo ingresado no es válido");
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (validarDireccion(direccion)) {
            this.direccion = direccion;
        } else {
            throw new IllegalArgumentException("La dirección ingresada no es válida");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws IllegalArgumentException {
        if (validarTelefono(telefono)) {
            this.telefono = telefono;
        }
        else {
            throw new IllegalArgumentException("El teléfono ingresado no es válido");
        }
    }
}
