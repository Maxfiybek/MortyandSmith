package com.example.mortyandsmith.screens.characters

sealed class CharactersEvent {
    object Loading : CharactersEvent()
    object Success : CharactersEvent()
    data class Error(val message: String) : CharactersEvent()
}