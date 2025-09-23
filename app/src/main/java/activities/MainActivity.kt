package activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import fragments.InfoFragment
import fragments.ListsFragment
import com.example.tarea1_moviles.R
import fragments.SelectionFragment
import fragments.TextFieldsFragment
import com.example.tarea1_moviles.fragments.ButtonsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Cargar el primer fragment por defecto
        if (savedInstanceState == null) {
            loadFragment(TextFieldsFragment())
        }

        bottomNavigation.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_textfields -> TextFieldsFragment()
                R.id.nav_buttons -> ButtonsFragment()
                R.id.nav_selection -> SelectionFragment()
                R.id.nav_lists -> ListsFragment()
                R.id.nav_info -> InfoFragment()
                else -> TextFieldsFragment()
            }
            loadFragment(fragment)
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}