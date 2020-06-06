package com.hamedsafari.domain.usecase.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.hamedsafari.domain.repositories.UserRepository
import com.hamedsafari.domain.utils.Resource
import com.hamedsafari.model.User

/**
 * Use case that gets a [Resource] [User] from [UserRepository]
 * and makes some specific logic actions on it.
 *
 * In this Use Case, I'm just doing nothing... ¯\_(ツ)_/¯
 */
class GetUserDetailUseCase(private val repository: UserRepository) {

    suspend operator fun invoke(login: String): LiveData<Resource<User>> {
        return Transformations.map(repository.getUserDetailWithCache(login)) {
            it // Place here your specific logic actions (if any)
        }
    }
}