package com.example.androidpractice.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.androidpractice.ui.NavThreeScreen
import kotlinx.serialization.Serializable

@Serializable
data object NavThreeRoute

fun NavGraphBuilder.navThreeScreen() {
    composable<NavThreeRoute> {
        NavThreeScreen()
    }
}