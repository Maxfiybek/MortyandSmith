package com.example.mortyandsmith.di

import com.example.mortyandsmith.data.Repository
import com.example.mortyandsmith.data.RepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::RepositoryImpl) bind Repository::class
}