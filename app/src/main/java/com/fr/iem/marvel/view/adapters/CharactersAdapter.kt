package com.fr.iem.marvel.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fr.iem.marvel.R
import com.fr.iem.marvel.model.character.MarvelCharactersResults
import com.fr.iem.marvel.model.comics.MarvelComicsResults

class CharactersAdapter: RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    var charactersList: ArrayList<MarvelCharactersResults> = arrayListOf()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var name: TextView
        init {
            name = view.findViewById(R.id.name_tv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = charactersList[position].name
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}