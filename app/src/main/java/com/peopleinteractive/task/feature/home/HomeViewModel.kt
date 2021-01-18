package com.peopleinteractive.task.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.peopleinteractive.core.presentation.BaseViewModel
import com.peopleinteractive.core.presentation.ProgressState
import com.peopleinteractive.core.utils.SystemUtils
import com.peopleinteractive.domain.ResultState
import com.peopleinteractive.domain.entity.User
import com.peopleinteractive.domain.repository.IUserRepository
import com.peopleinteractive.task.R
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val context: CoroutineContext,
    private val repository: IUserRepository,
    private val systemUtils: SystemUtils
) : BaseViewModel() {

    private val _userListLiveData = MutableLiveData<List<User>>()
    val userListLiveData: LiveData<List<User>>
        get() = _userListLiveData

    private val _refreshed = MutableLiveData<Boolean>(false)
    val refreshed: LiveData<Boolean>
        get() = _refreshed

    fun fetchUsers() {
        viewModelScope.launch(context) {
            _state.postValue(ProgressState.LOADING)
            val result = repository.getLocalUsers()
            if (result is ResultState.Success) {
                if (result.data.isNotEmpty()) {
                    _userListLiveData.postValue(result.data)
                    _state.postValue(ProgressState.SUCCESS)
                } else if (systemUtils.isNetworkAvailable()) {
                    val res = repository.fetchUsers()
                    if (res is ResultState.Success) {
                        _userListLiveData.postValue(res.data)
                        _state.postValue(ProgressState.SUCCESS)
                    }
                } else {
                    _messageRes.postValue(R.string.no_network)
                }
            } else if (result is ResultState.Error) {
                _errorMessage.postValue(result.error.errorMessage)
            }
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(context) {
            repository.updateUser(user)
        }
    }

    fun refresh() {
        viewModelScope.launch(context) {
            if (systemUtils.isNetworkAvailable()) {
                val res = repository.fetchUsers()
                if (res is ResultState.Success) {
                    _userListLiveData.postValue(res.data)
                }else if (res is ResultState.Error){
                    _errorMessage.postValue(res.error.errorMessage)
                }
            } else {

                _messageRes.postValue(R.string.no_network)
            }
            _refreshed.postValue(false)
        }
    }
}