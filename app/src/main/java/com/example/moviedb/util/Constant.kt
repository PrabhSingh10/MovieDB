package com.example.moviedb.util

import com.example.moviedb.model.CastCrew
import com.example.moviedb.model.InformationModel
import com.example.moviedb.model.SimilarMovies
import com.example.moviedb.model.Videos
import com.example.moviedb.util.CastList.getCast
import com.example.moviedb.util.CrewList.getCrew
import com.example.moviedb.util.SimilarMoviesList.getSimilarMovies
import com.example.moviedb.util.VideosList.getVideos

object Constant {

    fun getMovieInfo() : MutableList<InformationModel> {

        val movieInfo = mutableListOf<InformationModel>()

        val movie = InformationModel(
            "https://staticc.sportskeeda.com/editor/2022/10/95207-16646197956242-1920.jpg",
            getVideos() as List<Videos>,
            "Deadpool",
            "Ajax, a twisted scientist, experiments on Wade Wilson, a mercenary, to cure him of cancer and give him healing powers. However, the experiment leaves Wade disfigured and he decides to exact revenge.",
            "Feb, 12 2016",
            getCast() as List<CastCrew>,
            getCrew() as List<CastCrew>,
            getSimilarMovies() as List<SimilarMovies>,
            listOf("ACTION", "COMEDY", "SCIENCE FICTION")
        )

        movieInfo.add(movie)
        return movieInfo
    }
}