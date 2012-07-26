package benedicto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author Davlio
 */
public class AdmVenta {

    private ArrayList<Ventas> listadoVentas;

    public AdmVenta() {
        listadoVentas = new ArrayList<Ventas>();
    }
    
    public AdmVenta(ArrayList<Ventas> listadoVentas) {
        this.listadoVentas = listadoVentas;
    }

    public ArrayList<Ventas> BusquedaVentas(String concepto, String numero, Date fecEmision, String empresa, Date fecVencimiento, Date fecPago, int estado) {
        ArrayList<Ventas> listadoBusqueda = new ArrayList<Ventas>();

        // Buscar en la lista según los filtros ingresados
        for (Ventas ventas : listadoVentas) {
            if ((concepto.isEmpty() || ventas.getConcepto().startsWith(concepto))
                    && (numero.isEmpty() || ventas.getNumero().startsWith(numero))
                    && (fecEmision == null || ventas.getFecEmision().equals(fecEmision))
                    && (empresa.isEmpty() || ventas.getEmpresa().startsWith(empresa))
                    && (fecVencimiento == null || ventas.getFecVencimiento().equals(fecVencimiento))
                    && (fecPago == null || ventas.getFecPago().equals(fecPago))
                    && (estado == 0 || ventas.getEstadoVentas() == estado)) {
                listadoBusqueda.add(ventas);
            }
        }

        // Ordenar por fecha de vencimiento
        Collections.sort(listadoVentas, new VentasSort());

        return listadoBusqueda;
    }

    public void Registrar(Ventas ventas) throws BusinessException {
        if (!EsValidoRegistro(ventas)) {
            throw new BusinessException("Para registrar ingresar correctamente los datos.");
        }
        listadoVentas.add(ventas);
    }

    public Boolean EsValidoRegistro(Ventas ventas) {
        return (!ventas.getConcepto().isEmpty()
                && ventas.getFecEmision() != null
                && ventas.getFecVencimiento() != null
                && ventas.getSubTotal() > 0
                && ventas.getIgv() > 0
                && ventas.getTotal() > 0
                && ventas.getMoneda() > 0);
    }
}