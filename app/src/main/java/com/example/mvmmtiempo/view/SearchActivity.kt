package com.example.mvmmtiempo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvmmtiempo.R
import com.example.mvmmtiempo.adapter.LocationAdapter
import com.example.mvmmtiempo.viewmodel.SearchActivityViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchActivityViewModel
    private lateinit var adapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        viewModel = ViewModelProviders.of(this).get(SearchActivityViewModel::class.java)

        iv_search.setOnClickListener {
            if (et_search.text!!.isNotEmpty()) {
                viewModel.searchLocation(et_search.text.toString())
            }
        }

        viewModel.showProgress.observe(this, Observer {
            if (it) {
                search_progress.visibility = VISIBLE
            } else {
                search_progress.visibility = GONE
            }

        })

        viewModel.locationList.observe(this, Observer {
            adapter.setLocation(it)
        })

        adapter = LocationAdapter()
        rv_search.adapter = adapter

    }
}