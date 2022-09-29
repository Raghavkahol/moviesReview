package com.example.moviesreview.moviesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.moviesreview.data.MovieItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(private val repository: MoviesListRepository)
    : ViewModel() {

    fun fetchPosts() : Flow<PagingData<MovieItem>> {
        return repository.getMoviesList().cachedIn(viewModelScope)
    }
}