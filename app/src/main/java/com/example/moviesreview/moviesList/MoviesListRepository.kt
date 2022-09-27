package com.example.moviesreview.moviesList

import com.example.moviesreview.BuildConfig
import com.example.moviesreview.base.IoDispatcher
import com.example.moviesreview.data.MoviesList
import com.example.moviesreview.network.MoviesApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MoviesListRepository @Inject constructor(private val moviesApiService: MoviesApiService) {

    suspend fun getMoviesList(): Flow<MoviesList> = flow {
        emit(moviesApiService.getMoviesList(BuildConfig.API_KEY))
    }.flowOn(Dispatchers.IO)

}