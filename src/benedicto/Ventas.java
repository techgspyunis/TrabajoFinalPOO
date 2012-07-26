package benedicto;

import org.joda.time.DateTime;

/**
 *
 * @author Davlio
 */
public class Ventas {

    private String concepto;
    private String numero;
    private DateTime fecEmision;
    private String empresa;
    private DateTime fecVencimiento;
    private DateTime fecPago;
    private int estadoVentas;
    private double subTotal;
    private double igv;
    private int moneda;
    private double total;
    private String observaciones;

    public Ventas() {
    }

    public Ventas(String concepto, String numero, DateTime fecEmision, String empresa, DateTime fecVencimiento, DateTime fecPago, int estado) {
        this.concepto = concepto;
        this.numero = numero;
        this.fecEmision = fecEmision;
        this.empresa = empresa;
        this.fecVencimiento = fecVencimiento;
        this.fecPago = fecPago;
        this.estadoVentas = estado;
    }

    public Ventas(String concepto, String numero, DateTime fecEmision, String empresa, double subTotal, double igv, double total, int moneda, DateTime fecVencimiento, DateTime fecPago, String observaciones) {
        this.concepto = concepto;
        this.numero = numero;
        this.fecEmision = fecEmision;
        this.empresa = empresa;
        this.subTotal = subTotal;
        this.igv = igv;
        this.total = total;
        this.moneda = moneda;
        this.fecVencimiento = fecVencimiento;
        this.fecPago = fecPago;
        this.observaciones = observaciones;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getEstadoVentas() {
        return estadoVentas;
    }

    public void setEstadoVentas(int estadoVentas) {
        this.estadoVentas = estadoVentas;
    }

    public DateTime getFecEmision() {
        return fecEmision;
    }

    public void setFecEmision(DateTime fecEmision) {
        this.fecEmision = fecEmision;
    }

    public DateTime getFecPago() {
        return fecPago;
    }

    public void setFecPago(DateTime fecPago) {
        this.fecPago = fecPago;
    }

    public DateTime getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(DateTime fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}