package com.peopleinteractive.data.mapper

import com.peopleinteractive.data.local.entity.UserEntity
import com.peopleinteractive.domain.entity.User

class UserDomainMapper {
    fun map(entity: UserEntity): User {
        return User(
            phone = entity.phone,
            large = entity.large,
            medium = entity.medium,
            thumbnail = entity.thumbnail,
            email = entity.email,
            title = entity.title,
            first = entity.first,
            last = entity.last,
            city = entity.city,
            state = entity.state,
            country = entity.state,
            postCode = entity.postCode,
            cell = entity.cell,
            gender = entity.gender,
            isAccepted = entity.isAccepted,
            isDeclined = entity.isDeclined
        )
    }
}