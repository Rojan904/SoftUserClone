package com.rozan.softuserclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rozan.softuserclone.R
import com.rozan.softuserclone.model.Student

class StudentAdapter(
        val lstStudent:ArrayList<Student>,
        val context:Context
):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imgProfile:ImageView
        val tvName:TextView
        val tvAge:TextView
        val tvAddress:TextView
        val tvGender:TextView
        val imgDelete:ImageButton

        init {
            imgProfile=view.findViewById(R.id.imgProfile)
            tvName=view.findViewById(R.id.tvName)
            tvAge=view.findViewById(R.id.tvAge)
            tvAddress=view.findViewById(R.id.tvAddress)
            tvGender=view.findViewById(R.id.tvGender)
            imgDelete=view.findViewById(R.id.imgDelete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.student_layout,parent,false)
        return StudentViewHolder(view)

    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student=lstStudent[position]
        holder.tvName.text=student.fullname
        holder.tvAge.text=student.age.toString()
        holder.tvAddress.text=student.address
        holder.tvGender.text=student.gender

        Glide.with(context)
                .load(student.image)
                .into(holder.imgProfile)
        holder.imgDelete.setOnClickListener{
            lstStudent.removeAt(position)
            notifyDataSetChanged()
        }



    }

    override fun getItemCount(): Int {
       return lstStudent.size
    }


}