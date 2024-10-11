package com.example.mortyandsmith.screens.characters

import androidx.lifecycle.viewModelScope
import com.example.mortyandsmith.common.BaseViewModel
import com.example.mortyandsmith.data.Repository
import com.example.mortyandsmith.domain.models.Result
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val repository: Repository
) : BaseViewModel<CharactersScreenState, CharactersEvent>(CharactersScreenState()) {

    init {
        getAllCharacters()
    }


    private fun getAllCharacters() {
        viewModelScope.launch {
            mutableEvents.send(CharactersEvent.Loading)
            try {
                mutableState.update { it.copy(list = repository.getCharacters().results) }
                mutableEvents.send(CharactersEvent.Success)
            } catch (error: Exception) {
                mutableEvents.send(CharactersEvent.Error(error.message.toString()))
            }
        }
    }

    fun changeLoadingState(value: Boolean) {
        mutableState.update { it.copy(isLoadingData = value) }
    }
}

data class CharactersScreenState(
    val list: List<Result> = emptyList(),
    val isLoadingData: Boolean = true,
    val episode: String = ""
)