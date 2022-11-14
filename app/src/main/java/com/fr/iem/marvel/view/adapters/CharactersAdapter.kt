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
import com.fr.iem.marvel.models.characters.MarvelCharactersResults

class CharactersAdapter(private val context: Context): RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    var charactersList: ArrayList<MarvelCharactersResults> = arrayListOf()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var name: TextView
        var avatar: ImageView
        init {
            name = view.findViewById(R.id.name_tv)
            avatar = view.findViewById(R.id.character_iv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = charactersList[position]
        val path = "${item.thumbnail?.path}.${item.thumbnail?.extension ?: "jpg"}"
        Glide.with(context)
            .load(path)
            .into(holder.avatar)
        holder.name.text = item.name
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}