package com.filkom.mycv2.data

import kotlinx.coroutines.delay

class AuthRepository {
    suspend fun login(email: String, password: String): Boolean {
        delay(800)
        return email.isNotBlank() && password.length >= 6
    }
}
