package practica.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import Reportes.Error
import Reportes.TablaDeErrores

class ErrorActivity : AppCompatActivity() {
    var tablaLayout:TableLayout?= null

    /**
     * Muestra la tabla de errores
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        tablaLayout = findViewById(R.id.tablaErrores)
        var objetoEnviado = intent.extras
        var tabla = TablaDeErrores()
        if (objetoEnviado != null){
            tabla = objetoEnviado.getSerializable("Tabla") as TablaDeErrores
        }
        var listaDeErrores = tabla.getListaDeErrores()
        agregarDatos(listaDeErrores)
    }

    /**
     * Agrega los errores en la tabla
     */
    fun agregarDatos(lista: ArrayList<Error>){
        for (i in -1 until  lista.size){
            val registro = LayoutInflater.from(this).inflate(R.layout.item_tabla_layout, null,false)
            val itemLexema = registro.findViewById<View>(R.id.itemLexema) as TextView
            val itemLinea = registro.findViewById<View>(R.id.itemLinea) as TextView
            val itemColumna = registro.findViewById<View>(R.id.itemColumna) as TextView
            val itemTipo = registro.findViewById<View>(R.id.itemTipo) as TextView
            val itemDescripcion = registro.findViewById<View>(R.id.itemDescripcion) as TextView

            if (i == -1){
                itemLexema.setText("Lexema")
                itemLexema.setBackgroundColor(Color.BLUE)
                itemLexema.setTextColor(Color.WHITE);

                itemLinea.setText("Linea")
                itemLinea.setBackgroundColor(Color.BLUE)
                itemLinea.setTextColor(Color.WHITE);

                itemColumna.setText("Columna")
                itemColumna.setBackgroundColor(Color.BLUE)
                itemColumna.setTextColor(Color.WHITE);

                itemTipo.setText("Tipo")
                itemTipo.setBackgroundColor(Color.BLUE)
                itemTipo.setTextColor(Color.WHITE);

                itemDescripcion.setText("Descripcion")
                itemDescripcion.setBackgroundColor(Color.BLUE)
                itemDescripcion.setTextColor(Color.WHITE);
            } else {

                itemLexema.setText(lista[i].getLexema())
                itemLexema.setBackgroundColor(Color.WHITE)
                itemLexema.setTextColor(Color.BLACK);


                itemLinea.setText(lista[i].getLinea().toString())
                itemLinea.setBackgroundColor(Color.WHITE)
                itemLinea.setTextColor(Color.BLACK);

                itemColumna.setText(lista[i].getColumna().toString())
                itemColumna.setBackgroundColor(Color.WHITE)
                itemColumna.setTextColor(Color.BLACK);

                itemTipo.setText(lista[i].getTipo())
                itemTipo.setBackgroundColor(Color.WHITE)
                itemTipo.setTextColor(Color.BLACK);

                itemDescripcion.setText(lista[i].getDescripcion())
                itemDescripcion.setBackgroundColor(Color.WHITE)
                itemDescripcion.setTextColor(Color.BLACK);
            }
            tablaLayout?.addView(registro)
        }
    }

    /**
     * Regresa al main
     */
    fun eventoBoton1(view: View) {
        var textoEnviado = intent.getStringExtra("textoArea");
        println("Texto Enviado: " + textoEnviado)
        val miIntent = Intent(this@ErrorActivity, MainActivity::class.java)
        miIntent.putExtra("textoArea", textoEnviado)
        startActivity(miIntent);
    }
}