package facturacion.gestores.interfaces;

import facturacion.elementos.Cliente;


public interface IGestorClienteHeladero {
    public Cliente buscarCliente(String cedula);
    public void modificarCliente(Cliente cliente, String nombreMod, String cedulaMod, String direccionMod, String telefonoMod, String correoMod);
    public void eliminarCliente(String cedula);
}
