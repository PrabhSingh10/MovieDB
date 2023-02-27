package com.example.moviedb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedb.databinding.SimilarListBinding
import com.example.moviedb.model.SimilarMovies

class SimilarAdapter : RecyclerView.Adapter<SimilarAdapter.ViewHolder>() {
    class ViewHolder(similarListBinding: SimilarListBinding)
        : RecyclerView.ViewHolder(similarListBinding.root){
            val movie = similarListBinding.ivMovies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = SimilarListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(view)
    }

    private val differCallback = object : DiffUtil.ItemCallback<SimilarMovies>() {
        override fun areItemsTheSame(oldItem: SimilarMovies, newItem: SimilarMovies): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SimilarMovies, newItem: SimilarMovies): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this@SimilarAdapter, differCallback)

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = differ.currentList[position].thumbnail

        holder.itemView.apply {
            Glide.with(this)
                .load(movie)
                .into(holder.movie)
        }
    }
}