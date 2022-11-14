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
import com.fr.iem.marvel.models.comics.MarvelComicsResults

class ComicsAdapter(private val context: Context): RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {

    var comicsList: ArrayList<MarvelComicsResults> = arrayListOf()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var title: TextView
        var avatar: ImageView
        init {
            title = view.findViewById(R.id.name_tv)
            avatar = view.findViewById(R.id.item_iv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = comicsList[position]
        val path = "${item.thumbnail?.path}.${item.thumbnail?.extension ?: "jpg"}"
        Glide.with(context)
            .load(path)
            .into(holder.avatar)
        holder.title.text = item.title
    }

    override fun getItemCount(): Int {
        return comicsList.size
    }
}