package com.example.mortyandsmith.screens.episode

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.mortyandsmith.components.composables.Text14sp
import com.example.mortyandsmith.screens.characters.CharactersViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object EpisodeScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EpisodeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(
        content = { innerPadding ->
            Box(modifier = modifier.fillMaxSize()) {
                Text14sp(value = "Episode Screen")
            }
        }
    )
}
