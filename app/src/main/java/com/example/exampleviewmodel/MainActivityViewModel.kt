package com.example.exampleviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(start: Int) : ViewModel() {
    private var count = MutableLiveData<Int>()
    val countData: LiveData<Int>
        get() = count

    var countInput = MutableLiveData<String>()

    init {
        count.value = start
    }

    fun incrementCount() {
        val countInputInt = countInput.value?.toIntOrNull() ?: return

        count.value = count.value?.plus(countInputInt)
    }
}