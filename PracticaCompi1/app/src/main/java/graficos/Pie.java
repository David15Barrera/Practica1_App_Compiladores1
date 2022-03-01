package graficos;

import java.io.Serializable;
import java.util.ArrayList;

public class Pie extends Grafica implements Serializable {

    private ArrayList<String> etiquetas = new ArrayList<>();
    private ArrayList<Double> valores = new ArrayList<>();
    private String tipo = "";
    private double total = 0;
    private String extra = "";

    /**
     * Contructor de la clase Pie
     */
    public Pie(String titulo, ArrayList<Integer> unir, ArrayList<String> etiquetas, ArrayList<Double> valores, String tipo, double total, String extra) {
        super(titulo, unir);
        this.etiquetas = etiquetas;
        this.valores = valores;
        this.tipo = tipo;
        this.total = total;
        this.extra = extra;
    }

     public Pie() {

    }

    /**
     * Captura las etiquetas de las graficas
     */
    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    /**
     * Captura la lista de las etiquetas
     */
    public ArrayList<Double> getValores() {
        return valores;
    }

    /**
     * Cpatura el tipo de grafica
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Captura el total de una grafica
     */
    public double getTotal() {
        return total;
    }

    /**
     * Captura el atributo extra de la grafica
     */
    public String getExtra() {
        return extra;
    }

    /**
     * Agrega una etiqueta a la lista de etiquetas
     */
    public void agregarEtiqueta(String etiqueta){
        etiquetas.add(etiqueta);
    }

    /**
     * Agrega un valor a la lista de valores
     */
    public void agregarValor(double valor){
        valores.add(valor);
    }

    /**
     * Agrega un total a la grafica
     */
    public void agregarTotal(double nuevoTotal){
        total = nuevoTotal;
    }

    /**
     * Agrega el tipo de grafica
     */
    public void agregarTipo(String nuevo_tipo){
        tipo = nuevo_tipo;
    }

    /**
     * Agrega el parametro de extra
     */
    public void agregarExtra(String nuevo_extra){
        extra = nuevo_extra;
    }
}
