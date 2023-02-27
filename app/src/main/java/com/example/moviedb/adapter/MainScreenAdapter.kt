package com.example.moviedb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.databinding.MovieInfoBinding
import com.example.moviedb.databinding.MovieSimilarBinding
import com.example.moviedb.databinding.MovieVideosBinding
import com.example.moviedb.util.UImodel

class MainScreenAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var collapsed = true

    class MovieVideosViewHolder(movieVideosBinding: MovieVideosBinding) :
        RecyclerView.ViewHolder(movieVideosBinding.root) {
        val rcVideos = movieVideosBinding.rcVideos
    }

    class MovieInfoViewHolder(movieInfoBinding: MovieInfoBinding):
        RecyclerView.ViewHolder(movieInfoBinding.root) {
        val title = movieInfoBinding.tvTitle
        val info = movieInfoBinding.tvInfo
        val date = movieInfoBinding.tvDate
        val readCollapse = movieInfoBinding.tvReadCollapse
        val llCastCrew = movieInfoBinding.llCastCrew
        val rcCast = movieInfoBinding.rcCast
        val rcCrew = movieInfoBinding.rcCrew
        val chip2 = movieInfoBinding.chip2
        val chip3 = movieInfoBinding.chip3
        val chip4 = movieInfoBinding.chip4
    }

    class MovieSimilarViewHolder(movieSimilarBinding: MovieSimilarBinding):
        RecyclerView.ViewHolder(movieSimilarBinding.root) {
        val rcSimilarMovies = movieSimilarBinding.rcSimilarMovies
    }

    override fun getItemViewType(position: Int): Int {
        return when(differ.currentList[position]){
            is UImodel.InformationModel -> R.layout.movie_info
            is UImodel.VideoModel -> R.layout.movie_videos
            is UImodel.SimilarModel -> R.layout.movie_similar
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        return when(viewType){
            R.layout.movie_videos -> {
                val view = MovieVideosBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                MovieVideosViewHolder(view)
            }
            R.layout.movie_info -> {
                val view = MovieInfoBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                MovieInfoViewHolder(view)
            }
            R.layout.movie_similar -> {
                val view = MovieSimilarBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                MovieSimilarViewHolder(view)
            }
            else -> throw IllegalStateException("Unknown view type")
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<UImodel>() {
        override fun areItemsTheSame(oldItem: UImodel, newItem: UImodel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UImodel, newItem: UImodel): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this@MainScreenAdapter, differCallback)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(val movie = differ.currentList[position]){
            is UImodel.InformationModel -> {
                (holder as MovieInfoViewHolder).apply {
                    title.text = movie.title
                    info.text = movie.info
                    date.text = movie.date
                    chip2.text = movie.filters[0]
                    chip3.text = movie.filters[1]
                    chip4.text = movie.filters[2]
                    readCollapse.setOnClickListener {
                        if (collapsed) {
                            readCollapse.text = readCollapse.context.getString(R.string.read_less)
                            llCastCrew.visibility = View.VISIBLE
                            collapsed = false
                        } else {
                            readCollapse.text = readCollapse.context.getString(R.string.read_more)
                            llCastCrew.visibility = View.GONE
                            collapsed = true
                        }
                    }

                    rcCast.apply {
                        val castAdapter = CastAdapter()
                        castAdapter.differ.submitList(movie.cast)
                        adapter = castAdapter
                        layoutManager = LinearLayoutManager(
                            rcCast.context, LinearLayoutManager.HORIZONTAL, false
                        )
                    }

                    rcCrew.apply {
                        val crewAdapter = CrewAdapter()
                        crewAdapter.differ.submitList(movie.crew)
                        adapter = crewAdapter
                        layoutManager = LinearLayoutManager(
                            rcCrew.context, LinearLayoutManager.HORIZONTAL, false
                        )
                    }
                }
            }

            is UImodel.VideoModel -> {
                (holder as MovieVideosViewHolder).apply{
                    rcVideos.apply {
                        val videoAdapter = VideosAdapter()
                        videoAdapter.differ.submitList(movie.videos)
                        adapter = videoAdapter
                        layoutManager = LinearLayoutManager(
                            rcVideos.context, LinearLayoutManager.HORIZONTAL, false
                        )
                    }
                }
            }

            is UImodel.SimilarModel -> {
                (holder as MovieSimilarViewHolder).apply{
                    rcSimilarMovies.apply {
                        val similarAdapter = SimilarAdapter()
                        similarAdapter.differ.submitList(movie.similarMovies)
                        adapter = similarAdapter
                        layoutManager = LinearLayoutManager(
                            rcSimilarMovies.context, LinearLayoutManager.HORIZONTAL, false
                        )
                    }
                }
            }
        }

    }

    override fun getItemCount(): Int = differ.currentList.size
}