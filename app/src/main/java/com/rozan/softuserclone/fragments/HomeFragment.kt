package com.rozan.softuserclone.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rozan.softuserclone.R
import com.rozan.softuserclone.adapter.StudentAdapter
import com.rozan.softuserclone.model.Student
import com.rozan.softuserclone.studentList


class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context!!)
        mContext = context
    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view=inflater.inflate(R.layout.fragment_home, container, false)
        storyRecyclerView(view)

//        val bundle = this.arguments
//        if (bundle != null) {
//            val student= bundle.getSerializable("studentList") as ArrayList<Student>  // Key
//            for(i in student.indices){
//                studentList.add(Student("",student[i].fullname,student[i].age,student[i].gender,student[i].address))
//            }
//        }
        return view


    }

    private fun storyRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        val adapter = StudentAdapter(studentList, mContext)
        recyclerView.layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter

        loadStudent()

    }

    private fun loadStudent() {
    studentList.add(Student("", "Rojan Stha", 20, "Male", "Kapan"))

    }

    companion object{
        fun newInstance():HomeFragment=HomeFragment()
    }


}