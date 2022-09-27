package com.example.moviesreview.moviesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesreview.data.MovieItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(repository: MoviesListRepository)
    : ViewModel() {

    private val _moviesList : MutableStateFlow<Response> = MutableStateFlow(Response.Success(arrayListOf()))
    val moviesList : StateFlow<Response> = _moviesList

    init {
        viewModelScope.launch {
            try{
                repository.getMoviesList()
                    .collect {
                        _moviesList.value = Response.Success(it.movies)
                    }
            } catch (exception: Exception) {
                _moviesList.value = Response.Error(exception)
            }
        }
    }
}

sealed class Response {
    data class Success(val movies: ArrayList<MovieItem>): Response()
    data class Error(val exception: Exception): Response()
}