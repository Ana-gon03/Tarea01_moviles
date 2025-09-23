package com.example.tarea1_moviles.fragments // Asegúrate de que este sea el paquete correcto

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tarea1_moviles.R
import com.example.tarea1_moviles.activities.SegundoActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ButtonsFragment : Fragment() {

    private lateinit var buttonNormal: Button
    private lateinit var imageButton: ImageButton
    private lateinit var fabButton: FloatingActionButton
    private lateinit var textViewStatus: TextView
    private var clickCount = 0

    // Nueva variable para el botón de navegación
    private lateinit var buttonGoToSecondActivity: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        buttonNormal = view.findViewById(R.id.buttonNormal)
        imageButton = view.findViewById(R.id.imageButton)
        fabButton = view.findViewById(R.id.fabButton)
        textViewStatus = view.findViewById(R.id.textViewStatus)
        // Inicializa el nuevo botón
        buttonGoToSecondActivity = view.findViewById(R.id.buttonGoToSecondActivity)

        // Configurar los botones existentes
        buttonNormal.setOnClickListener {
            Toast.makeText(context, "¡Botón normal presionado!", Toast.LENGTH_SHORT).show()
            updateStatus("Botón Normal presionado")
        }

        imageButton.setOnClickListener {
            Toast.makeText(context, "¡ImageButton presionado!", Toast.LENGTH_SHORT).show()
            updateStatus("ImageButton presionado")
        }

        fabButton.setOnClickListener {
            clickCount++
            val message = "FAB presionado $clickCount veces"
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            updateStatus(message)
        }

        // Configurar el nuevo botón para ir a la SegundaActividad
        buttonGoToSecondActivity.setOnClickListener {
            val intent = Intent(activity, SegundoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateStatus(message: String) {
        val currentTime = java.text.SimpleDateFormat("HH:mm:ss", java.util.Locale.getDefault())
            .format(java.util.Date())
        textViewStatus.text = "$message\nÚltima acción: $currentTime"
    }
}