package com.example.mortyandsmith.screens.characters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mortyandsmith.components.composables.Text12sp
import com.example.mortyandsmith.components.composables.Text14sp
import com.example.mortyandsmith.domain.models.Result
import org.koin.androidx.compose.koinViewModel
import com.example.mortyandsmith.R

@Composable
fun CharacterScreen(modifier: Modifier = Modifier) {
    val viewModel: CharactersViewModel = koinViewModel()
    val screenState = viewModel.state.collectAsState()
    Scaffold(
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                items(screenState.value.list) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        ItemSection(
                            model = it
                        )
                    }
                }
            }
        }
    )
}


@Composable
private fun ItemSection(
    modifier: Modifier = Modifier,
    model: Result
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        AsyncImage(
            modifier = modifier
                .width(150.dp)
                .fillMaxHeight(),
            model = model.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = modifier
                .weight(1f)
                .padding(horizontal = 4.dp)
        ) {
            Text14sp(
                value = "Name: ${model.name}",
                fontWeight = FontWeight.W700
            )
            Text12sp(
                value = "Gender: ${model.gender}",
                fontWeight = FontWeight.W400
            )
            Text12sp(
                "Location: ${model.location.name}",
                fontWeight = FontWeight.W400
            )
        }
    }
}