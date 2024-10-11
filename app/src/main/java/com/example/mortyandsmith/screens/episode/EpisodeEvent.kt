package com.example.mortyandsmith.screens.episode

sealed class EpisodeEvent {
    data object Loading : EpisodeEvent()
    data object Success : EpisodeEvent()
    data class Error(val message: String) : EpisodeEvent()
}