package com.fr.iem.marvel.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fr.iem.marvel.R
import com.fr.iem.marvel.databinding.HomeItemBinding
import com.fr.iem.marvel.models.characters.MarvelCharactersResults
import com.fr.iem.marvel.models.comics.MarvelComicsResults

class CharactersAdapter(val context: Context): RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    var charactersList: ArrayList<MarvelCharactersResults> = arrayListOf()

    class ViewHolder(private val binding: HomeItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(character: MarvelCharactersResults, context: Context) = binding.apply {
            val path = "${character.thumbnail?.path}.${character.thumbnail?.extension ?: "jpg"}"
            Glide.with(context)
                .load(path)
                .into(binding.image)
            binding.name.text = character.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(charactersList[position], context)
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}