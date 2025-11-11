package com.example.androidpractice.ui.todo

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewModelScope
import com.example.androidpractice.data.repository.TodoRepository
import com.example.androidpractice.model.Todo
import com.example.androidpractice.ui.BaseViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TodoViewModel(
    private val todoRepository: TodoRepository
) : BaseViewModel<TodoIntent, TodoState, TodoSideEffect>(TodoState()) {

    init {
        viewModelScope.launch {
            todoRepository.todos.collect {
                intent {
                    copy(todos = todos + it)
                }
            }
        }
    }


    private fun addTodo(title: String, content: String) {
        val newTodo = Todo(title = title, content = content)
        viewModelScope.launch {
            todoRepository.addTodo(newTodo)
        }
        intent {
            copy(todos = todos + newTodo)
        }
    }

    private fun removeTodo(todo: Todo) {
        viewModelScope.launch {
            todoRepository.removeTodo(todo)
        }
        intent {
            copy(todos = todos.filterNot { it.id == todo.id })
        }
    }

    override fun onIntent(intent: TodoIntent) {
        when (intent) {
            is TodoIntent.AddTodo -> addTodo(intent.title, intent.content)
            is TodoIntent.RemoveTodo -> removeTodo(intent.todo)
        }
    }

}
