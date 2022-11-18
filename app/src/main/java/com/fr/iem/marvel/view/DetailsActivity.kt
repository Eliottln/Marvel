package com.fr.iem.marvel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
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

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_details) as NavHostFragment
        navController = navHostFragment.navController

        idComics = intent.getIntExtra(INTENT_ID_COMICS, 0)
        idCharacter = intent.getIntExtra(INTENT_ID_CHARACTER, 0)

        setContentView(binding.root)

        if (idComics > 0) {
//            ComicsDetailsFragment.newInstance(idComics)
            navController.navigate(R.id.comicsDetailsFragment)
        } else {
            navController.navigate(R.id.charactersDetailsFragment)
        }

//        switchFragment(frg)
    }

    fun switchFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentContainerDetails.id, fragment)
        fragmentTransaction.commit()
    }

}