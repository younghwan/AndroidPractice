package com.example.androidpractice.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.androidpractice.model.NavAppState
import com.example.androidpractice.ui.todo.navTodoScreen

@Composable
fun MainNavHost(
    appState: NavAppState,
    modifier: Modifier
) {
    // NavController : 화면 간 이동을 관리
    val navController = appState.navController

    // NavHost : 현재 보여질 화면을 렌더링하는 컨테이너
    NavHost(
        startDestination = HomeRoute,
        navController = navController,
        modifier = modifier
    ) {
        // NavGraphBuilder : NavHost 안에서 이동 가능한 화면 그래프를 정의하는 빌더(DSL)
        homeScreen(navController)
        navTodoScreen()
        navTwoScreen()
        navThreeScreen()
    }

}
