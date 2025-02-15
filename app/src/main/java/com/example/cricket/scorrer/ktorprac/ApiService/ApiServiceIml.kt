package com.example.cricket.scorrer.ktorprac.ApiService

import com.example.cricket.scorrer.ktorprac.models.MovieSearchResponse
import com.example.cricket.scorrer.ktorprac.models.PostsResponse
import com.example.cricket.scorrer.ktorprac.models.SelectedMovieResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import javax.inject.Inject

class ApiServiceIml @Inject constructor(val client:HttpClient):ApiService {

//    override suspend fun getPosts(): List<PostsResponse> {
//       return try {
//           client.get{
//               url("https://jsonplaceholder.typicode.com/posts")
//           }
//
//
//
//
//       } catch (e:Exception){
//
//          emptyList()
//       }
//    }
    val BaseUrl = "https://www.omdbapi.com/"
    val ApiKey = "f514b556"

    override suspend fun getSearchedMovies(query:String): MovieSearchResponse? {
       return try {
           client.get {
               url(BaseUrl)
               parameter("s",query)
               parameter("apikey",ApiKey)
           }.body()
       } catch (e:Exception){
           return null
       }
    }

    override suspend fun getSelectedMovieDetails(title: String): SelectedMovieResponse? {
        return try {
            client.get{
                url(BaseUrl)
                parameter("t",title)
                parameter("apikey",ApiKey)
            }.body()
        }catch (e:Exception){
            return null
        }
    }
}