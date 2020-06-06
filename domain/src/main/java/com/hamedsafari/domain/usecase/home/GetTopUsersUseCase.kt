package com.hamedsafari.domain.usecase.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.hamedsafari.domain.repositories.UserRepository
import com.hamedsafari.domain.utils.Resource
import com.hamedsafari.model.User

/**
 * Use case that gets a [Resource][List][User] from [UserRepository]
 * and makes some specific logic actions on it.
 *
 * In this Use Case, I'm just doing nothing... ¯\_(ツ)_/¯
 */
class GetTopUsersUseCase(private val repository: UserRepository) {

    suspend operator fun invoke(): LiveData<Resource<List<User>>> {
        return Transformations.map(repository.getTopUsersWithCache()) {
            it // Place here your specific logic actions
        }
    }
}