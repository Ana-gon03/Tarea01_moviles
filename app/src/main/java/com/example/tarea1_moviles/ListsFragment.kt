package com.example.tarea1_moviles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListsFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var recyclerView: RecyclerView
    private lateinit var textViewSelected: TextView

    // Datos para ListView
    private val listViewItems = listOf(
        "🍎 Manzana", "🍌 Plátano", "🍓 Fresa",
        "🍊 Naranja", "🥝 Kiwi", "🍇 Uvas"
    )

    // Datos para RecyclerView
    private val recyclerViewItems = listOf(
        AppInfo("WhatsApp", "Mensajería instantánea", "📱"),
        AppInfo("Instagram", "Red social de fotos", "📷"),
        AppInfo("YouTube", "Videos y entretenimiento", "📺"),
        AppInfo("Gmail", "Correo electrónico", "📧"),
        AppInfo("Maps", "Navegación y mapas", "🗺️"),
        AppInfo("Spotify", "Streaming de música", "🎵")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById(R.id.listView)
        recyclerView = view.findViewById(R.id.recyclerView)
        textViewSelected = view.findViewById(R.id.textViewSelected)

        setupListView()
        setupRecyclerView()
    }

    private fun setupListView() {
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            listViewItems
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = listViewItems[position]
            Toast.makeText(context, "Seleccionaste: $selectedItem", Toast.LENGTH_SHORT).show()
            textViewSelected.text = "ListView - Último seleccionado: $selectedItem"
        }
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = AppAdapter(recyclerViewItems) { app ->
            Toast.makeText(context, "App seleccionada: ${app.name}", Toast.LENGTH_SHORT).show()
            textViewSelected.text = "RecyclerView - Último seleccionado: ${app.name}\n${app.description}"
        }
        recyclerView.adapter = adapter
    }
}

// Clase de datos para las aplicaciones
data class AppInfo(
    val name: String,
    val description: String,
    val icon: String
)

// Adapter para RecyclerView
class AppAdapter(
    private val apps: List<AppInfo>,
    private val onItemClick: (AppInfo) -> Unit
) : RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    class AppViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconText: TextView = view.findViewById(R.id.iconText)
        val nameText: TextView = view.findViewById(R.id.nameText)
        val descriptionText: TextView = view.findViewById(R.id.descriptionText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_app, parent, false)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = apps[position]
        holder.iconText.text = app.icon
        holder.nameText.text = app.name
        holder.descriptionText.text = app.description

        holder.itemView.setOnClickListener { onItemClick(app) }
    }

    override fun getItemCount() = apps.size
}