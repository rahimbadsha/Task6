package com.example.tasks6.customAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tasks6.Model.University
import com.example.tasks6.R
import com.example.tasks6.UniversityItemClickListener
import kotlinx.android.synthetic.main.university_list.view.*

class UniversityListAdapter(
    private val versityList: MutableList<University>,
    private val clickListener: UniversityItemClickListener
): RecyclerView.Adapter<UniversityViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.university_list, parent, false)
        return UniversityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return versityList.size
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val versity = versityList[position]

        Glide.with(context)
            .load(versity.imageUrl)
            .into(holder.ivVarsity)

        holder.tvVarsityName.text = versity.varsityName
        holder.tvDistrict.text = versity.district
        holder.tvChief.text = versity.chief
        holder.tvEmail.text = versity.email

        holder.ivVarsity.setImageDrawable(
            ContextCompat.getDrawable(context, R.drawable.bubt)
        )

        if(versity.isPhoneView)
        {
            holder.tvPhone.text = versity.phone
        }
        else
        {
            holder.itemView.tv_university_phone.visibility = View.GONE
        }

        holder.itemView.setOnClickListener{
            clickListener.onVarsityItemClicked(position)
        }

        holder.tvEmail.setOnClickListener {
            clickListener.onVarsityEmailClicked(position)
        }

        holder.tvPhone.setOnClickListener {
            clickListener.onVarsityPhoneClicked(position)
        }
    }

}
