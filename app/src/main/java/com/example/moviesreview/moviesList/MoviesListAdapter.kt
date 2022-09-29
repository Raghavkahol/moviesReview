package com.example.moviesreview.moviesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesreview.data.MovieItem
import com.example.moviesreview.databinding.MovieListItemBinding
import com.example.moviesreview.utils.executeAfter

internal class MoviesListAdapter() : PagingDataAdapter<MovieItem,
        MoviesListViewHolder>(MoviesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MoviesListViewHolder(MovieListItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        val movieItem = getItem(position)
        holder.binding.executeAfter {
            this.movieItem = movieItem
        }
    }
}

internal class MoviesListViewHolder(val binding: MovieListItemBinding)
    : RecyclerView.ViewHolder(binding.root)

internal object MoviesDiffCallback : DiffUtil.ItemCallback<MovieItem>() {
    override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
      return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
        return oldItem.id == newItem.id
    }
}