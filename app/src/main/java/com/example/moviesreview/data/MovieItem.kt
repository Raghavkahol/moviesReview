package com.example.moviesreview.data

import com.google.gson.annotations.SerializedName


data class MovieItem (
  @SerializedName("poster_path") var posterPath : String? = null,
  @SerializedName("adult") var adult : Boolean? = null,
  @SerializedName("overview") var overview : String? = null,
  @SerializedName("release_date") var releaseDate : String? = null,
  @SerializedName("id") var id : Int? = null,
  @SerializedName("title") var title : String? = null,
  @SerializedName("backdrop_path") var backdropPath : String? = null,
  @SerializedName("popularity") var popularity : Double? = null,
  @SerializedName("vote_count") var voteCount : Int? = null,
  @SerializedName("vote_average") var voteAverage : Double? = null

)