package com.example.mvp4beginners.remote

interface LoginRepository {
    fun login(
        login: String,
        password: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit)
}