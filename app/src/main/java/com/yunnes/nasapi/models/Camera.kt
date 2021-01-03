package com.yunnes.nasapi.models

import com.google.gson.annotations.SerializedName

data class Camera(


        @field:SerializedName("id")
        val id: Int? = null,


        @field:SerializedName("name")
        val name: String? = null,


        @field:SerializedName("rover_id")
        val roverId: Int? = null,

        @field:SerializedName("full_name")
        val fullName: String? = null


)