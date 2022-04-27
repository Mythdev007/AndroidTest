package com.thejan.assessment.androidtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.thejan.assessment.androidtest.R
import com.thejan.assessment.androidtest.databinding.ActivityMainBinding
import com.thejan.assessment.androidtest.viewmodel.MainViewModel
import com.thejan.assessment.androidtest.viewmodel.base.Status
import com.thejan.assessment.androidtest.viewmodel.base.ViewModelState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        actions()
        subscription()
    }

    private fun subscription() {
        viewModel.state.observe(this, {
            it?.let {
                update(it)
            }
        })
    }

    private fun update(state: ViewModelState) {
        when (state.status) {
            Status.SAVED -> {
                binding.tvText.text = viewModel.getSavedValue()
            }

            Status.INVALID -> {
                Toast.makeText(this, getString(R.string.invalid_input), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun actions() {
        binding.btnSave.setOnClickListener {
            viewModel.saveData(binding.etvInput.text.toString())
        }
    }
}