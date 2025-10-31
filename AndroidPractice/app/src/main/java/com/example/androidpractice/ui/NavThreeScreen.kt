package com.example.androidpractice.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun NavThreeScreen() {

    LaunchedEffect(Unit) {
        Log.d("ScreenCheck", "NavThreeScreen visible")
    }

    Scaffold(
        modifier = Modifier
            .background(color = Color.Blue)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Text("NavThreeScreen")
        }
    }
}