package com.fr.iem.marvel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.fr.iem.marvel.R
import com.fr.iem.marvel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_home) as NavHostFragment
        navController = navHostFragment.navController

        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_comics -> {
                    navController.navigate(R.id.comicsFragment)
                    true
                }
                R.id.page_characters -> {
                    navController.navigate(R.id.charactersFragment)
                    true
                }
                else -> {false}
            }
        }


    }

}