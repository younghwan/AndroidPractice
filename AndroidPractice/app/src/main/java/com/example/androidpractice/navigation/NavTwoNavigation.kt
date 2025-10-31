package com.example.androidpractice.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.androidpractice.ui.NavTwoScreen
import kotlinx.serialization.Serializable

@Serializable
data object NavTwoRoute

fun NavGraphBuilder.navTwoScreen() {
    composable<NavTwoRoute> {
        NavTwoScreen()
    }
}