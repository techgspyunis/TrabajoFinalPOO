package benedicto;

import java.util.Comparator;

/**
 * Clase para ordernar el listado de ventas por la fecha de vencimiento
 * @author Davlio
 */
public class VentasSort implements Comparator<Ventas> {

    @Override
    public int compare(Ventas v1, Ventas v2) {
        return v1.getFecVencimiento().compareTo(v2.getFecVencimiento());
    }
    
}