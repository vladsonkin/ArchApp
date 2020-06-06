package com.hamedsafari.domain.repositories

import androidx.lifecycle.LiveData
import com.hamedsafari.model.User
import com.hamedsafari.domain.utils.Resource

interface UserRepository {
    suspend fun getTopUsersWithCache(): LiveData<Resource<List<User>>>
    suspend fun getUserDetailWithCache(login: String): LiveData<Resource<User>>
}