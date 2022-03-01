package practica.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import graficos.Barra
import graficos.Grafica
import graficos.Pie
import graficos.TablaDeGraficas
import Reportes.Ocurrencia
import Reportes.TablaDeOcurrencias

class ActividadReporte1 : AppCompatActivity() {
    var tablaLayout2: TableLayout?= null
    var tablaLayout1: TableLayout?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_reporte1)

        tablaLayout2 = findViewById(R.id.tablaReporte2)
        tablaLayout1 = findViewById(R.id.tablaReporte1)

        var objetoEnviado = intent.extras
        var tablaDeGraficas = TablaDeGraficas()
        var tablaDeOcurrencias = TablaDeOcurrencias()

        if (objetoEnviado!=null){
            tablaDeGraficas = objetoEnviado.getSerializable("tablaDeGraficas") as TablaDeGraficas
            tablaDeOcurrencias = objetoEnviado.getSerializable("tablaDeOcurrencias") as TablaDeOcurrencias
        }
        var lista = tablaDeGraficas.listaGraficasDefinidas
        agregarDatos(lista)

        var lista2 = tablaDeOcurrencias.lista
        agregarDatos2(lista2)
    }

    /**
     * Muestra la cantidad de graficas que se presentan en la app
     */
    fun agregarDatos(lista: ArrayList<Grafica>){
        var cantidadBarras = 0;
        var cantidadPie = 0;
        for (i  in  lista.indices){
            if (lista[i] is Barra){
                cantidadBarras++
            }else if (lista[i] is Pie){
                cantidadPie++;
            }
        }
        for (i in 0..2) {
            val registro = LayoutInflater.from(this).inflate(R.layout.item_reporte1, null, false)
            val itemObjeto = registro.findViewById<View>(R.id.itemObjeto) as TextView
            val itemCantidad = registro.findViewById<View>(R.id.itemCantidad) as TextView
            if (i == 0) {
                itemObjeto.setText("Objeto")
                itemObjeto.setBackgroundColor(Color.BLUE)
                itemObjeto.setTextColor(Color.WHITE);

                itemCantidad.setText("Cantidad")
                itemCantidad.setBackgroundColor(Color.BLUE)
                itemCantidad.setTextColor(Color.WHITE);
            } else if (i == 1) {
                itemObjeto.setText("Barras")
                itemObjeto.setBackgroundColor(Color.WHITE)
                itemObjeto.setTextColor(Color.BLACK);

                itemCantidad.setText(cantidadBarras.toString())
                itemCantidad.setBackgroundColor(Color.WHITE)
                itemCantidad.setTextColor(Color.BLACK);
            } else if (i == 2) {
                itemObjeto.setText("Pie")
                itemObjeto.setBackgroundColor(Color.WHITE)
                itemObjeto.setTextColor(Color.BLACK);

                itemCantidad.setText(cantidadPie.toString())
                itemCantidad.setBackgroundColor(Color.WHITE)
                itemCantidad.setTextColor(Color.BLACK);
            }
            tablaLayout1?.addView(registro)
        }
    }

    /**
     * Agrega los datos operaciones matematicas
     */

    fun agregarDatos2(lista2: ArrayList<Ocurrencia>){
        for (i in -1 until  lista2.size){
            val registro2 = LayoutInflater.from(this).inflate(R.layout.item_reporte2, null,false)
            val itemOperador = registro2.findViewById<View>(R.id.itemOperador) as TextView
            val itemLinea = registro2.findViewById<View>(R.id.itemLineaOP) as TextView
            val itemColumna = registro2.findViewById<View>(R.id.itemColumnaOP) as TextView
            val itemEjemplo = registro2.findViewById<View>(R.id.itemEjemplo) as TextView
            if (i == -1){
                itemOperador.setText("Operador")
                itemOperador.setBackgroundColor(Color.BLUE)
                itemOperador.setTextColor(Color.WHITE);

                itemLinea.setText("Linea")
                itemLinea.setBackgroundColor(Color.BLUE)
                itemLinea.setTextColor(Color.WHITE);

                itemColumna.setText("Columna")
                itemColumna.setBackgroundColor(Color.BLUE)
                itemColumna.setTextColor(Color.WHITE);

                itemEjemplo.setText("Ocurrencia")
                itemEjemplo.setBackgroundColor(Color.BLUE)
                itemEjemplo.setTextColor(Color.WHITE);
            } else {
                itemOperador.setText(lista2[i].operador)
                itemOperador.setBackgroundColor(Color.WHITE)
                itemOperador.setTextColor(Color.BLACK);

                itemLinea.setText(lista2[i].getLinea().toString())
                itemLinea.setBackgroundColor(Color.WHITE)
                itemLinea.setTextColor(Color.BLACK);

                itemColumna.setText(lista2[i].getColumna().toString())
                itemColumna.setBackgroundColor(Color.WHITE)
                itemColumna.setTextColor(Color.BLACK);

                itemEjemplo.setText(lista2[i].ejemplo)
                itemEjemplo.setBackgroundColor(Color.WHITE)
                itemEjemplo.setTextColor(Color.BLACK);

            }
            tablaLayout2?.addView(registro2)
        }
    }
}


