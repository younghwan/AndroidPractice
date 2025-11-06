package com.example.androidpractice.ui.todo

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object NavOneRoute

fun NavGraphBuilder.navTodoScreen() {
    composable<NavOneRoute> {
        TodoScreen()
    }
}