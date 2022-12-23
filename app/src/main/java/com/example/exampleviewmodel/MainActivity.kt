package com.example.exampleviewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.exampleviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val startingValue = 2
        val viewModel: MainActivityViewModel by viewModels { MainActivityViewModelFactory(startingValue) }

        viewModel.countData.observe(this) {
            binding.textView.text = it.toString();
        }

        binding.button.setOnClickListener {
            if (binding.editText.text.isBlank())
                return@setOnClickListener

            viewModel.incrementCount(binding.editText.text.toString().toIntOrNull())
        }
    }
}