package com.danylkharytonovuaa.roommvvmprod.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.danylkharytonovuaa.roommvvmprod.Model.Student


@Dao
interface StudentDAO {

    @Query("SELECT * FROM student_table")
    fun getAll() : List<Student>

    @Query("SELECT * FROM student_table WHERE student_id IN (:studentIds)")
    fun loadAllByIds(studentIds: IntArray): List<Student>

    @Query("SELECT * FROM student_table WHERE student_name LIKE (:name) AND student_surname LIKE (:surname) LIMIT 1")
    fun findByName(name: String, surname: String) : Student

    @Query("SELECT * FROM student_table WHERE student_id LIKE (:id) LIMIT 1")
    fun getStudent(id: Int) : Student

    @Insert
    fun insertAll(vararg students: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Update
    fun updateStudent(student: Student)
}