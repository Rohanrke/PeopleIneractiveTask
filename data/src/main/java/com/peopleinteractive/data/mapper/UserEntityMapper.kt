package com.peopleinteractive.data.mapper

import com.peopleinteractive.data.local.entity.UserEntity
import com.peopleinteractive.domain.entity.User

class UserEntityMapper {
    fun map(user: User): UserEntity {
        return UserEntity(
            phone = user.phone,
            large = user.large,
            medium = user.medium,
            thumbnail = user.thumbnail,
            email = user.email,
            title = user.title,
            first = user.first,
            last = user.last,
            city = user.city,
            state = user.state,
            country = user.state,
            postCode = user.postCode,
            cell = user.cell,
            gender = user.gender
        )
    }
}