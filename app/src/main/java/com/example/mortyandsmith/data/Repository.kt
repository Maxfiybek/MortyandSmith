package com.example.mortyandsmith.data

import com.example.mortyandsmith.domain.models.CharacterInfoModel
import com.example.mortyandsmith.domain.models.EpisodeModel
import com.example.mortyandsmith.domain.models.MultipleCharacterModel
import com.example.mortyandsmith.domain.models.SingleCharacterModel

interface Repository {
    suspend fun getCharacters(): CharacterInfoModel
    suspend fun getSingleCharacter(id: Int): SingleCharacterModel
    suspend fun getAllEpisodes(): EpisodeModel
    suspend fun getMultipleCharacters(url: String): SingleCharacterModel
}