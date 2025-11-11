package com.example.androidpractice.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidpractice.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}