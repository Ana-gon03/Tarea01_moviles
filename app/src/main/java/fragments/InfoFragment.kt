package fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.tarea1_moviles.R

class InfoFragment : Fragment() {

    private lateinit var textViewTitle: TextView
    private lateinit var textViewDescription: TextView
    private lateinit var imageView: ImageView
    private lateinit var progressBarHorizontal: ProgressBar
    private lateinit var progressBarCircular: ProgressBar
    private lateinit var buttonStartProgress: Button
    private lateinit var buttonChangeImage: Button
    private lateinit var buttonChangeText: Button

    private val handler = Handler(Looper.getMainLooper())
    private var currentImageIndex = 0
    private var currentTextIndex = 0

    // Imágenes disponibles (usando recursos del sistema Android)
    private val imageResources = listOf(
        android.R.drawable.ic_dialog_info,
        android.R.drawable.ic_menu_camera,
        android.R.drawable.ic_menu_gallery,
        android.R.drawable.ic_menu_mapmode,
        android.R.drawable.star_big_on
    )

    // Textos de ejemplo
    private val sampleTexts = listOf(
        "¡Bienvenido a la demostración de elementos informativos!",
        "Los TextView muestran texto estático o dinámico en la interfaz.",
        "Las ImageView pueden mostrar imágenes, íconos y recursos gráficos.",
        "Los ProgressBar indican el progreso de una operación o carga.",
        "Estos elementos son fundamentales para mostrar información al usuario."
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        textViewTitle = view.findViewById(R.id.textViewTitle)
        textViewDescription = view.findViewById(R.id.textViewDescription)
        imageView = view.findViewById(R.id.imageView)
        progressBarHorizontal = view.findViewById(R.id.progressBarHorizontal)
        progressBarCircular = view.findViewById(R.id.progressBarCircular)
        buttonStartProgress = view.findViewById(R.id.buttonStartProgress)
        buttonChangeImage = view.findViewById(R.id.buttonChangeImage)
        buttonChangeText = view.findViewById(R.id.buttonChangeText)

        setupButtons()

        // Configurar estado inicial
        progressBarHorizontal.progress = 0
        imageView.setImageResource(imageResources[0])
        textViewDescription.text = sampleTexts[0]
    }

    private fun setupButtons() {
        // Botón para iniciar progreso
        buttonStartProgress.setOnClickListener {
            startProgressAnimation()
        }

        // Botón para cambiar imagen
        buttonChangeImage.setOnClickListener {
            changeImage()
        }

        // Botón para cambiar texto
        buttonChangeText.setOnClickListener {
            changeText()
        }
    }

    private fun startProgressAnimation() {
        progressBarCircular.visibility = View.VISIBLE
        progressBarHorizontal.progress = 0
        buttonStartProgress.isEnabled = false

        // Simular progreso
        val progressRunnable = object : Runnable {
            override fun run() {
                val currentProgress = progressBarHorizontal.progress
                if (currentProgress < 100) {
                    progressBarHorizontal.progress = currentProgress + 5
                    handler.postDelayed(this, 100)
                } else {
                    // Progreso completado
                    progressBarCircular.visibility = View.GONE
                    buttonStartProgress.isEnabled = true
                    Toast.makeText(context, "¡Progreso completado!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        handler.post(progressRunnable)
    }

    private fun changeImage() {
        currentImageIndex = (currentImageIndex + 1) % imageResources.size
        imageView.setImageResource(imageResources[currentImageIndex])

        // Añadir animación simple
        imageView.scaleX = 0.8f
        imageView.scaleY = 0.8f
        imageView.animate()
            .scaleX(1.0f)
            .scaleY(1.0f)
            .setDuration(200)
            .start()

        Toast.makeText(context, "Imagen ${currentImageIndex + 1} de ${imageResources.size}",
            Toast.LENGTH_SHORT).show()
    }

    private fun changeText() {
        currentTextIndex = (currentTextIndex + 1) % sampleTexts.size
        textViewDescription.text = sampleTexts[currentTextIndex]

        // Añadir efecto de fade
        textViewDescription.alpha = 0.5f
        textViewDescription.animate()
            .alpha(1.0f)
            .setDuration(300)
            .start()

        Toast.makeText(context, "Texto ${currentTextIndex + 1} de ${sampleTexts.size}",
            Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}