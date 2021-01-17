package com.peopleinteractive.data.remote.model

data class ApiResponse<T>(val data: T?, val status: Boolean = false)