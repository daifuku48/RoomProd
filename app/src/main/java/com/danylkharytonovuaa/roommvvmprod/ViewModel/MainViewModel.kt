package com.danylkharytonovuaa.roommvvmprod.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danylkharytonovuaa.roommvvmprod.Model.Student


class MainViewModel : ViewModel() {
    private var studentLiveData : MutableLiveData<List<Student>>? = null
    private var studentList : ArrayList<Student>? = null

    init {
        studentList = ArrayList()

    }

    fun getStudentLiveData() : MutableLiveData<List<Student>> ?
    {
        return studentLiveData
    }


}