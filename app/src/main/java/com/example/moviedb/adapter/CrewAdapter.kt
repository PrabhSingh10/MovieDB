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

class CrewAdapter : RecyclerView.Adapter<CrewAdapter.ViewHolder>() {
    class ViewHolder(castCrewListBinding: CastCrewListBinding)
        :RecyclerView.ViewHolder(castCrewListBinding.root){
        val person = castCrewListBinding.ivPerson
        val name = castCrewListBinding.tvName
        val role = castCrewListBinding.tvRole
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewAdapter.ViewHolder {
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

    val differ = AsyncListDiffer(this@CrewAdapter, differCallback)

    override fun onBindViewHolder(holder: CrewAdapter.ViewHolder, position: Int) {
        val crew = differ.currentList[position]

        holder.role.text = crew.role
        holder.name.text = crew.name
        holder.itemView.apply {
            Glide.with(this)
                .load(crew.image)
                .apply(
                    RequestOptions().placeholder(R.drawable.ic_person)
                )
                .into(holder.person)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size
}