package facturacion.persistencia;

import facturacion.elementos.Cliente;
import java.util.ArrayList;

public class ClientePersist {

    /**
     * Lista estática única que almacena todos los clientes de la aplicación.
     */
    private static ArrayList<Cliente> listaClientes;

    /**
     * Bloque estático para inicializar la lista y cargar los datos
     * quemados una sola vez cuando la clase es cargada por Java.
     */
    static {
        listaClientes = new ArrayList<>();
        quemarDatosClientes();
    }

    /**
     * Busca un cliente en la lista por su número de cédula.
     * @param cedula La cédula a buscar.
     * @return El objeto Cliente si se encuentra, o null si no existe.
     */
    public static Cliente buscarCliente(String cedula) {
        for  (Cliente cliente : listaClientes) {
            if(cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Agrega un nuevo cliente a la lista de persistencia.
     * @param cliente El objeto Cliente a agregar.
     */
    public static void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    /**
     * Elimina un cliente de la lista usando su cédula.
     * @param cedula La cédula del cliente a eliminar.
     * @return true si el cliente fue encontrado y eliminado, false en caso contrario.
     */
    public static boolean eliminarCliente(String cedula) {
        return listaClientes.removeIf(cliente -> cliente.getCedula().equals(cedula));
    }

    /**
     * Devuelve una copia de la lista de todos los clientes.
     * @return Un ArrayList<Cliente> con todos los clientes registrados.
     */
    public static ArrayList<Cliente> getListaClientes() {
        return new ArrayList<>(listaClientes); // Se devuelve una copia por seguridad
    }

    /**
     * Carga datos de ejemplo en la lista de clientes.
     */
    private static void quemarDatosClientes() {
        Cliente c1 = new Cliente(
                "Ana Gómez",
                "1712345675",
                "ana.gomez@mail.com",
                "Av. Amazonas 123, Quito",
                "0987654321"
        );
        listaClientes.add(c1);

        Cliente c2 = new Cliente(
                "Luis Parra",
                "0920012341",
                "luis.parra@mail.com",
                "Av. Foch y Reina Victoria, Quito",
                "0991234567"
        );
        listaClientes.add(c2);

        Cliente c3 = new Cliente(
                "María Sol",
                "0920012440",
                "maria.sol@mail.com",
                "Cumbayá, Quito",
                "0988888888"
        );
        listaClientes.add(c3);

        Cliente cf = new Cliente(
                "Consumidor Final",
                "9999999999",
                "consumidor@final.com",
                "N/A",
                "0999999999"
        );
        listaClientes.add(cf);
    }
}