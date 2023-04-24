package com.danylkharytonovuaa.roommvvmprod.Activity

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.danylkharytonovuaa.roommvvmprod.Data.StudentDataBase
import com.danylkharytonovuaa.roommvvmprod.Model.RecyclerStudentAdapter
import com.danylkharytonovuaa.roommvvmprod.Model.Student
import com.danylkharytonovuaa.roommvvmprod.R
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

        val dialog = Dialog(this)
        val array = ArrayList<Student>()


        binding?.recyclerView?.adapter = recyclerAdapter

        val viewModel = ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java]


        viewModel.getStudentLiveData()?.observe(this, studentListUpdateObserver)

        binding?.floatActionButton?.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog()
    {
        val builder = AlertDialog.Builder(this)
        val viewGroup : ViewGroup = findViewById(android.R.id.content);
        val view = LayoutInflater.from(this).inflate(R.layout.layout_add_student, viewGroup, false)
        builder.setView(view)
        val alertDialog = builder.create()
        val btn = findViewById<Button>(R.id.add_button1)
        btn.setOnClickListener {
            alertDialog.dismiss()
        }
        alertDialog.show()
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

