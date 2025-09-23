package com.example.tarea1_moviles.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tarea1_moviles.R
import com.example.tarea1_moviles.fragments.PrimerFragmento
import com.example.tarea1_moviles.fragments.SegundoFragmento

class SegundoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segundo)

        val buttonFragment1 = findViewById<Button>(R.id.buttonFragment1)
        val buttonFragment2 = findViewById<Button>(R.id.buttonFragment2)
        // Inicializa el nuevo botón
        val buttonGoBack = findViewById<Button>(R.id.buttonGoBack)

        // Cargar el fragmento 1 por defecto al iniciar
        if (savedInstanceState == null) {
            loadFragment(PrimerFragmento())
        }

        buttonFragment1.setOnClickListener {
            loadFragment(PrimerFragmento())
        }

        buttonFragment2.setOnClickListener {
            loadFragment(SegundoFragmento())
        }

        // Configura el OnClickListener del botón de regresar
        buttonGoBack.setOnClickListener {
            finish() // Cierra la actividad actual y regresa a la anterior en la pila
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_2, fragment)
        fragmentTransaction.commit()
    }
}