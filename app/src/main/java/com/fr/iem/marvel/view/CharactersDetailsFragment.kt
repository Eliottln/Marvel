package com.fr.iem.marvel.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.fr.iem.marvel.databinding.FragmentCharactersDetailsBinding
import com.fr.iem.marvel.models.comics.MarvelComicsResults
import com.fr.iem.marvel.view.adapters.ComicsDetailAdapter
import com.fr.iem.marvel.viewmodel.DetailsViewModel
import com.fr.iem.marvel.viewmodel.DetailsViewModelImpl

class CharactersDetailsFragment: Fragment() {

    private var characterId: Int = -1
    private lateinit var binding: FragmentCharactersDetailsBinding
    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentCharactersDetailsBinding.inflate(inflater, container, false)
        detailsViewModel = ViewModelProvider(requireActivity())[DetailsViewModelImpl::class.java]
        binding.fragContent.isVisible = false
        binding.progressBar.isVisible = true
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            characterId = it.getInt(MainActivity.INTENT_ID)
        }

        val adapter = ComicsDetailAdapter(requireContext()) { id: Int ->
            val bundle: Bundle = bundleOf(MainActivity.INTENT_ID to id)
            if (MainActivity.checkForInternet(requireContext()))
                findNavController().navigate(CharactersDetailsFragmentDirections.actionCharactersDetailsFragment2ToComicsDetailsFragment().actionId, bundle)
        }
        binding.listComics.adapter = adapter
        binding.listComics.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        detailsViewModel.character.observe(viewLifecycleOwner) {
            binding.fragContent.isVisible = true
            binding.progressBar.isVisible = false
            val path = "${it.thumbnail?.path}.${it.thumbnail?.extension ?: "jpg"}"
            Glide.with(requireContext())
                .load(path)
                .into(binding.image)
            binding.name.text = it.name
            binding.description.text = "Description:\n${it.description}"
        }

        detailsViewModel.comicsList.observe(viewLifecycleOwner) {
            adapter.comicsList = it as ArrayList<MarvelComicsResults>
            adapter.notifyDataSetChanged()
        }

        if (characterId > -1) {
            detailsViewModel.getCharacterById(characterId)
            detailsViewModel.getComicsWithCharacter(characterId)
        }

    }


    companion object {

        @JvmStatic
        fun newInstance(id: Int): CharactersDetailsFragment {
            return CharactersDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(MainActivity.INTENT_ID, id)
                }
            }
        }
    }
}