package com.peopleinteractive.data.remote.service

import com.peopleinteractive.data.remote.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {

    // https://randomuser.me/api/?results=10@
    @GET("/api?results=10")
    suspend fun fetchUsers(): ApiResponse?
}