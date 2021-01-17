package com.peopleinteractive.data.mapper

import com.peopleinteractive.data.local.entity.UserEntity
import com.peopleinteractive.data.remote.model.UserModel

class RemoteToEntityMapper {

    fun map(model: UserModel): UserEntity {
        return UserEntity(
            phone = model.phone,
            large = model.picture.large,
            medium = model.picture.medium,
            thumbnail = model.picture.thumbnail,
            email = model.email,
            title = model.name.title,
            first = model.name.first,
            last = model.name.last,
            city = model.location.city,
            state = model.location.state,
            country = model.location.state,
            postCode = model.location.postCode,
            cell = model.cell,
            gender = model.gender
        )
    }
}