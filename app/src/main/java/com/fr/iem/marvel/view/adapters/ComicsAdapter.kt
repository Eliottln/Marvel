package com.fr.iem.marvel.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fr.iem.marvel.R
import com.fr.iem.marvel.model.comics.MarvelComicsResults

class ComicsAdapter: RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {

    var comicsList: ArrayList<MarvelComicsResults> = arrayListOf()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var title: TextView
        init {
            title = view.findViewById(R.id.title_tv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.comics_item, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = comicsList[position].title
    }

    override fun getItemCount(): Int {
        return comicsList.size
    }
}