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
        checkManifestForPermissions(this)
        setContent {
            MortyAndSmithTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MortyAndSmithNavigation()
                }
            }
        }
    }


    fun checkManifestForPermissions(context: Context) {
        val requiredPermissions = arrayOf(
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE
            // Add other required permissions here
        )

        val missingPermissions = mutableListOf<String>()
        for (permission in requiredPermissions) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                missingPermissions.add(permission)
            }
        }

        if (missingPermissions.isNotEmpty()) {
            // Handle missing permissions, e.g., request them from the user
            Log.e("ManifestCheck", "Missing permissions: ${missingPermissions.joinToString()}")
        } else {
            Log.d("ManifestCheck", "All required permissions are granted")
        }
    }
}
