package com.example.repasocorto2.adapters

import android.support.v7.widget.DecorContentParent
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.repasocorto2.R
import com.example.repasocorto2.models.Movie
import kotlinx.android.synthetic.main.card_view.view.*

class MovieAdapter(var movies: List<Movie>, val clickListener: (Movie) -> Unit): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position], clickListener)

    fun changeList(movies: List<Movie>){
        this.movies = movies
        notifyDataSetChanged()
    }
        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            fun bind(item: Movie, clickListener: (Movie) -> Unit) = with(itemView){
                Glide.with(itemView.context)
                    .load(item.Poster)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(movie_image_cv)

                movie_title_cv.text = item.Title
                movie_plot_cv.text = item.Plot
                movie_rate_cv.text = item.imdbRating
                movie_runtime_cv.text = item.Runtime
                this.setOnClickListener { clickListener(item) }
            }
    }
}