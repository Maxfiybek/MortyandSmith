package com.example.mortyandsmith.screens.episode

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable

@Serializable
object EpisodeScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EpisodeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        content = { innerPadding ->
            EpisodeScreenContent(
                modifier = modifier.padding(innerPadding)
            )
        }
    )
}

@Composable
fun EpisodeScreenContent(
    modifier: Modifier = Modifier
) {
    //some contents here
}