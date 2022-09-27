package com.example.moviesreview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesreview.databinding.ActivityMoviesHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoviesHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMoviesHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}