package com.example.tasks6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_university_details.*

class UniversityDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_university_details)

        showVersityDetails()
    }

    private fun showVersityDetails() {

        val bundle = intent.extras
        val varsityName = bundle?.getString("varsity_name", "")
        val varsityChief = bundle?.getString("varsity_chief", "")
        val varsityPhone = bundle?.getString("varsity_phone", "")
        val varsityEmail = bundle?.getString("varsity_email", "")
        val varsityDistrict = bundle?.getString("varsity_district", "")
        val varsityImage = bundle?.getString("varsity_img", "")

        Glide.with(this)
            .load(varsityImage)
            .error(R.drawable.error)
            .centerCrop()
            .into(iv_details_versity)

        tv_details_university_name.text = varsityName
        tv_details_chief_value.text = varsityChief
        tv_details_phone_value.text = varsityPhone
        tv_details_email_value.text = varsityEmail
        tv_details_district_value.text = varsityDistrict

    }
}
