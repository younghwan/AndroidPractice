package com.example.androidpractice.ui.todo

import com.example.androidpractice.model.Todo
import com.example.androidpractice.ui.UiState

data class TodoState(
    val todos: List<Todo> = emptyList()
) : UiState