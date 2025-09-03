package com.example.tarea1_moviles


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class SelectionFragment : Fragment() {

    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var checkBox3: CheckBox
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton
    private lateinit var switch1: Switch
    private lateinit var switch2: Switch
    private lateinit var textViewResult: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        checkBox1 = view.findViewById(R.id.checkBox1)
        checkBox2 = view.findViewById(R.id.checkBox2)
        checkBox3 = view.findViewById(R.id.checkBox3)
        radioGroup = view.findViewById(R.id.radioGroup)
        radioButton1 = view.findViewById(R.id.radioButton1)
        radioButton2 = view.findViewById(R.id.radioButton2)
        radioButton3 = view.findViewById(R.id.radioButton3)
        switch1 = view.findViewById(R.id.switch1)
        switch2 = view.findViewById(R.id.switch2)
        textViewResult = view.findViewById(R.id.textViewResult)

        setupListeners()
        updateResult()
    }

    private fun setupListeners() {
        // Listeners para CheckBoxes
        checkBox1.setOnCheckedChangeListener { _, _ -> updateResult() }
        checkBox2.setOnCheckedChangeListener { _, _ -> updateResult() }
        checkBox3.setOnCheckedChangeListener { _, _ -> updateResult() }

        // Listener para RadioGroup
        radioGroup.setOnCheckedChangeListener { _, _ -> updateResult() }

        // Listeners para Switches
        switch1.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(context,
                "Notificaciones: ${if (isChecked) "Activadas" else "Desactivadas"}",
                Toast.LENGTH_SHORT).show()
            updateResult()
        }

        switch2.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(context,
                "Modo oscuro: ${if (isChecked) "Activado" else "Desactivado"}",
                Toast.LENGTH_SHORT).show()
            updateResult()
        }
    }

    private fun updateResult() {
        val result = StringBuilder()

        // CheckBoxes seleccionados
        result.append("✅ CheckBoxes seleccionados:\n")
        val selectedCheckBoxes = mutableListOf<String>()
        if (checkBox1.isChecked) selectedCheckBoxes.add("Android")
        if (checkBox2.isChecked) selectedCheckBoxes.add("iOS")
        if (checkBox3.isChecked) selectedCheckBoxes.add("Web")

        if (selectedCheckBoxes.isNotEmpty()) {
            result.append("${selectedCheckBoxes.joinToString(", ")}\n\n")
        } else {
            result.append("Ninguno seleccionado\n\n")
        }

        // RadioButton seleccionado
        result.append("🔘 Lenguaje preferido:\n")
        when (radioGroup.checkedRadioButtonId) {
            R.id.radioButton1 -> result.append("Kotlin\n\n")
            R.id.radioButton2 -> result.append("Java\n\n")
            R.id.radioButton3 -> result.append("Dart\n\n")
            else -> result.append("Ninguno seleccionado\n\n")
        }

        // Switches
        result.append("🔄 Configuraciones:\n")
        result.append("Notificaciones: ${if (switch1.isChecked) "Activadas" else "Desactivadas"}\n")
        result.append("Modo oscuro: ${if (switch2.isChecked) "Activado" else "Desactivado"}")

        textViewResult.text = result.toString()
    }
}