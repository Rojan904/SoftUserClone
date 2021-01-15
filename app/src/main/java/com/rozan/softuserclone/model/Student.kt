package com.rozan.softuserclone.model

import android.location.Address
import java.io.Serializable

class Student:Serializable {
    val image:String
    val fullname:String
    val age:Int
    val gender:String
    val address: String

    constructor(image:String,fullname:String,age:Int,gender:String,address: String){
        this.image=image
        this.fullname=fullname
        this.age=age
        this.gender=gender
        this.address=address
    }

    override fun toString(): String {
        return super.toString()
    }
}

