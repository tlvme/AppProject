package com.example.appproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_personal_information.*
import kotlinx.android.synthetic.main.activity_personal_information.view.*

class PersonalInformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)
    }

    private fun checkEmpty(a: EditText): Int {
        val message = a.text.toString().trim();
        if (message.isEmpty()) {
            a.error = "Please enter this value"
            return 1
        }
        return 0
    }

    fun buttonCLick(view: View) {

        var flag = 0

        var list = arrayListOf<EditText>().apply {

            addAll(listOf(name_reading_edit, address_reading_edit, age_reading_edit, gender_reading_edit, height_reading_edit, height_reading_edit_error, weight_reading_edit, weight_reading_edit_error, BMI_reading_edit, BMI_reading_edit_error, SystolicBloodPressure_reading_edit, SystolicBloodPressure_reading_edit_error, DiastolicBloodPressure_reading_edit, DiastolicBloodPressure_reading_edit_error, eGFR_reading_edit, eGFR_reading_edit_error, Serumcreatinine_reading_edit, Serumcreatinine_reading_edit_error, Serumurea_reading_edit, Serumurea_reading_edit_error, Plasmaalbumin_reading_edit, Plasmaalbumin_reading_edit_error, SerumUricacid_reading_edit, SerumUricacid_reading_edit_error, Glucose_reading_edit, Glucose_reading_edit_error, SerumCopper_reading_edit, SerumCopper_reading_edit_error, SerumZinc_reading_edit, SerumZinc_reading_edit_error, SerumSelenium_reading_edit, SerumSelenium_reading_edit_error, SerumCalcium_reading_edit, SerumCalcium_reading_edit_error, BloodLead_reading_edit, BloodLead_reading_edit_error, BloodCadmium_reading_edit, BloodChromium_reading_edit))
        }


        for (i in list) {
            flag += checkEmpty(i)
        }

        if (flag>0) {
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("example")

        val sampleId = ref.push().key!!

        ref.child(sampleId).child("Name").setValue(name_reading_edit.text.toString().trim())
        ref.child(sampleId).child("Address").setValue(address_reading_edit.text.toString().trim())
        ref.child(sampleId).child("Age").setValue(age_reading_edit.text.toString().trim().toInt())
        ref.child(sampleId).child("Gender").setValue(gender_reading_edit.text.toString().trim())
        ref.child(sampleId).child("Height").setValue(height_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Height Error").setValue(height_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Weight").setValue(weight_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Weight Error").setValue(weight_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("BMI").setValue(BMI_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("BMI Error").setValue(BMI_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("SystolicBloodPressure").setValue(SystolicBloodPressure_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("SystolicBloodPressure Error").setValue(SystolicBloodPressure_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("DiastolicBloodPressure").setValue(DiastolicBloodPressure_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("DiastolicBloodPressure Error").setValue(DiastolicBloodPressure_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("eGFR").setValue(eGFR_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("eGFR Error").setValue(eGFR_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Serumcreatinine").setValue(Serumcreatinine_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Serumcreatinine Error").setValue(Serumcreatinine_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Serumurea").setValue(Serumurea_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Serumurea Error").setValue(Serumurea_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Plasmaalbumin").setValue(Plasmaalbumin_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Plasmaalbumin Error").setValue(Plasmaalbumin_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("SerumUricacid").setValue(SerumUricacid_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("SerumUricacid Error").setValue(SerumUricacid_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Glucose").setValue(Glucose_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Glucose Error").setValue(Glucose_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("SerumCopper").setValue(SerumCopper_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("SerumCopper Error").setValue(SerumCopper_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("SerumZinc").setValue(SerumZinc_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("SerumZinc Error").setValue(SerumZinc_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("SerumSelenium").setValue(SerumSelenium_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("SerumSelenium Error").setValue(SerumSelenium_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("SerumCalcium").setValue(SerumCalcium_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("SerumCalcium Error").setValue(SerumCalcium_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("BloodLead").setValue(BloodLead_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("BloodLead Error").setValue(BloodLead_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("BloodCadmium").setValue(BloodCadmium_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("BloodChromium").setValue(BloodChromium_reading_edit.text.toString().trim().toDouble())


        val myIntent = Intent(this, WaterSampleActivity::class.java)
        myIntent.putExtra("sampleId", sampleId)

        startActivity(myIntent)
    }
}
