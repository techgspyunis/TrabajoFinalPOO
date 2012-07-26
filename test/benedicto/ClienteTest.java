package benedicto;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class ClienteTest {

    public ClienteTest() {
    }

    @Test
    public void clienteCreadoConTodosLosDatos() {

        String nombre = "Franklin";
        String apellido_paterno = "Velita";
        String apellido_materno = "Zorrilla";
        String email = "fvelita@gmail.com";
        String dni = "15445474";
        String telefono = "15755174";
        String fecha = "19/07/2012";

        Cliente cliente = new Cliente(nombre, apellido_paterno, apellido_materno, email, dni, telefono, fecha);
        assertNotNull(cliente);
        assertEquals(nombre, cliente.getNombre());
        assertEquals(apellido_paterno, cliente.getApellido_paterno());
        assertEquals(apellido_materno, cliente.getApellido_materno());
        assertEquals(email, cliente.getEmail());
        assertEquals(dni, cliente.getDni());
        assertEquals(telefono, cliente.getTelefono());
        assertEquals(fecha, cliente.getFecha());
    }
}
