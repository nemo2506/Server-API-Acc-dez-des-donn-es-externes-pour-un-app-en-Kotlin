package com.aura.service

import com.aura.model.User
import com.aura.model.balance.BalanceResult
import com.aura.model.login.Credentials
import com.aura.model.login.CredentialsResult

class LocalApiService : ApiService {
    override fun login(credentials: Credentials): CredentialsResult {
        val user = getUserById(credentials.id)
        return CredentialsResult(user?.password == credentials.password)
    }

    override fun balance(id: String): BalanceResult {
        val user = getUserById(id)
        return BalanceResult(user?.balance)
    }

    private fun getUserById(id: String): User? {
        return getAllUsers().firstOrNull { it.id == id }
    }

    private fun getAllUsers(): List<User> {
        return listOf(
            User("1234", "Pierre", "Brisette", "p@sswOrd", 2354.23),
            User("5678", "Gustave", "Charbonneau", "T0pSecr3t", 521.36)
        )
    }

}