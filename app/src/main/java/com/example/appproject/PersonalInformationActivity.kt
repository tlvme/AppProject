package com.example.appproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.FileProvider
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_personal_information.*
import kotlinx.android.synthetic.main.activity_personal_information.view.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Looper
import android.provider.Settings
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*

class PersonalInformationActivity : AppCompatActivity() {

    val PERMISSION_ID = 42
    var latitude = "NULL"
    var longitude = "NULL"
    lateinit var mFusedLocationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getLastLocation()
    }

    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {

                mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
                    var location: Location? = task.result
                    if (location == null) {
                        requestNewLocationData()
                    } else {
                        latitude = location.latitude.toString()
                        longitude = location.longitude.toString()
                    }
                }
            } else {
                Toast.makeText(this, "Turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermissions()
        }
    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        var mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        mFusedLocationClient!!.requestLocationUpdates(
            mLocationRequest, mLocationCallback,
            Looper.myLooper()
        )
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            var mLastLocation: Location = locationResult.lastLocation
            latitude = mLastLocation.latitude.toString()
            longitude = mLastLocation.longitude.toString()
        }
    }

    private fun isLocationEnabled(): Boolean {
        var locationManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun checkPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_ID
        )
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == PERMISSION_ID) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                getLastLocation()
            }
        }
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


//        Toast.makeText(this, "error in camera", Toast.LENGTH_LONG).show()



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
        ref.child(sampleId).child("Latitude").setValue(latitude)
        ref.child(sampleId).child("Longitude").setValue(longitude)

        val myIntent = Intent(this, WaterSampleActivity::class.java)
        myIntent.putExtra("sampleId", sampleId)

        startActivity(myIntent)
    }
}
