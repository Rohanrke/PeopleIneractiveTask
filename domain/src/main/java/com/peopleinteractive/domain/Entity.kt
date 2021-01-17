package com.peopleinteractive.domain

sealed class Entity {
    data class Error(val errorMessage: String) : Entity()
}