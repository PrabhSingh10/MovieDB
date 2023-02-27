package com.example.moviedb.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.moviedb.adapter.MainScreenAdapter
import com.example.moviedb.databinding.ActivityMainBinding
import com.example.moviedb.model.InformationModel
import com.example.moviedb.util.Constant.getMovieInfo

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainScreenAdapter: MainScreenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        mainScreenAdapter = MainScreenAdapter{thumbnail ->
            Glide.with(this)
                .load(thumbnail)
                .into(mainBinding.ivThumbnail)
        }
        mainScreenAdapter.differ.submitList(getMovieInfo() as List<InformationModel>)
        mainBinding.recyclerView.adapter = mainScreenAdapter
        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}