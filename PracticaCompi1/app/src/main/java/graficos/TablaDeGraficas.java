package graficos;

import java.io.Serializable;
import java.util.ArrayList;

import Reportes.TablaDeErrores;

public class TablaDeGraficas implements Serializable {

    private ArrayList<Grafica> listaGraficasDefinidas = new ArrayList<>();
    private ArrayList<String> cadenas = new ArrayList<>();
    private ArrayList<Double> numeros = new ArrayList<>();
    private ArrayList<Integer> enteros = new ArrayList<>();
    private TablaDeErrores errores = new TablaDeErrores();
    private Barra barra = new Barra();
    private Pie pie = new Pie();
    private int ejecuciones = 0;
    private ArrayList<Grafica> listaDeEjecuciones = new ArrayList<>();

    /**
     * Contructor de graficas
     */
    public TablaDeGraficas() {

    }

    public ArrayList<Grafica> getListaDeEjecuciones() {
        return listaDeEjecuciones;
    }

    public void setErrores(TablaDeErrores errores) {
        this.errores = errores;
    }

    public ArrayList<Grafica> getListaGraficasDefinidas() {
        return listaGraficasDefinidas;
    }

    public void setListaGraficasDefinidas(ArrayList<Grafica> listaGraficasDefinidas) {
        this.listaGraficasDefinidas = listaGraficasDefinidas;
    }

    /**
     * Reinicia las listas
     */
    public void reiniciarLista() {
        listaGraficasDefinidas.clear();
    }

    /**
     * Agrega las cadenas a una nueva
     */
    public void agregarCadenas(String cadenaNueva) {
        cadenas.add(0, cadenaNueva.substring(1, cadenaNueva.length() - 1));
    }

    /**
     * Agrega un numero a la lista
     */
    public void agregarNumeros(double nuevoNumero) {
        numeros.add(0, nuevoNumero);
    }

    public void agregarEntero(double numero1, double numero2) {
        int valor1 = (int) numero1;
        int valor2 = (int) numero2;

        enteros.add(0, valor1);
        enteros.add(1, valor2);
    }

    /**
     * Agrega una grafica en la lista
     */
    public void agregarGrafica(int valor, int linea, int columna) {
        if (ejecuciones > 0){
            errores.agregarError("DEF", linea, columna, "Sintactico", "No agregar graficas despues Ejecutar");
        } else {
            if (valor == 1) {
                if (barra.getTitulo().equals("")){
                    errores.agregarError("DEF", linea, columna, "Sintactico", "Error titulo");
                }
                if (barra.getUnir().size() == 0){
                    errores.agregarError("DEF", linea, columna, "Sintactico", "Error falta unir");
                }
                if (barra.getEjeX().size() == 0){
                    errores.agregarError("DEF", linea, columna, "Sintactico", "Error parametro EjeX");
                }
                if (barra.getEjeY().size() == 0){
                    errores.agregarError("DEF", linea, columna, "Sintactico", "Error parametro EjeY");
                }
                listaGraficasDefinidas.add(barra);
                barra = null;
                Barra nueva = new Barra();
                barra = nueva;
            } else if (valor == 2) {
                if (pie.getTipo().equals("")){
                    errores.agregarError("DEF", linea, columna, "Sintactico", "El tipo de grafica no esta definida");
                } else {
                        if (pie.getTitulo().equals("")){
                            errores.agregarError("DEF", linea, columna, "Sintactico", "Titulo faltante");
                        }
                        if (pie.getUnir().size() == 0){
                            errores.agregarError("DEF", linea, columna, "Sintactico", "DEF faltante");
                        }
                        if (pie.getEtiquetas().size() == 0){
                            errores.agregarError("DEF", linea, columna, "Sintactico", "Falta atributo de Etiquetas");
                        }
                        if (pie.getValores().size() == 0){
                            errores.agregarError("DEF", linea, columna, "Sintactico", "Falta atributo de Valores");
                        }
                    if (pie.getExtra().equals("")){
                        errores.agregarError("DEF", linea, columna, "Sintactico", "Falta atributo de extra");
                    }
                    if (pie.getTipo().equals("Porcentaje")){
                        if (pie.getTotal() != 0){
                            errores.agregarError("DEF", linea, columna, "Sintactico", "Atributo total no definido");
                        }
                    } else if (pie.getTipo().equals("Cantidad")){
                        if (pie.getTotal() == 0){
                            errores.agregarError("DEF", linea, columna, "Sintactico", "Error parametro Total");
                        }
                    }
                }
                listaGraficasDefinidas.add(pie);
                pie = null;
                Pie nuevo_pie = new Pie();
                pie = nuevo_pie;
            }
        }
    }

    /**
     * Agrega el los atributos dependiendo del valor
     */
    public void agregarTexto(String texto, int valor, int linea, int columna) {
        if (valor == 1) {
            if (("").equals(barra.getTitulo())) {
                barra.agregarTitulo(texto);
            } else {
                errores.agregarError("Titulo", linea, columna, "Sintactico", "Titulo repetido");
            }
        } else if (valor == 2) {
            if (pie.getTitulo().equals("")) {
                pie.agregarTitulo(texto);
            } else {
                errores.agregarError("Titulo", linea, columna, "Sintactico", "Titulo repetido");
            }
        } else if (valor == 3) {
            if (pie.getTipo().equals("")) {
                pie.agregarTipo(texto);
            } else {
                errores.agregarError("Tipo", linea, columna, "Sintactico", "Tipo repetido");
            }
        } else if (valor == 4) {
            if (pie.getExtra().equals("")) {
                pie.agregarExtra(texto);
            } else {
                errores.agregarError("Extra", linea, columna, "Sintactico", "Extra repetido");
            }
        }
    }

    /**
     * Asigna cadenas obtenidas
     */
    public void asignarCadenas(int valor, int linea, int columna) {
        if (valor == 1) {
            if (cadenas.isEmpty()) {
                errores.agregarError("EjeX", linea, columna, "Sintactico", "EjeX repetida");
            } else {
                for (int i = 0; i < cadenas.size(); i++) {
                    barra.agregarEjeX(cadenas.get(i));
                }
            }
        } else if (valor == 2) {
            if (cadenas.isEmpty()) {
                errores.agregarError("Etiquetas", linea, columna, "Sintactico", "Etiqueta repetida");
            } else {
                for (int i = 0; i < cadenas.size(); i++) {
                    pie.agregarEtiqueta(cadenas.get(i));
                }
            }
        }
        cadenas.clear();
    }

    /**
     * Asigna en una lista de una grafica, para ver el valor enviado
    */
    public void asignarNumeros(int valor, int linea, int columna) {
        if (valor == 1) {
            if (numeros.isEmpty()) {
                errores.agregarError("EjeY", linea, columna, "Sintactico", "EjeY repetida");
            } else {
                for (int i = 0; i < numeros.size(); i++) {
                    barra.agregarEjeY(numeros.get(i));
                }
            }
        } else if (valor == 2) {
            if (numeros.isEmpty()) {
                errores.agregarError("EjeY", linea, columna, "Sintactico", "EjeY repetida");
            } else {
                for (int i = 0; i < numeros.size(); i++) {
                    pie.agregarValor(numeros.get(i));
                }
            }
        }
        numeros.clear();
    }

    /**
     * Agregar enteros obtenidos en valores de union
     */
    public void asignarUniones(int valor, int linea, int columna) {
        if (valor == 1) {
            if (enteros.isEmpty()) {
                errores.agregarError("Unir", linea, columna, "Sintactico", "Parametro repetida");
            } else {
                for (int i = 0; i < enteros.size(); i++) {
                    barra.agregarUnion(enteros.get(i));
                }
            }

        } else if (valor == 2) {
            if (enteros.isEmpty()) {
                errores.agregarError("Unir", linea, columna, "Sintactico", "Parametro repetido");
            } else {
                for (int i = 0; i < enteros.size(); i++) {
                    pie.agregarUnion(enteros.get(i));
                }
            }
        }
        enteros.clear();
    }

    /**
     * Asigna un valor total al atributo de la grafica Pie
     */
    public void asignarTotal(double nuevo_total, int linea, int columna) {
        if (pie.getTotal() == 0) {
            pie.agregarTotal(nuevo_total);
        } else {
            errores.agregarError("Total", linea, columna, "Sintactico", "Parametro repetido");
        }

    }

    /**
     * Agrega una grafica
     */
    public void agregarEjecucion(String texto, int linea, int columna) {
        String titulo = texto.substring(1,texto.length()-1);
        boolean prueba = false;
        for (int i = 0; i < listaGraficasDefinidas.size(); i++) {
            Grafica grafica = listaGraficasDefinidas.get(i);
            if (grafica.getTitulo().equals(titulo)){
                listaDeEjecuciones.add(grafica);
                i = listaGraficasDefinidas.size();
                ejecuciones++;
                prueba = true;
            }
        }
        if (!prueba){
            errores.agregarError("Ejecutar", linea, columna, "Sintactico", "No existe");
        }
    }

    /**
     * Limpia el cuadro
     */
    public void reiniciarEjecuciones(){
        ejecuciones = 0;
        listaDeEjecuciones.clear();
    }

}



