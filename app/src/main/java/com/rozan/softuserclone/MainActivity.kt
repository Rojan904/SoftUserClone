package com.rozan.softuserclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername=findViewById(R.id.etUsername)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnLogin -> {
                if (checkEmpty()){
                    if (etUsername.text.toString() == "softwarica" && etPassword.text.toString() == "coventry") {
                    val intent=Intent(this,DashboardActivity::class.java)
                    startActivity(intent)
                    } else {
                        Toast.makeText(this, "Incorrect username or password.", Toast.LENGTH_SHORT).show()
                    }
                }
                else
                    return

            }
        }
    }

    private fun checkEmpty(): Boolean {
        var flag=true
        when{
            TextUtils.isEmpty(etUsername.text)->{
                etUsername.error="Enter your username"
                etUsername.requestFocus()
                flag=false
            }
            TextUtils.isEmpty(etPassword.text)->{
                etPassword.error="Enter your password"
                etPassword.requestFocus()
                flag=false
            }
        }
        return flag
    }

}