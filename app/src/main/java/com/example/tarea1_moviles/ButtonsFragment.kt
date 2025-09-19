package com.example.tarea1_moviles


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ButtonsFragment : Fragment() {

    private lateinit var buttonNormal: Button
    private lateinit var imageButton: ImageButton
    private lateinit var fabButton: FloatingActionButton
    private lateinit var textViewStatus: TextView
    private var clickCount = 0

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

        // Configurar Button normal
        buttonNormal.setOnClickListener {
            Toast.makeText(context, "¡Botón normal presionado!", Toast.LENGTH_SHORT).show()
            updateStatus("Botón Normal presionado")
        }

        // Configurar ImageButton
        imageButton.setOnClickListener {
            Toast.makeText(context, "¡ImageButton presionado!", Toast.LENGTH_SHORT).show()
            updateStatus("ImageButton presionado")
        }

        // Configurar FloatingActionButton
        fabButton.setOnClickListener {
            clickCount++
            val message = "FAB presionado $clickCount veces"
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            updateStatus(message)
        }
    }

    private fun updateStatus(message: String) {
        val currentTime = java.text.SimpleDateFormat("HH:mm:ss", java.util.Locale.getDefault())
            .format(java.util.Date())
        textViewStatus.text = "$message\nÚltima acción: $currentTime"
    }
}