package com.fr.iem.marvel.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.fr.iem.marvel.databinding.FragmentComicsBinding
import com.fr.iem.marvel.models.comics.MarvelComicsResults
import com.fr.iem.marvel.view.adapters.ComicsAdapter
import com.fr.iem.marvel.viewmodel.HomeViewModel
import com.fr.iem.marvel.viewmodel.HomeViewModelImpl

class ComicsFragment : Fragment() {

    lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentComicsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(requireActivity())[HomeViewModelImpl::class.java]
        binding = FragmentComicsBinding.inflate(layoutInflater)

        val adapter = ComicsAdapter(requireContext()) { id: Int ->
            val intent = Intent(requireActivity(), DetailsActivity::class.java)
            Log.d("COOOOMIICCSSIDDD", "${id}")
            intent.putExtra("id", id)
            startActivity(intent)
        }
        binding.comicsRv.adapter = adapter
        binding.comicsRv.layoutManager = GridLayoutManager(context, 2)

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