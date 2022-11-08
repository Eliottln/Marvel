package com.fr.iem.marvel.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import com.fr.iem.marvel.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {

        val bottomNavigation: BottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigation.setOnItemSelectedListener {
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

        return super.onCreateView(name, context, attrs)
    }

    private fun switchFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}