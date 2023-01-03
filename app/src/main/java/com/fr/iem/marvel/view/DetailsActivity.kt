package com.fr.iem.marvel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.fr.iem.marvel.R
import com.fr.iem.marvel.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    companion object {
        const val INTENT_ID_COMICS = "idComics"
        const val INTENT_ID_CHARACTER = "idCharacter"
    }
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var navController: NavController
    private var idComics: Int = -1
    private var idCharacter: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_details) as NavHostFragment
        navController = navHostFragment.navController

        idComics = intent.getIntExtra(INTENT_ID_COMICS, 0)
        idCharacter = intent.getIntExtra(INTENT_ID_CHARACTER, 0)

        if (idComics > 0) {
            val bundle: Bundle = bundleOf(MainActivity.INTENT_ID to idComics)
            navController.navigate(R.id.comicsDetailsFragment, bundle)
        } else {
            val bundle: Bundle = bundleOf(MainActivity.INTENT_ID to idCharacter)
            navController.navigate(R.id.charactersDetailsFragment, bundle)
        }
    }
}