package com.example.harakaway.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    private val _searchInput = mutableStateOf("")
    val searchInput: State<String> = _searchInput

    fun onSearchInputChange(newValue: String){
        _searchInput.value = newValue
    }
}