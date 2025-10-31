package com.example.androidpractice.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): NavAppState {
    return remember(coroutineScope, navController) {
        NavAppState(coroutineScope = coroutineScope, navController = navController)
    }
}

@Stable
class NavAppState(
    val coroutineScope: CoroutineScope,
    val navController: NavHostController
)