package com.kiwicorp.sleeptracker.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kiwicorp.sleeptracker.R
import com.kiwicorp.sleeptracker.databinding.ActivityMainBinding
import com.kiwicorp.sleeptracker.service.PickUpService
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainActivityViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startService(Intent(this, PickUpService::class.java))

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            pickUpRecyclerView.adapter = PickUpsListAdapter(viewModel)
            viewmodel = viewModel
            lifecycleOwner = this@MainActivity
            toolbar.inflateMenu(R.menu.main_activity)
            toolbar.setOnMenuItemClickListener {
                if (it.itemId == R.id.menu_delete) {
                    viewModel.deletePickUps()
                    true
                } else {
                    false
                }
            }
        }
    }
}