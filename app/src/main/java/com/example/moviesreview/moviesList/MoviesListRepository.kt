package com.example.moviesreview.moviesList

import com.example.moviesreview.BuildConfig
import com.example.moviesreview.data.MoviesList
import com.example.moviesreview.network.MoviesApiService
import kotlinx.coroutines.flow.Flow

class MoviesListRepository(private val moviesApiService: MoviesApiService) {

    suspend fun getMoviesList(): Flow<MoviesList> =
        moviesApiService.getMoviesList(BuildConfig.API_KEY)

}