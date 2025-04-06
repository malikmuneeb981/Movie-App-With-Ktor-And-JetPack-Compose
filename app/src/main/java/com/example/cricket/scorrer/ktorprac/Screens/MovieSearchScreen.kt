package com.example.cricket.scorrer.ktorprac.Screens

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cricket.scorrer.ktorprac.ApiService.ApiService
import com.example.cricket.scorrer.ktorprac.ApiService.Baseresponse
import com.example.cricket.scorrer.ktorprac.ApiService.ViewModel
import com.example.cricket.scorrer.ktorprac.Composables.AppText
import com.example.cricket.scorrer.ktorprac.Composables.AppTopBar
import com.example.cricket.scorrer.ktorprac.Composables.MovieSearchItem
import com.example.cricket.scorrer.ktorprac.Dialogs.ExitBottomDialog
import com.example.cricket.scorrer.ktorprac.NavGraph.Navigation_Routes
import io.ktor.client.HttpClient

@Composable
fun MovieSearchScreen(navController: NavController,viewModel: ViewModel) {


    var searchedText by remember { mutableStateOf("") }
    val activity = LocalActivity.current as Activity
    var exitdialog by remember { mutableStateOf(false) }

    val searchMovieResponse = viewModel.MovieSeachResponse.collectAsState()
    if (exitdialog){
        ExitBottomDialog(ondismiss = {

            exitdialog = false
        }, onExit = {

            activity.finishAndRemoveTask()
        })
    }
    BackHandler {

        exitdialog = true

    }
    Scaffold(topBar = { AppTopBar(backarrow = false, text = "Movie App") },
        modifier = Modifier.navigationBarsPadding().statusBarsPadding(), containerColor = Color.White,
        content = {

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it).padding(15.dp)) {

            Box(modifier = Modifier.fillMaxWidth().background(Color(0xFF0085FF).copy(
                alpha = 0.10f
            ), shape =
            RoundedCornerShape(30.dp)
            ).border(width = 1.dp, color = Color(0xFF0085FF), shape = RoundedCornerShape(30.dp))) {

                TextField(modifier = Modifier.fillMaxWidth(), onValueChange = {
                    searchedText = it
                    viewModel.SearchMovie(it)
                }, value = searchedText, colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,

                ), placeholder = {
                    AppText(text = "Search...")
                })
            }

            Box(modifier = Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {

                LazyColumn(modifier = Modifier.matchParentSize(), verticalArrangement =
                Arrangement.spacedBy(10.dp), contentPadding = PaddingValues(
                    vertical = 10.dp
                )
                ) {

                    searchMovieResponse.value.data?.let { it1 ->
                        items(it1.Search){

                            MovieSearchItem(it){
                                viewModel.selectedmovie = it
                                navController.navigate(Navigation_Routes.MovieDetailsScreen)
                            }
                        }
                    }


                }
                when(searchMovieResponse.value){
                    is Baseresponse.Error -> {

                    }
                    is Baseresponse.Loading -> {

                        if (searchedText.isNotEmpty()){
                            CircularProgressIndicator()
                        }

                    }
                    is Baseresponse.Success -> {
                        val success = searchMovieResponse.value.data

                    }
                }
            }







        }



    })




}

@Preview
@Composable
private fun MovieSearchScreenPrev() {

    MovieSearchScreen(rememberNavController(), ViewModel(ApiService(client = HttpClient())))
}