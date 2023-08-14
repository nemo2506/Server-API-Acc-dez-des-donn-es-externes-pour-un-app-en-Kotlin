package com.aura.service

import com.aura.model.User
import com.aura.model.balance.BalanceResult
import com.aura.model.login.Credentials
import com.aura.model.login.CredentialsResult
import com.aura.model.transfer.Transfer
import com.aura.model.transfer.TransferResult

class LocalApiService : ApiService {

    private val users = listOf(
        User("1234", "Pierre", "Brisette", "p@sswOrd", 2354.23),
        User("5678", "Gustave", "Charbonneau", "T0pSecr3t", 521.36)
    )

    override fun login(credentials: Credentials): CredentialsResult {
        val user = getUserById(credentials.id)
        return CredentialsResult(user?.password == credentials.password)
    }

    override fun balance(id: String): BalanceResult {
        val user = getUserById(id)
        return BalanceResult(user?.balance)
    }

    override fun transfer(transfer: Transfer): TransferResult {
        val sender = getUserById(transfer.senderId) ?: throw IllegalArgumentException("The sender cannot be found")
        val recipient = getUserById(transfer.recipientId) ?: throw IllegalArgumentException("The recipient cannot be found")

        if( transfer.amount < 0 ) {
            throw IllegalArgumentException("The amount to send cannot be negative")
        }

        return if(sender.balance - transfer.amount < 0)
        {
            TransferResult(false)
        }
        else {
            sender.balance -= transfer.amount
            recipient.balance += transfer.amount

            TransferResult(true)
        }
    }

    private fun getUserById(id: String): User? {
        return users.firstOrNull { it.id == id }
    }

}