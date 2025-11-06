package com.example.androidpractice.ui.todo

import com.example.androidpractice.model.Todo
import com.example.androidpractice.ui.BaseViewModel

class TodoViewModel : BaseViewModel<TodoIntent, TodoState, TodoSideEffect>(TodoState()) {

    private fun addTodo(title: String, content: String) {
        val newTodo = Todo(title = title, content = content)
        intent {
            copy(todos = todos + newTodo)
        }
    }

    private fun removeTodo(id: String) {
        intent {
            copy(todos = todos.filterNot { it.id == id })
        }
    }

    override fun onIntent(intent: TodoIntent) {
        when (intent) {
            is TodoIntent.AddTodo -> addTodo(intent.title, intent.content)
            is TodoIntent.RemoveTodo -> removeTodo(intent.id)
        }
    }

}
