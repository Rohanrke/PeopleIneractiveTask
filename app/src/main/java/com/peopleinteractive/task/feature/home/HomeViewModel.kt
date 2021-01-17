package com.peopleinteractive.task.feature.home

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.peopleinteractive.core.presentation.BaseViewModel
import com.peopleinteractive.core.presentation.ProgressState
import com.peopleinteractive.domain.ResultState
import com.peopleinteractive.domain.entity.User
import com.peopleinteractive.domain.repository.IUserRepository
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val context: CoroutineContext,
    private val repository: IUserRepository
) : BaseViewModel() {


    private val _userListLiveData = MutableLiveData<List<User>>()
    val userListLiveData: LiveData<List<User>>
        get() = _userListLiveData

    fun fetchUsers() {
        viewModelScope.launch(context) {
            _state.postValue(ProgressState.LOADING)
            val result = repository.getLocalUsers()
            if (result is ResultState.Success) {
                if (result.data.isNotEmpty()) {
                    _userListLiveData.postValue(result.data)
                    _state.postValue(ProgressState.SUCCESS)
                } else {
                    val res = repository.fetchUsers()
                    if (res is ResultState.Success) {
                        _userListLiveData.postValue(res.data)
                        _state.postValue(ProgressState.SUCCESS)
                    }

                }
            }
        }
    }

}