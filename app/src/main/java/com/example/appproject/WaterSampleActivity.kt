package com.example.appproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_water_sample.*

class WaterSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_sample)
    }

    fun buttonClickOk(view: View) {

        val sampleId = intent.getStringExtra("sampleId")!!
        val ref = FirebaseDatabase.getInstance().getReference("example")

        ref.child(sampleId).child("phReading").setValue(ph_reading_edit.text.toString().trim())




    }
}
