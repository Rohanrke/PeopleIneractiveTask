package com.peopleinteractive.data.repository

import com.peopleinteractive.data.local.dao.UserDao
import com.peopleinteractive.data.mapper.RemoteToEntityMapper
import com.peopleinteractive.data.mapper.UserDomainMapper
import com.peopleinteractive.data.mapper.UserEntityMapper
import com.peopleinteractive.data.remote.model.ApiResponse
import com.peopleinteractive.data.remote.service.UserService
import com.peopleinteractive.domain.Entity
import com.peopleinteractive.domain.ResultState
import com.peopleinteractive.domain.entity.User
import com.peopleinteractive.domain.repository.IUserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.lang.Exception

class UserRepositoryImpl(
    private val remote: UserService,
    private val local: UserDao,
    private val remoteMapper: RemoteToEntityMapper,
    private val domainMapper: UserDomainMapper,
    private val entityMapper: UserEntityMapper
) : IUserRepository {
    override suspend fun fetchUsers(resultCount: Int): ResultState<List<User>> {
        return try {
            val apiResponse = remote.fetchUsers()
            local.deleteAll()
            val list = apiResponse.results.map {
                remoteMapper.map(it)
            }
            local.insertList(list)
            ResultState.Success(list.map { domainMapper.map(it) })
        } catch (e: Exception) {
            Timber.e(e)
            val message = e.localizedMessage ?: "error"
            ResultState.Error(error = Entity.Error(message))
        }
    }

    override suspend fun getLocalUsers(): ResultState<List<User>> {
        val list = local.getAllUsers().map {
            domainMapper.map(it)
        }

        return ResultState.Success(list)
    }

    override suspend fun updateUser(user: User) {
        local.update(entityMapper.map(user))
    }
}