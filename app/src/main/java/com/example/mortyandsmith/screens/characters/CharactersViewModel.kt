package com.example.mortyandsmith.screens.characters

import androidx.lifecycle.viewModelScope
import com.example.mortyandsmith.common.BaseViewModel
import com.example.mortyandsmith.data.Repository
import com.example.mortyandsmith.domain.models.Result
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharactersViewModel(
    val repository: Repository
) : BaseViewModel<CharactersScreenState, Unit>(CharactersScreenState()) {

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        viewModelScope.launch {
            mutableState.update { it.copy(list = repository.getCharacters().results) }
        }
    }
}

data class CharactersScreenState(
    val list: List<Result> = emptyList()
)