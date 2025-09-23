package com.example.tarea1_moviles.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.tarea1_moviles.R

class PrimerFragmento : Fragment() {

    private lateinit var spinnerHobbies: Spinner
    private lateinit var textViewSelectedHobby: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        spinnerHobbies = view.findViewById(R.id.spinner_hobbies)
        textViewSelectedHobby = view.findViewById(R.id.textViewSelectedHobby)

        // 1. Prepara los datos (lista de hobbies)
        val hobbies = listOf(
            "Selecciona tu hobby",
            "Leer 📚",
            "Cine y series 🎬",
            "Deportes ⚽",
            "Videojuegos 🎮",
            "Música 🎧",
            "Cocinar 🍳",
            "Viajar ✈️"
        )

        // 2. Crea un ArrayAdapter
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, hobbies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // 3. Conecta el adaptador al Spinner
        spinnerHobbies.adapter = adapter

        // 4. Configura el listener para saber qué opción se seleccionó
        spinnerHobbies.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedHobby = parent?.getItemAtPosition(position).toString()
                if (position > 0) { // Evita el primer elemento de la lista
                    textViewSelectedHobby.text = "Tu hobby favorito es: $selectedHobby"
                } else {
                    textViewSelectedHobby.text = "El hobby seleccionado aparecerá aquí"
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No se hace nada
            }
        }
    }
}