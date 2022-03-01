package practica.main

import analisis.AnalizadorLexico
import analisis.parser
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import Reportes.TablaDeErrores
import graficos.TablaDeGraficas
import java.io.StringReader
import android.content.Intent
import Reportes.TablaDeOcurrencias


var tabla: TablaDeErrores = TablaDeErrores()
var graficas:TablaDeGraficas = TablaDeGraficas()
var operadores:TablaDeOcurrencias = TablaDeOcurrencias()

class MainActivity : AppCompatActivity() {
    /**
     * Pagina inicial
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nuevoTexto = intent.getStringExtra("textoArea")
        var areaTexto:EditText = findViewById(R.id.areaTexto)

        areaTexto.setText(nuevoTexto);
    }

    fun eventoBoton1(view: View) {
        tabla.reiniciarTabla()
        graficas.reiniciarLista()
        graficas.reiniciarEjecuciones()
        var areaTexto:EditText = findViewById(R.id.areaTexto)
        var texto = areaTexto.text.toString();
        println(texto)
        val str = StringReader(texto)
        val analizador = AnalizadorLexico(str)
        var par: parser = parser(analizador)
        graficas.setErrores(tabla)
        par.setTabla(tabla)
        par.setGraficas(graficas);
        par.setTablaDeOcurrencias(operadores)
        analizador.setTabla(tabla)
        try {
            par.parse()
        } catch (e: Exception) {
            println(e.printStackTrace())
        }

        if (tabla.getCantidadErrores() > 0){

        } else {
            val miIntent = Intent(this@MainActivity, EjecucionGraficas::class.java)
            var miBundle = Bundle()
            miBundle.putSerializable("tablaDeGraficas", graficas)
            miBundle.putSerializable("tablaDeOcurrencias", operadores)
            miBundle.putString("textoArea", texto)
            miIntent.putExtras(miBundle)
            startActivity(miIntent)
        }
    }

    fun ReporteError(view: View) {
        if (tabla.getCantidadErrores() > 0){
        var areaTexto:EditText = findViewById(R.id.areaTexto)
        var texto = areaTexto.text.toString();
        var lista = tabla.getListaDeErrores()
        val miIntent = Intent(this@MainActivity, ErrorActivity::class.java)
        val miBundle = Bundle()
        miBundle.putSerializable("Tabla", tabla)
        miBundle.putString("textoArea", texto)
        miIntent.putExtras(miBundle)
        startActivity(miIntent)
    }
    }
}