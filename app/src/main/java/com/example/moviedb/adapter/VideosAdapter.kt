package com.example.moviedb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedb.databinding.VideosListBinding
import com.example.moviedb.model.Videos

class VideosAdapter : RecyclerView.Adapter<VideosAdapter.ViewHolder>() {
    class ViewHolder(videosListBinding: VideosListBinding)
        : RecyclerView.ViewHolder(videosListBinding.root) {
            val thumbnail = videosListBinding.ivThumbnail
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosAdapter.ViewHolder {
        val view = VideosListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(view)
    }

    private val differCallback = object : DiffUtil.ItemCallback<Videos>() {
        override fun areItemsTheSame(oldItem: Videos, newItem: Videos): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Videos, newItem: Videos): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this@VideosAdapter, differCallback)

    override fun onBindViewHolder(holder: VideosAdapter.ViewHolder, position: Int) {

        val video = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this)
                .load(video.thumbnail)
                .into(holder.thumbnail)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size
}