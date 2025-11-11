package com.example.androidpractice.db.sqlight

import android.content.ContentValues
import com.example.androidpractice.model.Todo

class TodoDao(private val dbHelper: TodoDatabaseHelper) {

    fun insert(todo: Todo) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("title", todo.title)
            put("content", todo.content)
        }
        db.insert("todos", null, values)
    }

    fun getAll(): List<Todo> {
        val db = dbHelper.readableDatabase
        val cursor = db.query("todos", null, null, null, null, null, null)
        val list = mutableListOf<Todo>()

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
            val content = cursor.getString(cursor.getColumnIndexOrThrow("content"))
            list.add(Todo(id, title, content))
        }
        cursor.close()
        return list
    }

    fun delete(todo: Todo) {
        val db = dbHelper.writableDatabase
        db.delete("todos", "id = ?", arrayOf(todo.id.toString()))
    }
}