package graficos;

import java.io.Serializable;
import java.util.ArrayList;

public class Grafica implements Serializable {

    private String titulo = "";
    private ArrayList<Integer> unir = new ArrayList<>();

    /**
     * Constructor de la clase Padre de las graficas
     */
    public Grafica(String titulo, ArrayList<Integer> unir) {
        this.titulo = titulo;
        this.unir = unir;
    }

      public Grafica() {
    }

    /**
     * Captura el titulo de la grafica
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene los valores del parametro Unir
     */
    public ArrayList<Integer> getUnir() {
        return unir;
    }

    /**
     * Agrega el valor de las uniones
      */
    public void agregarUnion(int union){
        unir.add(union);
    }

    /**
     * Agrega el titulo de la grafica
     */
    public  void agregarTitulo(String nuevotitulo){
        titulo = nuevotitulo.substring(1, nuevotitulo.length()-1);
    }

}
