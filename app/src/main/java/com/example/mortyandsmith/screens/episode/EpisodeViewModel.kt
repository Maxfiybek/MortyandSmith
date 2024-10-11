package com.example.mortyandsmith.screens.episode

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.mortyandsmith.common.BaseViewModel
import com.example.mortyandsmith.data.Repository
import com.example.mortyandsmith.domain.models.SingleCharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EpisodeViewModel(
    private val repository: Repository
) : BaseViewModel<EpisodeState, EpisodeEvent>(EpisodeState()) {

    fun getALlEpisodes() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val episodes = repository.getAllEpisodes()
                println("Episodes::: -> $episodes")
            } catch (e: Exception) {
                println("Error ${e.message.toString()}")
            }
        }
    }

}