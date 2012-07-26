package benedicto;

import java.util.ArrayList;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Davlio
 */
public class VentasTest {

    public VentasTest() {
    }

    @Test
    public void VerificarBusqueda() {
        ArrayList<Ventas> listadoBusqueda;
        ArrayList<Ventas> listadoVentas = new ArrayList<Ventas>();
        listadoVentas.add(new Ventas("Concepto1", "00075", new DateTime(2012, 5, 16, 0, 0), "Molitalia", new DateTime(2012, 5, 20, 0, 0), new DateTime(2012, 5, 16, 0, 0), 1));
        listadoVentas.add(new Ventas("Texto4", "00078", new DateTime(2012, 5, 19, 0, 0), "Nivea", new DateTime(2012, 5, 23, 0, 0), new DateTime(2012, 5, 23, 0, 0), 1));
        listadoVentas.add(new Ventas("Concepto3", "00077", new DateTime(2012, 5, 18, 0, 0), "Axes", new DateTime(2012, 5, 22, 0, 0), new DateTime(2012, 5, 21, 0, 0), 1));
        listadoVentas.add(new Ventas("Texto2", "00076", new DateTime(2012, 5, 17, 0, 0), "Backus", new DateTime(2012, 5, 21, 0, 0), new DateTime(2012, 5, 19, 0, 0), 1));

        AdmVenta admVenta = new AdmVenta(listadoVentas);
        listadoBusqueda = admVenta.BusquedaVentas("Texto", "", null, "", null, null, 0);

        System.out.println("Cantidad de registro encontrados: " + listadoBusqueda.size());

        assertEquals(true, listadoBusqueda.size() > 0);

        for (Ventas v : listadoBusqueda) {
            System.out.println(v.getConcepto() + "\t" + v.getNumero() + "\t" + v.getFecVencimiento());
        }
    }

    @Test
    public void VerificarRegistro() {
        AdmVenta admVenta = new AdmVenta();
        //Ventas ventas = new Ventas("Texto1", "000075", new DateTime(2012, 6, 15, 0, 0), "Tres ositos", 150.50, 25.86, 1, null, null, "");
        Ventas ventas = new Ventas("Texto1", "000075", new DateTime(2012, 6, 15, 0, 0), "Tres ositos", 150.50, 25.86, 225.60, 1, new DateTime(2012, 6, 15, 0, 0), new DateTime(2012, 6, 15, 0, 0), "obs");
         System.out.println(admVenta.EsValidoRegistro(ventas));
        assertEquals(true, admVenta.EsValidoRegistro(ventas));
    }
}