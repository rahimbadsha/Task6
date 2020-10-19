package com.example.tasks6.Model

class UniversityModelImpl: UniversityModel {


    override fun getUniversityList(): MutableList<University>
    {
        val varsityList = mutableListOf<University>()

        for (i in 1..10)
        {
            val varsity = University(
                i*101,
                "BUBT Campus",
                "Dhaka",
                "Abdur Rahim",
                "rahimb@gmail.com",
                "01632888127",
                true,
                "https://i.imgur.com/bVRpCsa.jpg"
            )
            val versity1 = University(
                i*101+5,
                "Rajshahi Campus",
                "Rajshahi",
                "Jamir Hossain",
                "jamir.cse@gmail.com",
                "01632888127",
                false,
                "https://i.imgur.com/vB8iNKq.jpg"
            )
            varsityList.add(varsity)
            varsityList.add(versity1)
        }
        return varsityList
    }

    override fun getUniversityById(id: Int): University {

        val versityList = getUniversityList()

        versityList.forEach{
            if (it.id == id) return it
        }

        return University(
            101,
            "BUBT Campus",
            "Dhaka",
            "Abdur Rahim",
            "rahimbadsha.cse@gmail.com",
            "01632888127",
            true,
            "https://i.imgur.com/bVRpCsa.jpg"
        )
    }

}