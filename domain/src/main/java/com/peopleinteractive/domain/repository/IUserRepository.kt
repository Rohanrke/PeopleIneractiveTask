package com.peopleinteractive.domain.repository

import com.peopleinteractive.domain.ResultState
import com.peopleinteractive.domain.entity.User

interface IUserRepository {

    suspend fun fetchUsers(resultCount: Int = 10): ResultState<List<User>>

    suspend fun getLocalUsers(): ResultState<List<User>>

    suspend fun updateUser(user: User)
}