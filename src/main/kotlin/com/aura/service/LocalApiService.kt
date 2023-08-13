package com.aura.service

import com.aura.model.ApiResult
import com.aura.model.User
import com.aura.model.login.Credentials
import com.aura.model.login.CredentialsResult

class LocalApiService : ApiService {
    override fun login(credentials: Credentials): ApiResult<CredentialsResult> {
        val user = getUserById(credentials.id)

        return if(user != null)
        {
            if(user.password == credentials.password) {
                ApiResult(CredentialsResult(true))
            }
            else {
                ApiResult(CredentialsResult(false))
            }
        }
        else
        {
            ApiResult(CredentialsResult(false))
        }
    }

    private fun getUserById(id: String): User? {
        return getAllUsers().firstOrNull { it.id == id }
    }

    private fun getAllUsers(): List<User> {
        return listOf(
            User("1234", "Pierre", "Brisette", "p@sswOrd"),
            User("5678", "Gustave", "Charbonneau", "T0pSecr3t")
        )
    }

}