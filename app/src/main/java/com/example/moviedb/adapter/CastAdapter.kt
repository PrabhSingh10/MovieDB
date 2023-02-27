package com.example.moviedb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviedb.R
import com.example.moviedb.databinding.CastCrewListBinding
import com.example.moviedb.model.CastCrew

class CastAdapter : RecyclerView.Adapter<CastAdapter.ViewHolder>() {
    class ViewHolder(castCrewListBinding: CastCrewListBinding)
        :RecyclerView.ViewHolder(castCrewListBinding.root){
        val person = castCrewListBinding.ivPerson
        val name = castCrewListBinding.tvName
        val cast = castCrewListBinding.tvRole
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastAdapter.ViewHolder {
        val view = CastCrewListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(view)
    }

    private val differCallback = object : DiffUtil.ItemCallback<CastCrew>() {
        override fun areItemsTheSame(oldItem: CastCrew, newItem: CastCrew): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CastCrew, newItem: CastCrew): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this@CastAdapter, differCallback)

    override fun onBindViewHolder(holder: CastAdapter.ViewHolder, position: Int) {
        val cast = differ.currentList[position]

        holder.cast.text = cast.role
        holder.name.text = cast.name
        holder.itemView.apply {
            Glide.with(this)
                .load(cast.image)
                .apply(
                    RequestOptions().placeholder(R.drawable.ic_person)
                )
                .into(holder.person)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size
}