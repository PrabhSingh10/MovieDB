package com.example.moviedb.util

import com.example.moviedb.model.SimilarMovies

object SimilarMoviesList {

    fun getSimilarMovies() : MutableList<SimilarMovies> {

        val similarMovies = mutableListOf<SimilarMovies>()

        val sm1 = SimilarMovies(
            1,
            "https://m.media-amazon.com/images/M/MV5BMDkzNmRhNTMtZDI4NC00Zjg1LTgxM2QtMjYxZDQ3OWJlMDRlXkEyXkFqcGdeQXVyNTU5MjkzMTU@._V1_FMjpg_UX1000_.jpg"
        )
        similarMovies.add(sm1)

        val sm2 = SimilarMovies(
            2,
            "https://cdn.marvel.com/content/1x/logan_lob_crd_02.jpg"
        )
        similarMovies.add(sm2)

        val sm3 = SimilarMovies(
            3,
            "https://upload.wikimedia.org/wikipedia/en/6/6b/Green_Lantern_poster.jpg"
        )
        similarMovies.add(sm3)

        val sm4 = SimilarMovies(
            4,
            "https://flxt.tmsimg.com/assets/p174924_p_v8_ae.jpg"
        )
        similarMovies.add(sm4)

        val sm5 = SimilarMovies(
            5,
            "https://m.media-amazon.com/images/M/MV5BOTY2NzFjODctOWUzMC00MGZhLTlhNjMtM2Y2ODBiNGY1ZWRiXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg"
        )
        similarMovies.add(sm5)

        val sm6 = SimilarMovies(
            6,
            "https://m.media-amazon.com/images/M/MV5BNzg1MDQxMTQ2OF5BMl5BanBnXkFtZTcwMTk3MjAzOQ@@._V1_FMjpg_UX1000_.jpg"
        )
        similarMovies.add(sm6)

        return similarMovies
    }
}