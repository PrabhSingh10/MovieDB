package com.example.moviedb.util

import com.example.moviedb.model.CastCrew
import com.example.moviedb.model.SimilarMovies
import com.example.moviedb.model.Videos
import com.example.moviedb.util.CastList.getCast
import com.example.moviedb.util.CrewList.getCrew
import com.example.moviedb.util.SimilarMoviesList.getSimilarMovies
import com.example.moviedb.util.VideosList.getVideos

sealed class UImodel{

    class VideoModel(
        val videos : List<Videos>
    ): UImodel()

    class InformationModel(
        val title : String,
        val info : String,
        val date : String,
        val cast : List<CastCrew>,
        val crew : List<CastCrew>,
        val filters : List<String>
    ): UImodel()

    class SimilarModel(
        val similarMovies : List<SimilarMovies>
    ): UImodel()
}
object Constant {

    fun getMovieInfo() : List<UImodel> {

        return listOf(
            UImodel.VideoModel(
                getVideos()
            ),
            UImodel.InformationModel(
                "DEADPOOL",
                "Ajax, a twisted scientist, experiments on Wade Wilson, a mercenary, to cure him of cancer and give him healing powers. However, the experiment leaves Wade disfigured and he decides to exact revenge.",
                "Feb, 12 2016",
                getCast(),
                getCrew(),
                listOf("ACTION", "COMEDY", "SCIENCE FICTION")
            ),
            UImodel.SimilarModel(
                getSimilarMovies()
            )
        )
    }
}