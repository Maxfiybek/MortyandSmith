package com.example.mortyandsmith.di

import com.example.mortyandsmith.screens.characters.CharactersViewModel
import com.example.mortyandsmith.screens.episode.EpisodeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewModelModule = module {
    singleOf(::CharactersViewModel)
    singleOf(::EpisodeViewModel)
}