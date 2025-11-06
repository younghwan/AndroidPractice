package com.example.androidpractice.ui.todo

import com.example.androidpractice.ui.UiIntent

sealed class TodoIntent : UiIntent {
    data class AddTodo(val title: String, val content: String) : TodoIntent()
    data class RemoveTodo(val id: String, val title: String, val content: String) : TodoIntent()
}