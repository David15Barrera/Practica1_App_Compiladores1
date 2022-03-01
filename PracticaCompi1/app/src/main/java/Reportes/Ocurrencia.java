package Reportes;

import java.io.Serializable;

public class Ocurrencia implements Serializable {

    private String operador;
    private int linea;
    private int columna;
    private String ejemplo;

    /**
     * Constructor de la clase Ocurrencia Matematicas
     */
    public Ocurrencia(String operador, int linea, int columna, String ejemplo) {
        this.operador = operador;
        this.linea = linea;
        this.columna = columna;
        this.ejemplo = ejemplo;
    }

    public Ocurrencia(){

    }

    /**
     * Devuelve el operador
     */
    public String getOperador() {
        return operador;
    }

    /**
     * Establece un operadorador
     */
    public void setOperador(String operador) {
        this.operador = operador;
    }

    /**
     * Devuelve la linea en donde ocurre la ocurrencia
     */
    public int getLinea() {
        return linea;
    }

    /**
     * LInea donde se establece una ocurrencia
     */
    public void setLinea(int linea) {
        this.linea = linea;
    }

    /**
     * Devuelve el valor de la columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Establece la columna en donde ocurre la ocurrencia
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Devuelve el ejemplo de la ocurrencia
     */
    public String getEjemplo() {
        return ejemplo;
    }

    /**
     * Obtiene el valor del ejemplo de la ocurrencia
     */
    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }
}
