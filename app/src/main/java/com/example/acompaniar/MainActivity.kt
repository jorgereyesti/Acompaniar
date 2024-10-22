package com.example.acompaniar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.viewpager2.widget.ViewPager2
import com.example.acompaniar.adapters.OnboardingAdapter
import com.example.acompaniar.databinding.ActivityMainBinding
import com.example.acompaniar.presentation.ui.LoginActivity
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var nextButon: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.apply {
            introViewpager.adapter = OnboardingAdapter(this@MainActivity)

            TabLayoutMediator(tabLayout, introViewpager) { tab, position -> }.attach() //The Magical Line
            //al llegar final de pager habilita el boton
            introViewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    // Verifica si el usuario está en la última página
                    if (position == introViewpager.adapter?.itemCount?.minus(1)) {
                        // Habilitar el botón al llegar a la última página
                        btOnboarding.isEnabled = true
                        btOnboarding.visibility = View.VISIBLE
                        btOnboarding.setOnClickListener {
                            // Ir a la actividad de inicio
                            val intent = Intent(this@MainActivity, LoginActivity::class.java)
                            startActivity(intent)
                            finish() // Finaliza la actividad principal para que no pueda regresar
                        }
                    }else {
                        btOnboarding.isEnabled = false
                        btOnboarding.visibility = View.GONE
                    }
                }
            })//end of introviewpager
        } //end aply
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_graph)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}