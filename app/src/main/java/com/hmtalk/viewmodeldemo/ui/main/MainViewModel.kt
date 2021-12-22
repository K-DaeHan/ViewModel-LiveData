package com.hmtalk.viewmodeldemo.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val usd_to_eu_rate = 0.74f
    private var dollarText = ""
    // private var result: Float = 0f
    private var result: MutableLiveData<Float> = MutableLiveData()

    fun setAmount(value: String) {
        Log.d("test", "setAmount")
        this.dollarText = value
        // result = value.toFloat() * usd_to_eu_rate
        result.setValue(value.toFloat() * usd_to_eu_rate)
    } // setAmount

    fun getResult(): /*Float*/ MutableLiveData<Float> {
        Log.d("test", "getResult")
        return result
    } // getResult
}
