package com.example.tasks6

import android.Manifest.permission.CALL_PHONE
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasks6.Model.University
import com.example.tasks6.Model.UniversityModel
import com.example.tasks6.Model.UniversityModelImpl
import com.example.tasks6.customAdapter.UniversityListAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val PERMISSION_REQUEST_CODE: Int = 1020
    private lateinit var context: Context

    private lateinit var varsityModel: UniversityModel

    private lateinit var varsityList: MutableList<University>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        varsityModel = UniversityModelImpl()
        varsityList  = varsityModel.getUniversityList()

        showUniveristyList()

    }

    @SuppressLint("WrongConstant") // Why i need to write this
    private fun showUniveristyList() {

        val adapter = UniversityListAdapter(varsityList, object : UniversityItemClickListener
        {
            //Can't use Toast() func here.
            override fun onVarsityItemClicked(position: Int) {

                if (position == 0)
                {
                    goToActivity(context,  UniversityDetails::class.java, position)
                }
                else if (position == 1)
                {
                    goToActivity(context,  UniversityDetails::class.java, position)
                }
            }

            // Onclick email
            override fun onVarsityEmailClicked(position: Int) {
                emailTheDeveloper()
            }

            // Onclick Phone
            override fun onVarsityPhoneClicked(position: Int) {
                callTheDeveloper()
            }

        })

        recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, // Why LinearLayoutManger
            false
        )
        recyclerView.adapter = adapter
    }

    @SuppressLint("MissingPermission") // Already added the permission. why need this annotation?
    private fun callTheDeveloper() {
        if (isPermissionGranted())
        {
            val number = getString(R.string.phone_number)
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$number")
            startActivity(callIntent)
        } else {
            requestPermissions()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE)
        {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                callTheDeveloper()
            }
        }
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(CALL_PHONE),
            PERMISSION_REQUEST_CODE
        )
    }

    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(applicationContext, CALL_PHONE) == PackageManager.PERMISSION_GRANTED
    }

    private fun emailTheDeveloper() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "plain/text"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("receiver.email@gmail.com", "second.email@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "What's on your mind?")
        intent.putExtra(Intent.EXTRA_TEXT, "")
        startActivity(Intent.createChooser(intent, "Choose your apps"))
    }

    fun Context.goToActivity(context: Context, classs: Class<*>?, position: Int) {

        val intent = Intent(context, classs)
        val bundle = Bundle()
        bundle.putString("varsity_name", varsityList[position].varsityName)
        bundle.putString("varsity_chief", varsityList[position].chief)
        bundle.putString("varsity_phone", varsityList[position].phone)
        bundle.putString("varsity_email", varsityList[position].email)
        bundle.putString("varsity_district", varsityList[position].district)
        bundle.putString("varsity_img", varsityList[position].imageUrl)
        intent.putExtras(bundle)
        startActivity(intent)
    }


/*    fun showToast(string: String)
    {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }*/
}
