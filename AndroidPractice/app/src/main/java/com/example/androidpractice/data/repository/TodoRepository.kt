package com.example.androidpractice.data.repository

import com.example.androidpractice.db.room.TodoDao
import com.example.androidpractice.model.Todo
import kotlinx.coroutines.flow.Flow

class TodoRepository(private val dao: TodoDao) {

    val todos: Flow<List<Todo>> = dao.getAllTodos()

    suspend fun addTodo(todo: Todo) {
        dao.insert(todo)
    }

    suspend fun removeTodo(todo: Todo) {
        dao.delete(todo)
    }
}