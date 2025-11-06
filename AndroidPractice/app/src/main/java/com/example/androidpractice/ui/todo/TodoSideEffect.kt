package com.example.androidpractice.ui.todo

import com.example.androidpractice.ui.SideEffect

sealed class TodoSideEffect : SideEffect {
    data class ShowToast(val message: String) : TodoSideEffect()
}