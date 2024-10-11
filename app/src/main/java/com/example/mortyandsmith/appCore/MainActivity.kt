package com.example.mortyandsmith.appCore

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import com.example.mortyandsmith.components.theme.MortyAndSmithTheme
import com.example.mortyandsmith.navigation.MortyAndSmithNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MortyAndSmithTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MortyAndSmithNavigation()
                }
            }
        }
    }
}
