package com.yunnes.nasapi.service

import android.view.Display
import com.yunnes.nasapi.models.Model
import com.yunnes.nasapi.models.PhotosItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaAPI {

/*
    https://api.nasa.gov/
*/
   /* @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=v6o9q02zdstWHJsoGh9ddKeFKhY7LrF3LbYykJDO")
    fun getRovers():Single<Model>*/

  /* https://api.nasa.gov/mars-photos/api/v1/rovers/opportunity/photos?sol=100&camera&api_key=v6o9q02zdstWHJsoGh9ddKeFKhY7LrF3LbYykJDO */

  @GET("mars-photos/api/v1/rovers/curiosity/photos?")
    fun getNews(
            @Query("sol") sol: String,
            @Query("api_key") from: String,
    ): Single<Model>

    @GET("mars-photos/api/v1/rovers/spirit/photos?")
    fun getSpirit(
        @Query("sol") sol: String,
        @Query("api_key") from: String,
    ): Single<Model>

    @GET("mars-photos/api/v1/rovers/opportunity/photos?")
    fun getOpportunity(
        @Query("sol") sol: String,
        @Query("api_key") from: String,
    ): Single<Model>

  @GET("mars-photos/api/v1/rovers/curiosity/photos?")
  fun getCamera(
          @Query("sol") sol: String,
          @Query(value = "camera") camera: String,
          @Query("api_key") from: String,
  ): Single<Model>

  @GET("mars-photos/api/v1/rovers/opportunity/photos?")
  fun getCameraOpportunity(
          @Query("sol") sol: String,
          @Query(value = "camera") camera: String,
          @Query("api_key") from: String,
  ): Single<Model>

  @GET("mars-photos/api/v1/rovers/spirit/photos?")
  fun getCameraSpirit(
          @Query("sol") sol: String,
          @Query(value = "camera") camera: String,
          @Query("api_key") from: String,
  ): Single<Model>
}