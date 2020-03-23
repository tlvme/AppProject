package com.example.appproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PersonalInformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)
    }

    fun buttonCLick(view: View) {
        val myIntent = Intent(this, WaterSampleActivity::class.java)
        startActivity(myIntent)
    }
}
