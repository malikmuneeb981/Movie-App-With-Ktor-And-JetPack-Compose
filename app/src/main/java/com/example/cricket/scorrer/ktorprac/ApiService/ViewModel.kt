package com.example.cricket.scorrer.ktorprac.ApiService

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cricket.scorrer.ktorprac.models.MovieSearchResponse
import com.example.cricket.scorrer.ktorprac.models.PostsResponse
import com.example.cricket.scorrer.ktorprac.models.Search
import com.example.cricket.scorrer.ktorprac.models.SelectedMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch




class ViewModel (val apiService: ApiService):ViewModel() {

    private val _MovieSeachResponse = MutableStateFlow<Baseresponse<MovieSearchResponse>>(Baseresponse.Loading())
    val MovieSeachResponse:StateFlow<Baseresponse<MovieSearchResponse>>  = _MovieSeachResponse

    private val _SelectedMovieResponse = MutableStateFlow<Baseresponse<SelectedMovieResponse>>(Baseresponse.Loading())
    val SelectedMovieResponse:StateFlow<Baseresponse<SelectedMovieResponse>>  = _SelectedMovieResponse


    var selectedmovie:Search ?=null
    fun SearchMovie(query:String){

        viewModelScope.launch {
           val result =  apiService.getSearchedMovies(query)
            if (result!=null){
                _MovieSeachResponse.emit(Baseresponse.Success(result))
            }
            else
            {
                _MovieSeachResponse.emit(Baseresponse.Error("Something Went Wrong"))
            }
        }

    }

    fun getMovieDetails(title:String){
        viewModelScope.launch(Dispatchers.IO) {
            val result =  apiService.getSelectedMovieDetails(title)
            if (result!=null){
                _SelectedMovieResponse.emit(Baseresponse.Success(result))
            }
            else
            {
                _SelectedMovieResponse.emit(Baseresponse.Error("Something Went Wrong"))
            }
        }
    }

//
//    fun getPosts(){
//        viewModelScope.launch(Dispatchers.IO) {
//            val result = apiService.getPosts()
//            if (result.isNotEmpty()){
//                _response.emit(Baseresponse.Success(result))
//            }
//            else
//            {
//                _response.emit(Baseresponse.Error("SomeThing Went Wrong..."))
//            }
//
//        }
//
//    }

}