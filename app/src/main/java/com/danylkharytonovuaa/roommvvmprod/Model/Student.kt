package com.danylkharytonovuaa.roommvvmprod.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    var uId : Int,
    @ColumnInfo(name = "student_name")
    var name: String,
    @ColumnInfo(name = "student_surname")
    var surname: String,
    @ColumnInfo(name = "student_spec")
    var specialization: String)
{
    @Ignore
    constructor() : this(0, "", "", "")
}