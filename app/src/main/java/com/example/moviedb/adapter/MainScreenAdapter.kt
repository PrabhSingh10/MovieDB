package com.example.moviedb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.databinding.MainScreenBinding
import com.example.moviedb.model.InformationModel

class MainScreenAdapter(
    private val addThumbnail: (image : String) -> Unit
) : RecyclerView.Adapter<MainScreenAdapter.MainViewHolder>() {

    private var collapsed = true

    class MainViewHolder(mainScreenBinding: MainScreenBinding) :
        RecyclerView.ViewHolder(mainScreenBinding.root) {
        val rcVideos = mainScreenBinding.rcVideos
        val title = mainScreenBinding.tvTitle
        val info = mainScreenBinding.tvInfo
        val date = mainScreenBinding.tvDate
        val readCollapse = mainScreenBinding.tvReadCollapse
        val llCastCrew = mainScreenBinding.llCastCrew
        val rcCast = mainScreenBinding.rcCast
        val rcCrew = mainScreenBinding.rcCrew
        val rcSimilarMovies = mainScreenBinding.rcSimilarMovies
        val chip2 = mainScreenBinding.chip2
        val chip3 = mainScreenBinding.chip3
        val chip4 = mainScreenBinding.chip4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MainScreenAdapter.MainViewHolder {
        val view = MainScreenBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainViewHolder(view)
    }

    private val differCallback = object : DiffUtil.ItemCallback<InformationModel>() {
        override fun areItemsTheSame(
            oldItem: InformationModel,
            newItem: InformationModel
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: InformationModel,
            newItem: InformationModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this@MainScreenAdapter, differCallback)

    override fun onBindViewHolder(holder: MainScreenAdapter.MainViewHolder, position: Int) {

        val movie = differ.currentList[position]

        addThumbnail(movie.thumbnail)
        holder.title.text = movie.title
        holder.info.text = movie.info
        holder.date.text = movie.date
        holder.chip2.text = movie.filters[0]
        holder.chip3.text = movie.filters[1]
        holder.chip4.text = movie.filters[2]

        holder.rcVideos.apply {
            val videoAdapter = VideosAdapter()
            videoAdapter.differ.submitList(movie.videos)
            adapter = videoAdapter
            layoutManager = LinearLayoutManager(
                holder.rcVideos.context, LinearLayoutManager.HORIZONTAL, false
            )
        }

        holder.rcSimilarMovies.apply {
            val similarAdapter = SimilarAdapter()
            similarAdapter.differ.submitList(movie.similarMovies)
            adapter = similarAdapter
            layoutManager = LinearLayoutManager(
                holder.rcSimilarMovies.context, LinearLayoutManager.HORIZONTAL, false
            )
        }

        holder.readCollapse.setOnClickListener {
            if(collapsed){
                holder.readCollapse.text = holder.readCollapse.context.getString(R.string.read_less)
                holder.llCastCrew.visibility = View.VISIBLE
                collapsed = false
            }else {
                holder.readCollapse.text = holder.readCollapse.context.getString(R.string.read_more)
                holder.llCastCrew.visibility = View.GONE
                collapsed = true
            }
        }

        holder.rcCast.apply {
            val castAdapter = CastAdapter()
            castAdapter.differ.submitList(movie.cast)
            adapter = castAdapter
            layoutManager = LinearLayoutManager(
                holder.rcCast.context, LinearLayoutManager.HORIZONTAL, false
            )
        }

        holder.rcCrew.apply {
            val crewAdapter = CrewAdapter()
            crewAdapter.differ.submitList(movie.crew)
            adapter = crewAdapter
            layoutManager = LinearLayoutManager(
                holder.rcCrew.context, LinearLayoutManager.HORIZONTAL, false
            )
        }

    }

    override fun getItemCount(): Int = differ.currentList.size
}