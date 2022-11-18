package com.fr.iem.marvel.view.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fr.iem.marvel.databinding.DetailItemBinding
import com.fr.iem.marvel.databinding.HomeItemBinding
import com.fr.iem.marvel.models.comics.MarvelComicsResults

class ComicsDetailAdapter(private val context: Context, private var onItemClicked: ((id: Int) -> Unit)): RecyclerView.Adapter<ComicsDetailAdapter.ViewHolder>() {

    var comicsList: ArrayList<MarvelComicsResults> = arrayListOf()

    inner class ViewHolder(private val binding: DetailItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(comics: MarvelComicsResults) = binding.apply {
            val path = "${comics.thumbnail?.path}.${comics.thumbnail?.extension ?: "jpg"}"
            Glide.with(context)
                .load(path)
                .into(binding.image)

            root.setOnClickListener {
                onItemClicked(comics.id!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DetailItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comicsList[position])
    }

    override fun getItemCount(): Int {
        return comicsList.size
    }
}