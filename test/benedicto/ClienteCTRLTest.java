package benedicto;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteCTRLTest {

    @Test
    public void ctrlDebeRegistrarClientes() {
        String nombre = "Franklin";
        String apellido_paterno = "Velita";
        String apellido_materno = "Zorrilla";
        String email = "fvelita@gmail.com";
        String dni = "15447482";
        String telefono = "15474745";
        String fecha = "19/07/2012";

        ClienteCTRL admin = new ClienteCTRL();

        try {
            admin.registrarClientes(nombre, apellido_paterno, apellido_materno, email, dni, telefono, fecha);
        } catch (BusinessException ex) {
            Logger.getLogger(ClienteCTRL.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cliente cliente = admin.buscar(dni);

        assertNotNull(cliente);
        assertEquals(nombre, cliente.getNombre());
        assertEquals(apellido_paterno, cliente.getApellido_paterno());
        assertEquals(apellido_materno, cliente.getApellido_materno());
        assertEquals(email, cliente.getEmail());
        assertEquals(dni, cliente.getDni());
        assertEquals(telefono, cliente.getTelefono());
        assertEquals(fecha, cliente.getFecha());
    }

    @Test(expected = BusinessException.class)
    public void ctrlDebeRegistrarValidandoDatosIncompletosClientes()
            throws BusinessException {
        String nombre = "Franklin";
        String apellido_paterno = "";
        String apellido_materno = "";
        String email = "fvelita@gmail.com";
        String dni = "456456";
        String telefono = "56456456";
        String fecha = "19/07/2012";

        ClienteCTRL admin = new ClienteCTRL();
        admin.registrarClientes(nombre, apellido_paterno, apellido_materno, email, dni, telefono, fecha);
    }

    @Test(expected = BusinessException.class)
    public void ctrlRegistrarClientesValidandoDuplicado()
            throws BusinessException {

        String nombre = "Franklin";
        String apellido_paterno = "Velita";
        String apellido_materno = "Zorrilla";
        String email = "fvelita@gmail.com";
        String dni = "15447482";
        String telefono = "15474745";
        String fecha = "19/07/2012";

        ClienteCTRL admin = new ClienteCTRL();

        admin.registrarClientes(nombre, apellido_paterno, apellido_materno, email, dni, telefono, fecha);
        admin.registrarClientes(nombre, apellido_paterno, apellido_materno, email, dni, telefono, fecha);
    }

    @Test
    public void ctrlBorrarClientePorCodigo()
            throws BusinessException {

        String nombre = "Franklin";
        String apellido_paterno = "Velita";
        String apellido_materno = "Zorrilla";
        String email = "fvelita@gmail.com";
        String dni = "12345678";
        String telefono = "12345678";
        String fecha = "19/07/2012";

        ClienteCTRL admin = new ClienteCTRL();
        admin.registrarClientes(nombre, apellido_paterno, apellido_materno, email, dni, telefono, fecha);
        admin.eliminar(dni);
        Cliente cliente = admin.buscar(dni);
        assertNull(cliente);
    }

    @Test(expected = BusinessException.class)
    public void ctrlValidarSiExisteClientesAntesDeBorrar() throws BusinessException {

        String nombre = "Franklin";
        String apellido_paterno = "Velita";
        String apellido_materno = "Zorrilla";
        String email = "fvelita@gmail.com";
        String dni = "12345678";
        String telefono = "12345678";
        String fecha = "19/07/2012";

        ClienteCTRL admin = new ClienteCTRL();
        admin.registrarClientes(nombre, apellido_paterno, apellido_materno, email, dni, telefono, fecha);
        admin.eliminar("12345");
    }

    @Test
    public void ctrlDebeBuscar() throws BusinessException {
        ClienteCTRL clientesAdmin = new ClienteCTRL();
        clientesAdmin.registrarClientes("nombre", "materno", "paterno", "email", "11111111", "12345678", "12/12/2012");
        clientesAdmin.registrarClientes("juan", "marcos", "peres", "juan@gmail.com", "22222222", "66666666", "12/12/2012");
        clientesAdmin.registrarClientes("luis", "sota", "rios", "luis@gmail.com", "33333333", "77777777", "12/12/2012");
        ArrayList<Cliente> respuesta = clientesAdmin.buscarComo(new Cliente("ju", "ma", "pe", "ju", "22", "66", "12/12/2012"));
        Cliente cliente = respuesta.get(0);
        assertNotNull(respuesta.get(0));
        assertTrue(respuesta.size() == 1);
        assertEquals("12/12/2012", cliente.getFecha());
        assertEquals("juan", cliente.getNombre());
        assertEquals("marcos", cliente.getApellido_paterno());
        assertEquals("peres", cliente.getApellido_materno());
        assertEquals("juan@gmail.com", cliente.getEmail());
        assertEquals("22222222", cliente.getDni());
        assertEquals("66666666", cliente.getTelefono());
    }
}
