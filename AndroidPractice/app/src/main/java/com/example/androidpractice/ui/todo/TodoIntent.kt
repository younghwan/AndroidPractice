package com.example.androidpractice.ui.todo

import com.example.androidpractice.model.Todo
import com.example.androidpractice.ui.UiIntent

sealed class TodoIntent : UiIntent {
    data class AddTodo(val title: String, val content: String) : TodoIntent()
    data class RemoveTodo(val todo: Todo, val title: String, val content: String) : TodoIntent()
}