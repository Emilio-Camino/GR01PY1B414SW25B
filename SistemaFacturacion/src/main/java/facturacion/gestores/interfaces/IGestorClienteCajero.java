package facturacion.gestores.interfaces;

import facturacion.elementos.Cliente;

public interface IGestorClienteCajero {
    public Cliente buscarCliente(String cedula);

    /**
     * Valida los datos y registra un nuevo cliente en el sistema.
     * @return true si el registro fue exitoso, false si hubo un error.
     */
    public boolean registrarCliente(String nombre, String cedula, String correo, String direccion, String telefono);
}