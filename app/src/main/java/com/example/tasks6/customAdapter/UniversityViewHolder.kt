package com.example.tasks6.customAdapter

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.university_list.view.*

class UniversityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val ivVarsity: AppCompatImageView = itemView.iv_university
    val tvVarsityName: AppCompatTextView = itemView.tv_university_name
    val tvDistrict: AppCompatTextView = itemView.tv_university_district_value
    val tvChief: AppCompatTextView = itemView.tv_university_chief_value
    val tvEmail: AppCompatTextView = itemView.tv_university_email
    val tvPhone: AppCompatTextView = itemView.tv_university_phone
}