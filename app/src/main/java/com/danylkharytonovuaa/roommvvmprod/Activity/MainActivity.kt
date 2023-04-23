package com.danylkharytonovuaa.roommvvmprod.Activity

import android.R
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.danylkharytonovuaa.roommvvmprod.Data.StudentDataBase
import com.danylkharytonovuaa.roommvvmprod.Model.RecyclerStudentAdapter
import com.danylkharytonovuaa.roommvvmprod.Model.Student
import com.danylkharytonovuaa.roommvvmprod.ViewModel.MainViewModel
import com.danylkharytonovuaa.roommvvmprod.ViewModel.MainViewModelFactory
import com.danylkharytonovuaa.roommvvmprod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding : ActivityMainBinding? = null
    lateinit var recyclerAdapter : RecyclerStudentAdapter
    lateinit var studentDataBase: StudentDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        recyclerAdapter = RecyclerStudentAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.layoutManager = layoutManager

        studentDataBase = Room.databaseBuilder(this, StudentDataBase::class.java, "student_database")
            .allowMainThreadQueries()
            .build()

        val array = ArrayList<Student>()

        array.addAll(studentDataBase.studentDAO().getAll())

        binding?.recyclerView?.adapter = recyclerAdapter

        val viewModel = ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java]


        viewModel.getStudentLiveData()?.observe(this, studentListUpdateObserver)



    }

    private var studentListUpdateObserver : Observer<ArrayList<Student>> =
        Observer<ArrayList<Student>>{
            it->recyclerAdapter.updateArrayList(it)
        }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}

