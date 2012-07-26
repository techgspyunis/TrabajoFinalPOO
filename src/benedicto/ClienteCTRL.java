package benedicto;

import java.util.ArrayList;

public class ClienteCTRL {

    private ArrayList<Cliente> clientes;

    public ClienteCTRL() {
        clientes = new ArrayList<Cliente>();
    }

    private void validarDatos(String nombre, String apellido_paterno, String apellido_materno, String email, String dni, String telefono, String fecha)
            throws BusinessException {
        String msg = "";
        if (nombre == null || nombre.isEmpty()) {
            msg += "\nEl nombre esta vacio o nulo";
        }
        if (apellido_paterno == null || apellido_paterno.isEmpty()) {
            msg += "\nEl apellido paterno esta vacio o nulo";
        }
        if (apellido_materno == null || apellido_paterno.isEmpty()) {
            msg += "\nEl apellido materno esta vacio o nulo";
        }
        if (email == null || email.isEmpty()) {
            msg += "\nEl email esta vacio o nulo";
        }
        if (fecha == null || fecha.isEmpty()) {
            msg += "\nFecha esta vacio o nulo";
        }
        if (!msg.isEmpty()) {
            throw new BusinessException(msg);
        }
    }

    private void validarDuplicidad(String dni)
            throws BusinessException {
        if (buscar(dni) != null) {
            String msg = "El dni " + dni + " ya existe !";
            throw new BusinessException(msg);
        }
    }

    public void registrarClientes(String nombre, String apellido_paterno, String apellido_materno, String email, String dni, String telefono, String fecha)
            throws BusinessException {
        validarDatos(nombre, apellido_paterno, apellido_materno, email, dni, telefono, fecha);
        validarDuplicidad(dni);
        getClientes().add(new Cliente(nombre, apellido_paterno, apellido_materno, email, dni, telefono, fecha));
    }

    public Cliente buscar(String dni) {
        for (Cliente cliente : getClientes()) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    private void validarExistenciaCliente(String dni)
            throws BusinessException {
        if (buscar(dni) == null) {
            String msg = "El dni " + dni + " no existe!";
            throw new BusinessException(msg);
        }
    }

    public void eliminar(String dni) throws BusinessException {
        validarExistenciaCliente(dni);
        getClientes().remove(buscar(dni));
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

//public ArrayList<Clientes> buscarComo(Clientes clienteBuscado) {
//        ArrayList<Clientes> respuesta = new ArrayList<Clientes>();
//
//        for (Clientes clienteActual : getClientes()) {
//
//            boolean debeAgregar = seParecen(clienteBuscado, clienteActual);
//
//
//            if (debeAgregar) {
//                respuesta.add(clienteActual);
//            }
//        }
//
//
//        return respuesta;
//    }
////
////    private boolean seParecen(Clientes buscado, Clientes actual) {
////        boolean respuesta = true;
////        respuesta &= buscado.getFecha().isEmpty() || actual.getFecha().startsWith(buscado.getFecha());
////        respuesta &= buscado.getCodigo().isEmpty() || actual.getCodigo().startsWith(buscado.getCodigo());
////        respuesta &= buscado.getNombre().isEmpty() || actual.getNombre().startsWith(buscado.getNombre());
////        respuesta &= buscado.getApellido_materno().isEmpty() || actual.getApellido_materno().startsWith(buscado.getApellido_materno());
////        respuesta &= buscado.getApellido_paterno().isEmpty() || actual.getApellido_paterno().startsWith(buscado.getApellido_paterno());
////        respuesta &= buscado.getEmail().isEmpty() || actual.getEmail().startsWith(buscado.getEmail());
////        respuesta &= ((int) actual.getDni() + "").startsWith(((int) buscado.getDni() + ""));
////        respuesta &= ((int) actual.getTelefono() + "").startsWith(((int) buscado.getTelefono() + ""));
////
////        return respuesta;
////    }
// 
//    private boolean seParecen(Clientes buscado, Clientes actual) {
//boolean respuesta = true;
//respuesta &= buscado.getFecha().isEmpty() || actual.getFecha().startsWith(buscado.getFecha());
//respuesta &= buscado.getCodigo().isEmpty() || actual.getCodigo().startsWith(buscado.getCodigo());
//respuesta &= buscado.getNombre().isEmpty() || actual.getNombre().startsWith(buscado.getNombre());
//respuesta &= buscado.getApellido_materno().isEmpty() || actual.getApellido_materno().startsWith(buscado.getApellido_materno());
//respuesta &= buscado.getApellido_paterno().isEmpty() || actual.getApellido_paterno().startsWith(buscado.getApellido_paterno());
//respuesta &= buscado.getEmail().isEmpty() || actual.getEmail().startsWith(buscado.getEmail());
//respuesta &= buscado.getDni()==0 ||((double) actual.getDni() + "").startsWith(((double) buscado.getDni() + ""));
//respuesta &= buscado.getTelefono()==0 ||((double) actual.getTelefono() + "").startsWith(((double) buscado.getTelefono() + ""));
//
//return respuesta;
//}
    public ArrayList<Cliente> buscarComo(Cliente clienteBuscado) {
        ArrayList<Cliente> respuesta = new ArrayList<Cliente>();
        for (Cliente clienteActual : getClientes()) {
            boolean debeAgregar = seParecen(clienteBuscado, clienteActual);

            if (debeAgregar) {
                respuesta.add(clienteActual);
            }
        }
        return respuesta;
    }

    private boolean seParecen(Cliente buscado, Cliente actual) {
        boolean respuesta = true;
        respuesta &= buscado.getFecha().isEmpty() || actual.getFecha().startsWith(buscado.getFecha());
        respuesta &= buscado.getNombre().isEmpty() || actual.getNombre().startsWith(buscado.getNombre());
        respuesta &= buscado.getApellido_materno().isEmpty() || actual.getApellido_materno().startsWith(buscado.getApellido_materno());
        respuesta &= buscado.getApellido_paterno().isEmpty() || actual.getApellido_paterno().startsWith(buscado.getApellido_paterno());
        respuesta &= buscado.getEmail().isEmpty() || actual.getEmail().startsWith(buscado.getEmail());
        respuesta &= buscado.getDni().isEmpty() || actual.getDni().startsWith(buscado.getDni());
        respuesta &= buscado.getTelefono().isEmpty() || actual.getTelefono().startsWith(buscado.getTelefono());

        return respuesta;
    }
}
