package com.example.moviesreview.network

import com.example.moviesreview.data.MoviesList
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {
    @GET("3/movie/popular")
    suspend fun getMoviesList(@Query("api_key") apiKey: String): Flow<MoviesList>
}