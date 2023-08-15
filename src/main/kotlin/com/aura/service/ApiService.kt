package com.aura.service

import com.aura.model.Account
import com.aura.model.login.Credentials
import com.aura.model.login.CredentialsResult
import com.aura.model.transfer.Transfer
import com.aura.model.transfer.TransferResult

interface ApiService {

    fun login(credentials: Credentials): CredentialsResult

    fun accounts(id: String): List<Account>

    fun transfer(transfer: Transfer): TransferResult

}