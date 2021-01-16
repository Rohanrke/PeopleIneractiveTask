package com.peopleinteractive.core.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    protected val _state = MutableLiveData<ProgressState>()
    val state: LiveData<ProgressState>
        get() = _state

    fun runInBackground(execute: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            execute.invoke()
        }
    }

    protected val _messageRes = MutableLiveData<Int>()
    val messageRes: LiveData<Int>
        get() = _messageRes

    fun runOnMain(execute: () -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            execute.invoke()
        }
    }
}