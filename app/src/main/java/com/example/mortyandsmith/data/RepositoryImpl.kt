package com.example.mortyandsmith.data

import com.example.mortyandsmith.domain.models.CharacterInfoModel
import com.example.mortyandsmith.domain.models.EpisodeModel
import com.example.mortyandsmith.domain.models.MultipleCharacterModel
import com.example.mortyandsmith.domain.models.SingleCharacterModel
import com.example.mortyandsmith.utils.API
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class RepositoryImpl(
    val client: HttpClient
) : Repository {
    override suspend fun getCharacters(): CharacterInfoModel {
        return client.get(API.ALL_CHARACTERS).body()
    }

    override suspend fun getSingleCharacter(id: Int): SingleCharacterModel {
        return client.get(API.ALL_CHARACTERS + "$id").body()
    }

    override suspend fun getAllEpisodes(): EpisodeModel {
        return client.get(API.ALL_EPISODES).body()
    }

    override suspend fun getMultipleCharacters(url: String): SingleCharacterModel {
        return client.get(url).body()
    }
}