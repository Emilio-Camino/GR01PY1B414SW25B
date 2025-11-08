package facturacion.gestores.interfaces;

import facturacion.elementos.Cliente;

public interface IGestorClienteHeladero {
    public void modificarCliente(String cedula);
    public void eliminarCliente(String cedula);
}
