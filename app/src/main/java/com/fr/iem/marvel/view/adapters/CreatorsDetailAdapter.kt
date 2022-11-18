package com.fr.iem.marvel.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fr.iem.marvel.databinding.DetailItemBinding
import com.fr.iem.marvel.models.creators.MarvelCreatorsResults

class CreatorsDetailAdapter(val context: Context): RecyclerView.Adapter<CreatorsDetailAdapter.ViewHolder>() {

    var creatorsList: ArrayList<MarvelCreatorsResults> = arrayListOf()

    inner class ViewHolder(private val binding: DetailItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(character: MarvelCreatorsResults) = binding.apply {
            val path = "${character.thumbnail?.path}.${character.thumbnail?.extension ?: "jpg"}"
            Glide.with(context)
                .load(path)
                .into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DetailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(creatorsList[position])
    }

    override fun getItemCount(): Int {
        return creatorsList.size
    }
}