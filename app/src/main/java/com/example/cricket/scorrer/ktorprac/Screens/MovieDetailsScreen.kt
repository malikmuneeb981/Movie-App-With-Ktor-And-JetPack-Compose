package com.example.cricket.scorrer.ktorprac.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.cricket.scorrer.ktorprac.ApiService.ApiServiceIml
import com.example.cricket.scorrer.ktorprac.ApiService.Baseresponse
import com.example.cricket.scorrer.ktorprac.ApiService.ViewModel
import com.example.cricket.scorrer.ktorprac.Composables.AppText
import com.example.cricket.scorrer.ktorprac.Composables.AppTopBar
import com.example.cricket.scorrer.ktorprac.Composables.MovieDetailitem
import io.ktor.client.HttpClient

@Composable
fun MovieDetailsScreen(navController: NavController,viewModel: ViewModel) {


    viewModel.selectedmovie?.let { viewModel.getMovieDetails(title = it.Title) }

    val searchedmovieresult = viewModel.SelectedMovieResponse.collectAsState()
    

    Scaffold(topBar = {
        AppTopBar(text = viewModel.selectedmovie!!.Title){

            navController.popBackStack()
        }
    }, modifier = Modifier.statusBarsPadding().navigationBarsPadding(), containerColor = Color.White,content = {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .padding(15.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            when(searchedmovieresult.value){
                is Baseresponse.Error -> {


                }
                is Baseresponse.Loading -> {

                    CircularProgressIndicator()
                }
                is Baseresponse.Success -> {

                    val success = searchedmovieresult.value.data
                    success?.let {


                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)) {

                        AsyncImage(model = it.Poster,
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .height(230.dp)
                                .weight(1f))

                        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(10.dp)) {

                            AppText(text = "Name : ${it.Title}", fontWeight = FontWeight.Bold, textAlign = TextAlign.Start,modifier = Modifier.fillMaxWidth())

                            AppText(text = "Type : ${it.Type}", fontWeight = FontWeight.Bold, textAlign = TextAlign.Start,modifier = Modifier.fillMaxWidth())

                            if (it.Type == "series"){
                                AppText(text = "Total Seasons : ${it.totalSeasons}", fontWeight = FontWeight.Bold, textAlign = TextAlign.Start,modifier = Modifier.fillMaxWidth())

                            }

                            AppText(text = "Rated : ${it.Rated}", fontWeight = FontWeight.Medium, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())

                            AppText(text = "Released : ${it.Released}", fontWeight = FontWeight.Medium, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())

                            AppText(text = "Genre : ${it.Genre}", fontWeight = FontWeight.Medium, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
                        }



                    }
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)) {

                        MovieDetailitem("Plot:",
                            it.Plot)

                        MovieDetailitem( "IMDB Rating:",it.Rated)

                        MovieDetailitem( "Language",it.Language)

                        MovieDetailitem( "IMDB Rating:",it.imdbRating)

                        MovieDetailitem("Runtime",it.Runtime)



                    }

                }
                }
            }





        }
    })

}

@Preview
@Composable
private fun MovieDetialsScreenPrev() {
    MovieDetailsScreen(rememberNavController(), ViewModel(ApiServiceIml(client = HttpClient())))
}