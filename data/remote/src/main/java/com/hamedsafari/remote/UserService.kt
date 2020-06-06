package com.hamedsafari.remote

import com.hamedsafari.model.ApiResult
import com.hamedsafari.model.User
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {

    @GET("search/users")
    suspend fun fetchTopUsersAsync(@Query("q") query: String = "hamed",
                           @Query("sort") sort: String = "followers"): ApiResult<User>

    @GET("users/{login}")
    suspend fun fetchUserDetailsAsync(@Path("login") login: String): User
}