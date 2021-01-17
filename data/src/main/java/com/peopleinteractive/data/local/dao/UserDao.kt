package com.peopleinteractive.data.local.dao

import androidx.room.*
import com.peopleinteractive.data.local.entity.UserEntity


@Dao
interface UserDao {

    @Insert
    fun insert(userEntity: UserEntity)

    @Update
    fun update(userEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<UserEntity>)

    @Query("SELECT * FROM user ORDER BY phone DESC")
    fun getAllUsers(): List<UserEntity>
}