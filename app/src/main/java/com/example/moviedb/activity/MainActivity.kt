package com.example.moviedb.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.moviedb.adapter.MainScreenAdapter
import com.example.moviedb.databinding.ActivityMainBinding
import com.example.moviedb.util.Constant.getMovieInfo
import com.example.moviedb.util.UImodel

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainScreenAdapter: MainScreenAdapter
    private lateinit var list: List<UImodel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        setUpRecyclerView()
        list = getMovieInfo()
        Glide.with(this)
            .load("https://staticc.sportskeeda.com/editor/2022/10/95207-16646197956242-1920.jpg")
            .into(mainBinding.ivThumbnail)
    }

    private fun setUpRecyclerView() {
        mainScreenAdapter = MainScreenAdapter()
        mainScreenAdapter.differ.submitList(getMovieInfo())
        mainBinding.recyclerView.adapter = mainScreenAdapter
        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}