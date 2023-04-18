package com.danylkharytonovuaa.roommvvmprod.Data

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.danylkharytonovuaa.roommvvmprod.Model.Student


@Database(entities = [Student::class], version = 1)
abstract class StudentDataBase : RoomDatabase() {
    abstract fun studentDAO() : StudentDAO
}