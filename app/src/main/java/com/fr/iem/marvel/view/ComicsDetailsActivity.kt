package com.fr.iem.marvel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.fr.iem.marvel.R
import com.fr.iem.marvel.databinding.ActivityComicsDetailsBinding

class ComicsDetailsActivity : AppCompatActivity() {
    companion object {
        const val INTENT_ID_COMICS = "idComics"
    }

    private lateinit var binding: ActivityComicsDetailsBinding
    private lateinit var navController: NavController
    private var idComics: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityComicsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_details) as NavHostFragment
        navController = navHostFragment.navController

        idComics = intent.getIntExtra(INTENT_ID_COMICS, 0)


        val bundle: Bundle = bundleOf(MainActivity.INTENT_ID to idComics)
        navController.navigate(R.id.comicsDetailsFragment, bundle)

    }
}