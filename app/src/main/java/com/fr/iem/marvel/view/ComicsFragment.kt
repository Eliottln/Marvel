package com.fr.iem.marvel.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fr.iem.marvel.R
import com.fr.iem.marvel.databinding.FragmentComicsBinding
import com.fr.iem.marvel.model.comics.MarvelComicsResults
import com.fr.iem.marvel.view.adapters.ComicsAdapter
import com.fr.iem.marvel.viewmodel.HomeViewModel
import com.fr.iem.marvel.viewmodel.HomeViewModelImpl
import kotlinx.coroutines.launch

class ComicsFragment : Fragment() {

    lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentComicsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(requireActivity())[HomeViewModelImpl::class.java]
        binding = FragmentComicsBinding.inflate(layoutInflater)

        val adapter = ComicsAdapter()
        binding.comicsRv.adapter = adapter
        binding.comicsRv.layoutManager = LinearLayoutManager(context)

        homeViewModel.comicsList.observe(viewLifecycleOwner) {
            adapter.comicsList = it as ArrayList<MarvelComicsResults>
            adapter.notifyDataSetChanged()
        }

        homeViewModel.getComics()

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ComicsFragment()
    }
}