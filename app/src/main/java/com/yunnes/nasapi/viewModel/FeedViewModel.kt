package com.yunnes.nasapi.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yunnes.nasapi.models.PhotosItem
import com.yunnes.nasapi.service.ApiKey
import com.yunnes.nasapi.service.NasaAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FeedViewModel : ViewModel() {

    private val nasaAPIService = NasaAPIService()
    private val disposable =  CompositeDisposable()

    val rovers = MutableLiveData<List<PhotosItem>>()
    val roverError = MutableLiveData<Boolean>()
    val roverLoading = MutableLiveData<Boolean>()
    val cameraLiveData = MutableLiveData<List<PhotosItem>>()


    fun refreshData() {
        getDataFromAPI()

    }


    private fun getDataFromAPI() {
        disposable.add(
            nasaAPIService.getNasa()
                .getNews("1000",ApiKey.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                    Log.i("Data basarili.",it.photos.toString())
                        roverError.value=false
                        roverLoading.value=false
                        rovers.value=it?.photos

                    },
                    {
                        Log.d("DENEME", it.message)
                    }
                )
        )

    }

     fun getCamera(camera:String) {
        disposable.add(
                nasaAPIService.getNasa()
                        .getCamera("1000",camera,ApiKey.API_KEY)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {
                                    Log.i("Data basarili.",it.photos.toString())
                                    roverError.value=false
                                    roverLoading.value=false
                                    cameraLiveData.value=it?.photos

                                },
                                {
                                    Log.d("DENEME", it.message)
                                }
                        )
        )

    }



}

