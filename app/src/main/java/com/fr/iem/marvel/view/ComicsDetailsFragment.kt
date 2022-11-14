package com.fr.iem.marvel.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.fr.iem.marvel.databinding.FragmentComicsDetailsBinding
import com.fr.iem.marvel.viewmodel.DetailsViewModel
import com.fr.iem.marvel.viewmodel.DetailsViewModelImpl

class ComicsDetailsFragment: Fragment() {

    private var comicsId: Int = 0
    private lateinit var binding: FragmentComicsDetailsBinding
    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            comicsId = it.getInt("id")
        }
        binding = FragmentComicsDetailsBinding.inflate(layoutInflater)
        detailsViewModel = ViewModelProvider(requireActivity())[DetailsViewModelImpl::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        detailsViewModel.comics.observe(viewLifecycleOwner) {
            val path = "${it.thumbnail?.path}.${it.thumbnail?.extension ?: "jpg"}"
            Glide.with(requireContext())
            .load(path)
            .into(binding.image)
            binding.name.text = it.title
            binding.description.text = it.description
        }

        detailsViewModel.getComicsById(id)

        return binding.root
    }


    companion object {

        @JvmStatic
        fun newInstance(id: Int): ComicsDetailsFragment {
            return ComicsDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt("id", id)
                }
            }
        }
    }
}