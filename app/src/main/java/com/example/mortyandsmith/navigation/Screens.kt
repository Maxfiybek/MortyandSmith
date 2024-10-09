package com.example.mortyandsmith.navigation

import kotlinx.serialization.Serializable

sealed interface Screens {
    @Serializable
    data object EpisodeScreen : Screens

    @Serializable
    data object LocationScreen : Screens

    @Serializable
    data object CharacterScreen : Screens
}