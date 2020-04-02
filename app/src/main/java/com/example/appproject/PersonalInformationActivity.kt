package com.example.appproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_personal_information.*

class PersonalInformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)
    }

    fun buttonCLick(view: View) {

        val ref = FirebaseDatabase.getInstance().getReference("example")

        val sampleId = ref.push().key!!

        ref.child(sampleId).child("name").setValue(name_reading_edit.text.toString().trim())
        ref.child(sampleId).child("address").setValue(address_reading_edit.text.toString().trim())



        val myIntent = Intent(this, WaterSampleActivity::class.java)
        myIntent.putExtra("sampleId", sampleId)

        startActivity(myIntent)
    }
}
