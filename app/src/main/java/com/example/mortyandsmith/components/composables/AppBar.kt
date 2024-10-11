package com.example.mortyandsmith.components.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MortyAndSmithAppBar(
    title: String = "",
    hasNavigationIcon: Boolean = true,
    onNavigationIconClick: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text12sp(value = title, color = Color.White)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue
        ),
        navigationIcon = {
            if (hasNavigationIcon) {
                IconButton(
                    onClick = onNavigationIconClick
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    )
}