package com.example.appproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.firebase.database.FirebaseDatabase

class PersonalInformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)
    }

    fun buttonCLick(view: View) {
//        val myIntent = Intent(this, WaterSampleActivity::class.java)
//        startActivity(myIntent)

        val nameView = findViewById<EditText>(R.id.name_reading_edit)
        val addressView = findViewById<EditText>(R.id.address_reading_edit)

        val name = nameView.text.toString().trim()
        val address = addressView.text.toString().trim()

        val ref = FirebaseDatabase.getInstance().getReference("example")

        val sampleId = ref.push().key!!

        val sample = Example(sampleId, name, address)

        ref.child(sampleId).setValue(sample)
    }
}
