package com.peopleinteractive.domain.entity

data class User(
    val phone: String, val large: String, val medium: String, val thumbnail: String,
    val email: String, val gender: String, val cell: String, val title: String,
    val first: String, val last: String, val city: String, val state: String, val country: String,
    val postCode: String
)