package com.yunnes.nasapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.yunnes.nasapi.R
import com.yunnes.nasapi.viewModel.Constanst
import kotlinx.android.synthetic.main.fragment_rover.*

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_rover)

        Glide.with(this).load(Constanst.imageSrc.toString()).into(nasaImageView)
        nasaSOL.text= Constanst.sol.toString()
        nasaCAMERA.text= Constanst.camera.toString()
        nasaEARTHDATE.text= Constanst.earth_date.toString()
        nasaROVER.text= Constanst.rover.toString()

    }
}