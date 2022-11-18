package com.fr.iem.marvel.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fr.iem.marvel.databinding.DetailItemBinding
import com.fr.iem.marvel.models.characters.MarvelCharactersResults

class CharacterDetailAdapter(val context: Context, private var onItemClicked: ((id: Int) -> Unit)): RecyclerView.Adapter<CharacterDetailAdapter.ViewHolder>() {

    var charactersList: ArrayList<MarvelCharactersResults> = arrayListOf()

    inner class ViewHolder(private val binding: DetailItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(character: MarvelCharactersResults) = binding.apply {
            val path = "${character.thumbnail?.path}.${character.thumbnail?.extension ?: "jpg"}"
            Glide.with(context)
                .load(path)
                .into(binding.image)

            root.setOnClickListener {
                onItemClicked(character.id!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DetailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(charactersList[position])
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}