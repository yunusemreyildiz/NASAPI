package com.yunnes.nasapi.view

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.yunnes.nasapi.R
import com.yunnes.nasapi.adapter.NasaAdapter
import com.yunnes.nasapi.adapter.click
import com.yunnes.nasapi.models.PhotosItem
import com.yunnes.nasapi.viewModel.Constanst
import com.yunnes.nasapi.viewModel.FeedViewModel
import com.yunnes.nasapi.viewModel.OpportunityViewModel
import com.yunnes.nasapi.viewModel.SpiritViewModel
import kotlinx.android.synthetic.main.fragment_feed.*
import java.util.ArrayList


class OpportunityFragment : Fragment() ,click{

    private lateinit var viewModel : OpportunityViewModel
    private val nasaAdapter = NasaAdapter(arrayListOf(), this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(OpportunityViewModel::class.java)
        viewModel.refreshData()

        nasaList.layoutManager = GridLayoutManager(requireContext(), 3)
        nasaList.adapter = nasaAdapter
        camButton.setOnClickListener {
            showDialog()

        }

        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.rovers.observe(viewLifecycleOwner, Observer { rovers ->

            rovers?.let {
                nasaList.visibility = View.VISIBLE
                nasaAdapter.updateNasaList(rovers)
            }

        })

        viewModel.roverError.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                if (it) {
                    errorMessage.visibility = View.VISIBLE
                } else {
                    errorMessage.visibility = View.GONE
                }
            }
        })

        viewModel.roverLoading.observe(viewLifecycleOwner, Observer { loading ->
            loading?.let {
                if (it) {
                    nasaLoading.visibility = View.VISIBLE
                    nasaLoading.visibility = View.GONE
                    nasaLoading.visibility = View.GONE
                } else {
                    nasaLoading.visibility = View.GONE
                }
            }
        })
    }

    private fun showDialog() {
        val listItems = arrayOf<String>(
                "FHAZ",
                "RHAZ",
                "MAST",
                "CHEMCAM",
                "MAHLI",
                "MARDI",
                "NAVCAM",
                "PANCAM",
                "MINITES"
        )
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Sırala")
        val checkedItem = 0 //this will checked the item when user open the dialog
        builder.setSingleChoiceItems(
                listItems, checkedItem
        ) { dialog, which ->

            if (which == 0) {
                viewModel.getCamera("FHAZ")
                observeLiveCamera()
                dialog.dismiss()
            }

            if (which == 1) {
                viewModel.getCamera("RHAZ")
                observeLiveCamera()
                dialog.dismiss()
            }
            if (which == 2) {
                viewModel.getCamera("MAST")
                observeLiveCamera()
                dialog.dismiss()
            }
            if (which == 3) {
                viewModel.getCamera("CHEMCAM")
                observeLiveCamera()
                dialog.dismiss()

            }
            if (which == 4) {
                viewModel.getCamera("MAHLI")
                observeLiveCamera()
                dialog.dismiss()

            }
            if (which == 5) {
                viewModel.getCamera("MARDI")
                observeLiveCamera()
                dialog.dismiss()

            }
            if (which == 6) {
                viewModel.getCamera("NAVCAM")
                observeLiveCamera()
                dialog.dismiss()

            }
            if (which == 7) {
                viewModel.getCamera("PANCAM")
                observeLiveCamera()
                dialog.dismiss()

            }
            if (which == 8) {
                viewModel.getCamera("MINITES")
                observeLiveCamera()
                dialog.dismiss()

            }

        }
        val dialog=builder.create()
        dialog.show()
    }

    override fun clickable(pos: PhotosItem) {

    }

    private fun observeLiveCamera() {
        viewModel.cameraLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                nasaList.visibility = View.VISIBLE
                nasaAdapter.updateNasaList(it)
            }
        })


    }}