package com.example.moviedb.model

data class InformationModel(
    val thumbnail : String,
    val videos : List<Videos>,
    val title : String,
    val info : String,
    val date : String,
    val cast : List<CastCrew>,
    val crew : List<CastCrew>,
    val similarMovies : List<SimilarMovies>,
    val filters : List<String>
)
