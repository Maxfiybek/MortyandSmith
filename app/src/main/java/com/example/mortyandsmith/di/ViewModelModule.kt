package com.example.mortyandsmith.di

import com.example.mortyandsmith.screens.characters.CharactersViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewModelModule = module {
    singleOf(::CharactersViewModel)
}