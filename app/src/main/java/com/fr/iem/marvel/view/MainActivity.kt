package com.fr.iem.marvel.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import com.fr.iem.marvel.R
import com.fr.iem.marvel.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_comics -> {
                    switchFragment(ComicsFragment())
                    true
                }
                R.id.page_characters -> {
                    switchFragment(CharactersFragment())
                    true
                }
                else -> {false}
            }
        }

        setContentView(binding.root)
    }

    private fun switchFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}