package com.fr.iem.marvel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.fr.iem.marvel.R
import com.fr.iem.marvel.databinding.ActivityCharactersDetailsBinding

class CharactersDetailsActivity : AppCompatActivity() {
    companion object {
        const val INTENT_ID_CHARACTER = "idCharacter"
    }
    private lateinit var binding: ActivityCharactersDetailsBinding
    private lateinit var navController: NavController
    private var idCharacter: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersDetailsBinding.inflate(layoutInflater)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_details) as NavHostFragment
        navController = navHostFragment.navController

        idCharacter = intent.getIntExtra(INTENT_ID_CHARACTER, 0)

        setContentView(binding.root)

        val bundle: Bundle = bundleOf(MainActivity.INTENT_ID to idCharacter)
        navController.navigate(R.id.charactersDetailsFragment, bundle)
    }
}