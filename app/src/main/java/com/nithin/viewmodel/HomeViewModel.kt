package com.nithin.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel(){


    var backgroundColor by mutableStateOf(Color.LightGray)
        private set

    fun changeBackgroundColor() {
        backgroundColor = Color.Green
    }

}