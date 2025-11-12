package facturacion.gestores.interfaces;

import facturacion.elementos.Cliente;

public interface IGestorClienteHeladero {
    public Cliente buscarCliente(String cedula);
    public void modificarCliente(Cliente cliente, String nombreMod, String cedulaMod, String direccionMod, String telefonoMod, String correoMod);
    public void eliminarCliente(String cedula);

    /**
     * Valida un número de cédula usando el algoritmo ecuatoriano.
     * @param cedula La cédula a validar.
     * @return true si la cédula es válida, false en caso contrario.
     */
    public boolean validarCedula(String cedula);
}