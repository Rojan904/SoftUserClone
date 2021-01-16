package com.rozan.softuserclone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rozan.softuserclone.R
import com.rozan.softuserclone.model.Student
import com.rozan.softuserclone.studentList


class StudentFragment : Fragment(),View.OnClickListener {
    private lateinit var etName:EditText
    private lateinit var etAge:EditText
    private lateinit var rdoGender:RadioGroup
    private lateinit var etAddress:EditText
    private lateinit var etImage:EditText
    private lateinit var btnSave: Button
    private var gender="Male"
    var fragment=Fragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_student, container, false)
        etName=view.findViewById(R.id.etName)
        etAge=view.findViewById(R.id.etAge)
        rdoGender=view.findViewById(R.id.rdoGender)
        etAddress=view.findViewById(R.id.etAddress)
        etImage=view.findViewById(R.id.etImage)
        btnSave=view.findViewById(R.id.btnSave)

        rdoGender.setOnCheckedChangeListener { radioGroup, id ->
            if (id==R.id.rdoMale){
                gender="Male"
            }
            else if (id==R.id.rdoFemale){
                gender="Female"
            }
            else if (id==R.id.rdoOthers){
                gender="Others"
            }
        }
        btnSave.setOnClickListener(this)
        return view
    }
    companion object{
        fun newInstance():StudentFragment=StudentFragment()
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnSave -> {
                studentList.add(Student(etImage.text.toString(), etName.text.toString(), etAge.text.toString().toInt(), gender, etAddress.text.toString()))
//                val bundle = Bundle()
//                bundle.putSerializable("studentList",studentList)
//                fragment.arguments = bundle
                Toast.makeText(context, "Student Added", Toast.LENGTH_SHORT).show()
                etName.text.clear()
                etAge.text.clear()
                rdoGender.clearCheck()
                etAddress.text.clear()
                etImage.text.clear()

            }
        }
    }


}