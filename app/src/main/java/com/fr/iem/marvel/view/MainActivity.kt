package com.fr.iem.marvel.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.fr.iem.marvel.R
import com.fr.iem.marvel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    companion object {
        const val INTENT_ID = "idObject"

        fun checkForInternet(context: Context): Boolean {
            val isConnected = isNetworkConnected(context)
            if (!isConnected) {
                Toast.makeText(context, "Pas de connexion", Toast.LENGTH_SHORT).show()
            }
            return isConnected
        }

        private fun isNetworkConnected(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_home) as NavHostFragment
        navController = navHostFragment.navController

        binding.navView.setOnItemSelectedListener {
            if (checkForInternet(applicationContext)) {
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
            }else false
        }

    }

}