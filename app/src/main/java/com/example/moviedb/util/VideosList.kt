package com.example.moviedb.util

import com.example.moviedb.model.Videos

object VideosList {

    fun getVideos() : List<Videos> {

        val videos = mutableListOf<Videos>()

        val v1 = Videos(
            1,
            "https://i.ytimg.com/vi/gtTfd6tISfw/maxresdefault.jpg",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DgtTfd6tISfw&psig=AOvVaw2SICqCIrX2F50IWpfduNRf&ust=1677581560905000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCICHg7rEtf0CFQAAAAAdAAAAABAh"
        )
        videos.add(v1)

        val v2 = Videos(
            2,
            "https://i.ytimg.com/vi/Xithigfg7dA/maxresdefault.jpg",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DXithigfg7dA&psig=AOvVaw2SICqCIrX2F50IWpfduNRf&ust=1677581560905000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCICHg7rEtf0CFQAAAAAdAAAAABAo"
        )
        videos.add(v2)

        val v3 = Videos(
            3,
            "https://i.ytimg.com/vi/ByUB4d5OA0o/maxresdefault.jpg",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DByUB4d5OA0o&psig=AOvVaw2SICqCIrX2F50IWpfduNRf&ust=1677581560905000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCICHg7rEtf0CFQAAAAAdAAAAABAw"
        )
        videos.add(v3)

        val v4 = Videos(
            4,
            "https://i.ytimg.com/vi/rnzVhQXX2x8/maxresdefault.jpg",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DrnzVhQXX2x8&psig=AOvVaw2SICqCIrX2F50IWpfduNRf&ust=1677581560905000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCICHg7rEtf0CFQAAAAAdAAAAABA4"
        )
        videos.add(v4)

        val v5 = Videos(
            5,
            "https://i.ytimg.com/vi/ONHBaC-pfsk/maxresdefault.jpg",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DONHBaC-pfsk&psig=AOvVaw1WvoJg-vWHoQqHQhNwCwx4&ust=1677582185500000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCODQzePGtf0CFQAAAAAdAAAAABAE"
        )
        videos.add(v5)

        return videos
    }
}