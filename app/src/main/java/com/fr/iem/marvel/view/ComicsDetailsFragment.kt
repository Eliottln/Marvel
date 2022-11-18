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
import com.fr.iem.marvel.databinding.FragmentComicsDetailsBinding
import com.fr.iem.marvel.models.characters.MarvelCharactersResults
import com.fr.iem.marvel.models.creators.MarvelCreatorsResults
import com.fr.iem.marvel.view.adapters.CharactersDetailAdapter
import com.fr.iem.marvel.view.adapters.CreatorsDetailAdapter
import com.fr.iem.marvel.viewmodel.DetailsViewModel
import com.fr.iem.marvel.viewmodel.DetailsViewModelImpl

class ComicsDetailsFragment: Fragment() {

    private var comicsId: Int = 0
    private lateinit var binding: FragmentComicsDetailsBinding
    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentComicsDetailsBinding.inflate(inflater, container, false)
        detailsViewModel = ViewModelProvider(requireActivity())[DetailsViewModelImpl::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            comicsId = it.getInt(MainActivity.INTENT_ID)
        }

        val adapterCharacters = CharactersDetailAdapter(requireContext()) { id: Int ->
            val bundle: Bundle = bundleOf(MainActivity.INTENT_ID to id)
            findNavController().navigate(ComicsDetailsFragmentDirections.actionComicsDetailsFragmentToCharactersDetailsFragment().actionId, bundle)
        }
        binding.listCharacters.adapter = adapterCharacters
        binding.listCharacters.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val adapterCreators = CreatorsDetailAdapter(requireContext())
        binding.listCreators.adapter = adapterCreators
        binding.listCreators.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        detailsViewModel.comics.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = false
            val path = "${it.thumbnail?.path}.${it.thumbnail?.extension ?: "jpg"}"
            Glide.with(requireContext())
                .load(path)
                .into(binding.image)
            binding.name.text = it.title
            binding.description.text = "Description:\n${it.description}"
        }

        detailsViewModel.charactersList.observe(viewLifecycleOwner) {
            adapterCharacters.charactersList = it as ArrayList<MarvelCharactersResults>
            adapterCharacters.notifyDataSetChanged()
        }

        detailsViewModel.creatorsList.observe(viewLifecycleOwner) {
            adapterCreators.creatorsList = it as ArrayList<MarvelCreatorsResults>
            adapterCharacters.notifyDataSetChanged()
        }

        detailsViewModel.getComicsById(comicsId)
        detailsViewModel.getCharactersInComics(comicsId)
        detailsViewModel.getCreatorsOfComics(comicsId)

    }


    companion object {

        @JvmStatic
        fun newInstance(id: Int): ComicsDetailsFragment {
            return ComicsDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(MainActivity.INTENT_ID, id)
                }
            }
        }
    }
}