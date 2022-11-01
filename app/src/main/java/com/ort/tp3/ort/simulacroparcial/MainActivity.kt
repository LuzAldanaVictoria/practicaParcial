package com.ort.tp3.ort.simulacroparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView : BottomNavigationView
    private lateinit var navHostFragment : NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigationView()

    }

    private fun setupBottomNavigationView() {
        // Busco los componentes en la View generada por su id
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Relaciono mi Bottom Nav View con mi nav graph
        bottomNavView.setupWithNavController(navHostFragment.navController)

        // Agrego un listener para poder escuchar cada vez que se realiza una navegacion
        navHostFragment.navController.addOnDestinationChangedListener { _, destination, arguments ->

            // Si mi destino es el login entonces oculto la barra inferior. Caso contrario la muestro
            if (destination.id == R.id.logInFragment) {
                bottomNavView.visibility = View.GONE
            } else {
                bottomNavView.visibility = View.VISIBLE

                // Si mi destino es la Home, tomo el userName que recibio por parametro y lo almaceno en un Object
                if (destination.id == R.id.menu_navigation_home) {
                    arguments?.getString("username")?.let { UserSession.userName = it }
                }
            }
        }
    }

}