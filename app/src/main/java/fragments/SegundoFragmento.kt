package com.example.tarea1_moviles.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.example.tarea1_moviles.R

class SegundoFragmento : Fragment() {

    private lateinit var editTextDailySummary: TextInputEditText
    private lateinit var buttonSave: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_segundo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        editTextDailySummary = view.findViewById(R.id.editTextDailySummary)
        buttonSave = view.findViewById(R.id.buttonSave)

        // Configurar el OnClickListener del botón de guardar
        buttonSave.setOnClickListener {
            val summary = editTextDailySummary.text.toString().trim()
            if (summary.isNotEmpty()) {
                // Muestra el resumen del día en un Toast
                Toast.makeText(context, "Resumen guardado: $summary", Toast.LENGTH_LONG).show()
                // También puedes limpiar el campo de texto si quieres
                // editTextDailySummary.text?.clear()
            } else {
                Toast.makeText(context, "Por favor, escribe algo para guardar.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}