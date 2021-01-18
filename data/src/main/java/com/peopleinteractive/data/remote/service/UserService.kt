package com.peopleinteractive.data.remote.service


import com.peopleinteractive.data.remote.model.UserResponse
import retrofit2.http.GET


interface UserService {

    @GET("/api?results=10")
    suspend fun fetchUsers(): UserResponse
}