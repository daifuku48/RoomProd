package com.danylkharytonovuaa.roommvvmprod.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danylkharytonovuaa.roommvvmprod.Data.StudentDataBase
import com.danylkharytonovuaa.roommvvmprod.Model.Student


class MainViewModel : ViewModel() {
    private var studentLiveData : MutableLiveData<ArrayList<Student>>? = null
    private var studentList : ArrayList<Student>? = null

    private var studentDataBase : StudentDataBase? = null
    fun getStudentLiveData() : MutableLiveData<ArrayList<Student>> ?
    {
        return studentLiveData
    }


}