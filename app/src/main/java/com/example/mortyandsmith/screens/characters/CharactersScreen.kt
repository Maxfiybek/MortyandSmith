package com.example.mortyandsmith.screens.characters

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.mortyandsmith.components.composables.MortyAndSmithAppBar
import com.example.mortyandsmith.navigation.Screens
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val context = LocalContext.current
    val viewModel: CharactersViewModel = koinViewModel()
    val screenState = viewModel.state.collectAsState()
    val events = viewModel.events.collectAsState(CharactersEvent.Loading)
    when (events.value) {
        is CharactersEvent.Error -> {
            viewModel.changeLoadingState(false)
        }

        CharactersEvent.Loading -> {
            viewModel.changeLoadingState(true)
        }

        CharactersEvent.Success -> {
            viewModel.changeLoadingState(false)
            Toast.makeText(context, "::: -> Event Success", Toast.LENGTH_SHORT).show()
        }
    }
    Scaffold(
        topBar = {
            MortyAndSmithAppBar(
                title = "Characters",
                hasNavigationIcon = true
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screens.EpisodeScreen)
                }
            ) {
                Text("next page")
            }
        },
        content = { innerPadding ->
            CharactersContent(
                modifier = modifier.padding(innerPadding),
                items = screenState.value.list
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (screenState.value.isLoadingData) {
                    CircularProgressIndicator()
                }
            }
        }
    )
}


