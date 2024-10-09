package com.example.mortyandsmith.domain.models

import android.annotation.SuppressLint
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class SingleCharacterModel(
    var name: String,
    var gender: String,
)
