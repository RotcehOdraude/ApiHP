package com.amaurypm.games.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amaurypm.games.databinding.GameElementBinding
import com.amaurypm.games.model.Game
import com.bumptech.glide.Glide

/**
 * Creado por Amaury Perea Matsumura el 12/05/23
 */
class GamesAdapter(private var context: Context, private var games: ArrayList<Game>, private val clickListener: (Game) -> Unit): RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    class ViewHolder(view: GameElementBinding): RecyclerView.ViewHolder(view.root){
        val ivThumbnail = view.ivThumbnail
        val tvTitle = view.tvTitle
        val tvDeveloper = view.tvDeveloper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GameElementBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = games[position].title

        Glide.with(context)
            .load(games[position].thumbnail)
            .into(holder.ivThumbnail)

        //holder.tvDeveloper.text = "EA Sports"

        holder.itemView.setOnClickListener {
            //Para programar los eventos click al elemento completo del ViewHolder
            clickListener(games[position])
        }
    }

}

