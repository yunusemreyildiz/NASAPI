package com.yunnes.nasapi.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yunnes.nasapi.R
import com.yunnes.nasapi.models.PhotosItem
import com.yunnes.nasapi.service.NasaAPI
import com.yunnes.nasapi.view.Detail
import com.yunnes.nasapi.viewModel.Constanst

import kotlinx.android.synthetic.main.item_rover.view.*


class NasaAdapter(val nasaList: ArrayList<PhotosItem>,val nasaAPI: click): RecyclerView.Adapter<NasaAdapter.NasaViewHolder>() {

val kk=nasaAPI

    class NasaViewHolder(var view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_rover, parent, false)
        return NasaViewHolder(view)
    }

    override fun onBindViewHolder(holder: NasaViewHolder, position: Int) {
      /*  holder.view.nasaid.text = nasaList[position].id.toString()
        holder.view.nasasol.text = nasaList[position].sol.toString()*/
        Log.i("bababa", nasaList.get(position).imgSrc.toString())
        Glide.with(holder.view.context)
            .asBitmap()
            .load(nasaList.get(position).imgSrc)
            .fitCenter()
            .transform()
            .apply(RequestOptions()).override(300, 100)
            .into(holder.view.ImageView);


        holder.view.setOnClickListener {
            Constanst.imageSrc=nasaList.get(position).imgSrc.toString()
            Constanst.sol="Sol: ${nasaList.get(position).sol.toString()}"
            Constanst.camera="Camera: ${nasaList.get(position).camera.toString()}"
            Constanst.earth_date="Earth Date: ${nasaList.get(position).earthDate.toString()}"
            Constanst.rover="Rover: ${nasaList.get(position).rover.toString()}"
            kk.clickable(nasaList.get(position))

            val intent=Intent(holder.view.context,Detail::class.java)
            holder.view.context.startActivity(intent)

            }

            /*val action = FeedFragmentDirections.actionFeedFragmentToRoverFragment()

            Navigation.findNavController(it).navigate(action)*/

        }




    override fun getItemCount(): Int {
        return nasaList.size
    }
    fun updateNasaList(newNasaList: List<PhotosItem>){
        nasaList.clear()
        nasaList.addAll(newNasaList)
        notifyDataSetChanged()
    }
}
