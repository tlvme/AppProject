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

    fun checkEmpty(a: EditText): Int {
        val message = a.text.toString().trim();
        if (message.isEmpty()) {
            a.error = "Please enter this value"
            return 1
        }
        return 0
    }

    fun buttonClickOk(view: View) {

        var flag = 0

        var list = arrayListOf<EditText>().apply {

            addAll(listOf(ph_reading_edit, ph_reading_edit_error, alkalinity_reading_edit, alkalinity_reading_edit_error, ec_reading_edit, ec_reading_edit_error, tds_reading_edit, tds_reading_edit_error, turbidity_reading_edit, turbidity_reading_edit_error, hardness_reading_edit, hardness_reading_edit_error, sodium_reading_edit, sodium_reading_edit_error, potassium_reading_edit, potassium_reading_edit_error, calcium_reading_edit, calcium_reading_edit_error, magnesium_reading_edit, magnesium_reading_edit_error, fluoride_reading_edit, fluoride_reading_edit_error, chloride_reading_edit, chloride_reading_edit_error, nitrate_reading_edit, nitrate_reading_edit_error, phosphate_reading_edit, phosphate_reading_edit_error, sulphate_reading_edit, sulphate_reading_edit_error, Al_reading_edit, Al_reading_edit_error, V_reading_edit, V_reading_edit_error, Mn_reading_edit, Mn_reading_edit_error, Fe_reading_edit, Fe_reading_edit_error, Ni_reading_edit, Ni_reading_edit_error, Cu_reading_edit, Cu_reading_edit_error, Zn_reading_edit, Zn_reading_edit_error, Ba_reading_edit, Ba_reading_edit_error, Co_reading_edit, Co_reading_edit_error, Mo_reading_edit, Mo_reading_edit_error, Hg_reading_edit, Hg_reading_edit_error, As_reading_edit, As_reading_edit_error, Cd_reading_edit, Cd_reading_edit_error, Ag_reading_edit, Ag_reading_edit_error, Cr_reading_edit, Cr_reading_edit_error, Pb_reading_edit, Pb_reading_edit_error, silica_reading_edit, silica_reading_edit_error, b_reading_edit, b_reading_edit_error, li_reading_edit, li_reading_edit_error, sr_reading_edit, sr_reading_edit_error))
        }


        for (i in list) {
            flag += checkEmpty(i)
        }

        if (flag>0) {
            return
        }
        val sampleId = intent.getStringExtra("sampleId")!!
        val ref = FirebaseDatabase.getInstance().getReference("example")

        ref.child(sampleId).child("phReading").setValue(ph_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("phReading Error").setValue(ph_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Alkalinity").setValue(alkalinity_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Alkalinity Error").setValue(alkalinity_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("EC Reading").setValue(ec_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("EC Reading Error").setValue(ec_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("TDS Reading").setValue(tds_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("TDS Reading Error").setValue(tds_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Turbidity").setValue(turbidity_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Turbidity Error").setValue(turbidity_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Hardness").setValue(hardness_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Hardness Error").setValue(hardness_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Sodium Reading").setValue(sodium_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Sodium Reading Error").setValue(sodium_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Potassium Reading").setValue(potassium_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Potassium Reading Error").setValue(potassium_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Calcium Reading").setValue(calcium_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Calcium Reading Error").setValue(calcium_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Magnesium Reading").setValue(magnesium_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Magnesium Reading Error").setValue(magnesium_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Fluoride Reading").setValue(fluoride_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Fluoride Reading Error").setValue(fluoride_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Chloride Reading").setValue(chloride_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Chloride Reading Error").setValue(chloride_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Nitrate Reading").setValue(nitrate_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Nitrate Reading Error").setValue(nitrate_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Phosphate Reading").setValue(phosphate_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Phosphate Reading Error").setValue(phosphate_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Sulphate Reading").setValue(sulphate_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Sulphate Reading Error").setValue(sulphate_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Al Reading").setValue(Al_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Al Reading Error").setValue(Al_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("V Reading ").setValue(V_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("V Reading Error").setValue(V_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Mn Reading").setValue(Mn_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Mn Reading Error").setValue(Mn_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Fe Reading").setValue(Fe_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Fe Reading Error").setValue(Fe_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Ni Reading").setValue(Ni_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Ni Reading Error").setValue(Ni_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Cu Reading").setValue(Cu_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Cu Reading Error").setValue(Cu_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Zn Reading").setValue(Zn_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Zn Reading Error").setValue(Zn_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Ba Reading").setValue(Ba_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Ba Reading Error").setValue(Ba_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Co Reading").setValue(Co_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Co Reading Error").setValue(Co_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Mo Reading").setValue(Mo_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Mo Reading Error").setValue(Mo_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Hg Reading").setValue(Hg_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Hg Reading Error").setValue(Hg_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("As Reading").setValue(As_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("As Reading Error").setValue(As_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Cd Reading").setValue(Cd_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Cd Reading Error").setValue(Cd_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Ag Reading").setValue(Ag_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Ag Reading Error").setValue(Ag_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Cr Reading").setValue(Cr_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Cr Reading Error").setValue(Cr_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Pb Reading").setValue(Pb_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Pb Reading Error").setValue(Pb_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Silica Reading").setValue(silica_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Silica Reading Error").setValue(silica_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("B Reading").setValue(b_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("B Reading Error").setValue(b_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Li Reading").setValue(li_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Li Reading Error").setValue(li_reading_edit_error.text.toString().trim().toDouble())
        ref.child(sampleId).child("Sr Reading").setValue(sr_reading_edit.text.toString().trim().toDouble())
        ref.child(sampleId).child("Sr Reading Error").setValue(sr_reading_edit_error.text.toString().trim().toDouble())








    }
}
