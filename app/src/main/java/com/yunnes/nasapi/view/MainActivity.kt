package com.yunnes.nasapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yunnes.nasapi.R
import com.yunnes.nasapi.adapter.ViewPageAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

               setSupportActionBar(toolbar)
        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(CuriosityFragment(), "Curiosity")
        adapter.addFragment(SpiritFragment(), "Spirit")
        adapter.addFragment(OpportunityFragment(), "Opportunity")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

    }
}