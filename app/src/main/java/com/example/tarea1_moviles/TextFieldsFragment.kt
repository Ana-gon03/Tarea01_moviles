package com.example.tarea1_moviles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class TextFieldsFragment : Fragment() {

    private lateinit var editTextNormal: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextNumber: EditText
    private lateinit var editTextMultiline: EditText
    private lateinit var buttonShowText: Button
    private lateinit var textViewResult: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_text_fields, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        editTextNormal = view.findViewById(R.id.editTextNormal)
        editTextPassword = view.findViewById(R.id.editTextPassword)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextNumber = view.findViewById(R.id.editTextNumber)
        editTextMultiline = view.findViewById(R.id.editTextMultiline)
        buttonShowText = view.findViewById(R.id.buttonShowText)
        textViewResult = view.findViewById(R.id.textViewResult)

        // Configurar botón
        buttonShowText.setOnClickListener {
            val normalText = editTextNormal.text.toString()
            val passwordText = editTextPassword.text.toString()
            val emailText = editTextEmail.text.toString()
            val numberText = editTextNumber.text.toString()
            val multilineText = editTextMultiline.text.toString()

            val result = "Texto normal: $normalText\n" +
                    "Contraseña: ${if (passwordText.isNotEmpty()) "*".repeat(passwordText.length) else "vacío"}\n" +
                    "Email: $emailText\n" +
                    "Número: $numberText\n" +
                    "Multilínea: $multilineText"

            textViewResult.text = result

            if (normalText.isNotEmpty() || passwordText.isNotEmpty() ||
                emailText.isNotEmpty() || numberText.isNotEmpty() || multilineText.isNotEmpty()) {
                Toast.makeText(context, "Datos capturados correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Ingresa al menos un valor", Toast.LENGTH_SHORT).show()
            }
        }
    }
}