package com.example.androidpractice.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.androidpractice.ui.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable<HomeRoute> {
        HomeScreen(navController)
    }
}