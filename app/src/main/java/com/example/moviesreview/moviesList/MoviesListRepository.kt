package com.example.moviesreview.moviesList

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.moviesreview.BuildConfig
import com.example.moviesreview.base.IoDispatcher
import com.example.moviesreview.data.MovieItem
import com.example.moviesreview.data.MoviesList
import com.example.moviesreview.network.MoviesApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MoviesListRepository @Inject constructor(private val moviesApiService: MoviesApiService) {

    fun getMoviesList(): Flow<PagingData<MovieItem>> {
        return Pager(PagingConfig(pageSize = 20, enablePlaceholders = false)) {
            MoviesPagingSource(moviesApiService)
        }.flow
    }

}