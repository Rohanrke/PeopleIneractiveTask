package com.peopleinteractive.data.repository

import com.peopleinteractive.data.local.dao.UserDao
import com.peopleinteractive.data.mapper.RemoteToEntityMapper
import com.peopleinteractive.data.mapper.UserDomainMapper
import com.peopleinteractive.data.mapper.UserEntityMapper
import com.peopleinteractive.data.remote.service.UserService
import com.peopleinteractive.domain.Entity
import com.peopleinteractive.domain.ResultState
import com.peopleinteractive.domain.entity.User
import com.peopleinteractive.domain.repository.IUserRepository

class UserRepositoryImpl(
    private val remote: UserService,
    private val local: UserDao,
    private val remoteMapper: RemoteToEntityMapper,
    private val domainMapper: UserDomainMapper,
    private val entityMapper: UserEntityMapper
) : IUserRepository {
    override suspend fun fetchUsers(resultCount: Int): ResultState<List<User>> {
        val result = remote.fetchUsers()
        if (result != null && !result.results.isNullOrEmpty()) {

            val list = result.results.map {
                remoteMapper.map(it)
            }
            local.insertList(list)
            return ResultState.Success(list.map { domainMapper.map(it) })
        }
        val message = "error"
        return ResultState.Error(error = Entity.Error(message))

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