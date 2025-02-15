package com.example.cricket.scorrer.ktorprac.NavGraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cricket.scorrer.ktorprac.ApiService.ViewModel
import com.example.cricket.scorrer.ktorprac.Screens.MovieDetailsScreen
import com.example.cricket.scorrer.ktorprac.Screens.MovieSearchScreen

@Composable
fun Nav_Graph(viewModel: ViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Navigation_Routes.MovieSearchScreen) {

        composable(route = Navigation_Routes.MovieSearchScreen){

            MovieSearchScreen(navController,viewModel)


        }
        composable(route = Navigation_Routes.MovieDetailsScreen){
            MovieDetailsScreen(navController,viewModel)
        }

    }

}