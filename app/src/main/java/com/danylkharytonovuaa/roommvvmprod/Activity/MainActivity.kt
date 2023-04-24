package com.danylkharytonovuaa.roommvvmprod.Activity

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.danylkharytonovuaa.roommvvmprod.Data.StudentDataBase
import com.danylkharytonovuaa.roommvvmprod.Model.RecyclerStudentAdapter
import com.danylkharytonovuaa.roommvvmprod.Model.Student
import com.danylkharytonovuaa.roommvvmprod.R

import com.danylkharytonovuaa.roommvvmprod.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var binding : ActivityMainBinding? = null
    lateinit var recyclerAdapter : RecyclerStudentAdapter
    lateinit var studentDataBase: StudentDataBase
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val array = ArrayList<Student>()
        recyclerAdapter = RecyclerStudentAdapter(array)
        val layoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.layoutManager = layoutManager

        dialog = Dialog(this)



        studentDataBase = Room.databaseBuilder(this, StudentDataBase::class.java, "student_sb")
            .allowMainThreadQueries()
            .build()

        array.addAll(studentDataBase.studentDAO().getAll())



        binding?.recyclerView?.adapter = recyclerAdapter

        binding?.floatActionButton?.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog()
    {
        dialog.setContentView(R.layout.layout_add_student)
        val button = dialog.findViewById<Button>(R.id.add_button1)
        val nameText = dialog.findViewById<EditText>(R.id.nameEditText)
        val surnameText = dialog.findViewById<EditText>(R.id.surnameEditText)
        val specText = dialog.findViewById<EditText>(R.id.specEditText)
        button.setOnClickListener {
            val student = Student(0, nameText.text.toString(), surnameText.text.toString(), specText.text.toString())
            studentDataBase.studentDAO().insertAll(student)
            dialog.dismiss()
        }
        dialog.setCancelable(false)
        dialog.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}

