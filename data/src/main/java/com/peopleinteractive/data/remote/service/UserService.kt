package com.peopleinteractive.data.remote.service


import com.peopleinteractive.data.remote.model.ApiResponse
import com.peopleinteractive.data.remote.model.UserResponse
import retrofit2.http.GET


interface UserService {

    // https://randomuser.me/api/?results=10@
    @GET("/api?results=10")
    suspend fun fetchUsers(): UserResponse
}