package com.danylkharytonovuaa.roommvvmprod.Model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danylkharytonovuaa.roommvvmprod.R

class RecyclerStudentAdapter(private var array : ArrayList<Student>) : RecyclerView.Adapter<RecyclerStudentAdapter.ViewHolder>() {


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        val name: TextView
        val surname: TextView
        val specialization: TextView

        init{
            name = view.findViewById(R.id.name_recycler)
            surname = view.findViewById(R.id.surname_recycler)
            specialization = view.findViewById(R.id.specializarion)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = array.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = array[position].name
        holder.surname.text = array[position].surname
        holder.specialization.text = array[position].specialization
    }
}