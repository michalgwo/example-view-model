package com.example.exampleviewmodel

import androidx.lifecycle.ViewModel

class MainActivityViewModel(start: Int) : ViewModel() {
    private var count = 0

    init {
        count = start
    }

    fun getCurrentCount(): Int {
        return count
    }

    fun incrementCount(value: Int?) {
        if (value == null)
            return

        count += value
    }
}