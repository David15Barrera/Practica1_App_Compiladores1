package graficos;

import java.io.Serializable;
import java.util.ArrayList;

public class Barra extends Grafica implements Serializable {

    private ArrayList<String> ejeX = new ArrayList<>();
    private ArrayList<Double> ejeY = new ArrayList<>();

    /**
     * Contructor para la clase barra
     */
    public Barra(String titulo, ArrayList<Integer> unir, ArrayList<String> ejeX, ArrayList<Double> ejeY) {
        super(titulo, unir);
        this.ejeX = ejeX;
        this.ejeY = ejeY;
    }

    public Barra(){
    }

    /**
     * Returna valores del ejeX
     */
    public ArrayList<String> getEjeX() {
        return ejeX;
    }

    /**
     * Obtiene los valores del ejeY
     */
    public ArrayList<Double> getEjeY() {
        return ejeY;
    }

    /**
     * Returna valor del ejeX
     */
    public void agregarEjeX(String eje){
        ejeX.add(eje);
    }

    /**
     * Agrega el valor del ejeY
     */
    public void agregarEjeY(double eje){
        ejeY.add(eje);
    }
}
