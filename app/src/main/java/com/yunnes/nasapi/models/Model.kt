package com.yunnes.nasapi.models

import com.google.gson.annotations.SerializedName

data class Model(

	@field:SerializedName("photos")
	val photos: List<PhotosItem>? = null
)






