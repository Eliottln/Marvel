package com.fr.iem.marvel.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.fr.iem.marvel.databinding.FragmentComicsDetailsBinding
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
            comicsId = it.getInt(DetailsActivity.INTENT_ID_COMICS)
        }

        detailsViewModel.comics.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = false
            val path = "${it.thumbnail?.path}.${it.thumbnail?.extension ?: "jpg"}"
            Glide.with(requireContext())
                .load(path)
                .into(binding.image)
            binding.name.text = it.title
            binding.description.text = "Description:\n${it.description}"



        }

        detailsViewModel.getComicsById(comicsId)

    }


    companion object {

        @JvmStatic
        fun newInstance(id: Int): ComicsDetailsFragment {
            return ComicsDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(DetailsActivity.INTENT_ID_COMICS, id)
                }
            }
        }
    }
}