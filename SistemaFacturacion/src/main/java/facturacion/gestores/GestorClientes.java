package facturacion.gestores;

// Importaciones de Java
import java.util.ArrayList;
import java.util.List;

// Importaciones de elementos
import facturacion.elementos.Cliente;

public class GestorClientes {

    // --- 1. Atributos ---
    private List<Cliente> clientes;

    // --- 2. Constructor ---
    public GestorClientes() {
        // Inicializamos la lista de clientes
        this.clientes = new ArrayList<>();
    }

    // --- 3. Métodos (con lógica adaptada a Cliente.java) ---

    /**
     * Busca un cliente en la lista por su Cédula.
     * (Cambiamos de 'nombre' a 'cedula' porque es un identificador único).
     * @param cedula La cédula del cliente a buscar.
     * @return El objeto Cliente si se encuentra, o null si no.
     */
    public Cliente buscarCliente(String cedula) {
        for (Cliente cliente : clientes) {
            // Usamos .getCedula() y .equals() para comparar
            if (cliente.getCedula().equals(cedula)) {
                return cliente; // Encontrado
            }
        }
        return null; // No encontrado
    }

    /**
     * Registra un nuevo cliente usando el constructor de la clase Cliente.
     * @param nombre El nombre del cliente.
     * @param cedula La cédula del cliente.
     * @param correoElectronico El correo del cliente.
     * @param direccion La dirección del cliente.
     * @return El nuevo objeto Cliente, o null si la cédula ya existe.
     */
    public Cliente registrarCliente(String nombre, String cedula, String correoElectronico, String direccion) {
        
        // Verificamos que el cliente no exista ya (buena práctica)
        if (buscarCliente(cedula) != null) {
            System.out.println("Error: Ya existe un cliente con la cédula " + cedula);
            return null; // Retornamos null indicando que no se pudo crear
        }

        // 1. Usamos el constructor de la clase Cliente
        Cliente nuevoCliente = new Cliente(nombre, cedula, correoElectronico, direccion);
        
        // 2. Añadimos el nuevo cliente a la lista
        this.clientes.add(nuevoCliente);
        
        System.out.println("Cliente registrado: " + nombre);
        return nuevoCliente;
    }

    /**
     * Modifica los datos de un cliente existente, buscado por su Cédula.
     * La cédula no se puede modificar.
     * @param cedula La cédula del cliente a modificar.
     * @param nuevoNombre El nuevo nombre.
     * @param nuevoCorreo El nuevo correo.
     * @param nuevaDireccion La nueva dirección.
     */
    public void modificarCliente(String cedula, String nuevoNombre, 
                                 String nuevoCorreo, String nuevaDireccion) {
        
        // 1. Usamos nuestro método de búsqueda
        Cliente clienteAModificar = buscarCliente(cedula);

        // 2. Verificamos si se encontró
        if (clienteAModificar != null) {
            // 3. Actualizamos los datos usando los setters de Cliente.java
            clienteAModificar.setNombre(nuevoNombre);
            clienteAModificar.setCorreoElectronico(nuevoCorreo);
            clienteAModificar.setDireccion(nuevaDireccion);
            
            System.out.println("Cliente con cédula " + cedula + " modificado.");
        } else {
            System.out.println("No se pudo modificar: Cliente con cédula " + cedula + " no encontrado.");
        }
    }

    /**
     * Elimina un cliente de la lista, buscándolo por su Cédula.
     * @param cedula La cédula del cliente a eliminar.
     */
    public void eliminarCliente(String cedula) {
        
        // Usamos removeIf con una expresión lambda
        boolean eliminado = this.clientes.removeIf(
            cliente -> cliente.getCedula().equals(cedula)
        );

        if (eliminado) {
            System.out.println("Cliente con cédula " + cedula + " eliminado.");
        } else {
            System.out.println("No se pudo eliminar: Cliente con cédula " + cedula + " no encontrado.");
        }
    }
}