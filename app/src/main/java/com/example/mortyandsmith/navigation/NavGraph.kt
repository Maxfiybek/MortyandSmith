package com.example.mortyandsmith.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mortyandsmith.screens.characters.CharacterScreen
import com.example.mortyandsmith.screens.episode.EpisodeScreen

@Composable
fun MortyAndSmithNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.CharacterScreen){
        composable<Screens.CharacterScreen>{
            CharacterScreen(navController = navController)
        }
        composable<Screens.EpisodeScreen>{
            EpisodeScreen(navController = navController)
        }
    }
}