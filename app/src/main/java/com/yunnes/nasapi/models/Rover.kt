package com.yunnes.nasapi.models

import com.google.gson.annotations.SerializedName

data class Rover(

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("landing_date")
        val landingDate: String? = null,

        @field:SerializedName("launch_date")
        val launchDate: String? = null,


        @field:SerializedName("status")
        val status: String? = null
)