package com.example.tasks6.Model

interface UniversityModel {
    fun getUniversityList(): MutableList<University>
    fun getUniversityById(id: Int): University
}