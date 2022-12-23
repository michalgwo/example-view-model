package com.example.exampleviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(start: Int) : ViewModel() {
    private var count = MutableLiveData<Int>()
    val countData: LiveData<Int>
        get() = count

    init {
        count.value = start
    }

    fun incrementCount(value: Int?) {
        if (value == null)
            return

        count.value = count.value?.plus(value)
    }
}