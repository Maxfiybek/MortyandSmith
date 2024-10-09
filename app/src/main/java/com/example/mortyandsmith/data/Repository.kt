package com.example.mortyandsmith.data

import com.example.mortyandsmith.domain.models.CharacterInfoModel
import com.example.mortyandsmith.domain.models.SingleCharacterModel

interface Repository {
    suspend fun getCharacters(): CharacterInfoModel
    suspend fun getSingleCharacter(id: Int): SingleCharacterModel
}