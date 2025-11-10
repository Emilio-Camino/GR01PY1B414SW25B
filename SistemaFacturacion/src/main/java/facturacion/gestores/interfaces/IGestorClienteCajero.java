package facturacion.gestores.interfaces;

import facturacion.elementos.Cliente;

public interface IGestorClienteCajero {
    public Cliente buscarCliente(String cedula);
    public void registrarCliente(Cliente cliente);
}
