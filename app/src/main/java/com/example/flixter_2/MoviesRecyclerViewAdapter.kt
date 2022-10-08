package com.example.flixter_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.flixter_2.R.id
class MoviesRecyclerViewAdapter(
    private val movies: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?
)
    : RecyclerView.Adapter<MoviesRecyclerViewAdapter.MoviesViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie, parent, false)
        return MoviesViewHolder(view)
    }
    inner class MoviesViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: Movie? = null
        val mMovieTitle: TextView = mView.findViewById<View>(id.movie_title) as TextView
        val mMovieDescription: TextView = mView.findViewById<View>(id.movie_description) as TextView
        val mMovieImage: ImageView = mView.findViewById<View>(id.movie_image) as ImageView


        override fun toString(): String {
            return mMovieTitle.toString()
        }
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]

        holder.mItem = movie
        holder.mMovieTitle.text = movie.title
        holder.mMovieDescription.text = movie.description
        var posterUrl = "https://image.tmdb.org/t/p/w500/" + movie.posterPath
        val radius = 8

        Glide.with(holder.mView)
            .load(posterUrl)
            .centerInside()
            .transform(RoundedCorners(radius))
            .into(holder.mMovieImage)

        holder.mView.setOnClickListener {
            holder.mItem?.let { movie ->
                mListener?.onItemClick(movie)
            }
        }
    }
    override fun getItemCount(): Int {
        return movies.size
    }
}