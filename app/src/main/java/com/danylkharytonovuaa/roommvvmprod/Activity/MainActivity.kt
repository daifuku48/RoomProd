package com.danylkharytonovuaa.roommvvmprod.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danylkharytonovuaa.roommvvmprod.Model.RecyclerStudentAdapter
import com.danylkharytonovuaa.roommvvmprod.R
import com.danylkharytonovuaa.roommvvmprod.ViewModel.MainViewModel
import com.danylkharytonovuaa.roommvvmprod.ViewModel.MainViewModelFactory
import com.danylkharytonovuaa.roommvvmprod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val recyclerAdapter = RecyclerStudentAdapter()
        val layoutManager = LinearLayoutManager(this)

        binding?.recyclerView?.layoutManager = layoutManager
        binding?.recyclerView?.adapter = recyclerAdapter

        val viewModel = ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java]

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}