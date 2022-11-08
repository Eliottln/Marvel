package com.fr.iem.marvel.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fr.iem.marvel.R
import com.fr.iem.marvel.databinding.FragmentCharactersBinding
import com.fr.iem.marvel.databinding.FragmentComicsBinding
import com.fr.iem.marvel.model.character.MarvelCharactersResults
import com.fr.iem.marvel.model.comics.MarvelComicsResults
import com.fr.iem.marvel.view.adapters.CharactersAdapter
import com.fr.iem.marvel.view.adapters.ComicsAdapter
import com.fr.iem.marvel.viewmodel.HomeViewModel
import com.fr.iem.marvel.viewmodel.HomeViewModelImpl

class CharactersFragment : Fragment() {

    lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(requireActivity())[HomeViewModelImpl::class.java]
        binding = FragmentCharactersBinding.inflate(layoutInflater)

        val adapter = CharactersAdapter()
        binding.charactersRv.adapter = adapter
        binding.charactersRv.layoutManager = LinearLayoutManager(context)

        homeViewModel.charactersList.observe(viewLifecycleOwner) {
            adapter.charactersList = it as ArrayList<MarvelCharactersResults>
            adapter.notifyDataSetChanged()
        }

        homeViewModel.getCharacters()

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CharactersFragment()
    }
}