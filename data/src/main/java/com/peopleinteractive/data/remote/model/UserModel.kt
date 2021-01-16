package com.peopleinteractive.data.remote.model

data class UserModel(
    val phone: String, val email: String,
    val name: NameModel, val gender: String,
    val location: LocationModel, val cell: String,
    val picture: PictureModel
)