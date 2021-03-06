package com.example.mvmmtiempo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvmmtiempo.R
import com.example.mvmmtiempo.viewmodel.DetailsActivityViewModel

import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var viewModel:DetailsActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        viewModel = ViewModelProviders.of(this).get(DetailsActivityViewModel::class.java)


        if (intent.hasExtra("name")) {
            tv_location.text = intent.getStringExtra("name")
        }

        if (intent.hasExtra("Location")) {
            // Do network call
            val location = intent.getIntExtra("Location",0)

            if (location > 0) {
                viewModel.getWheater(location)
            }
        }

        viewModel.showProgress.observe(this,Observer {
            if(it){
                details_progress.visibility = VISIBLE
            }
            else{
                details_progress.visibility = GONE
            }
        })


        viewModel.response.observe(this, Observer {
            if(it!=null){
                tv_temp.text = it.consolidated_weather[0].the_temp.toString()
            }
        })
    }
}