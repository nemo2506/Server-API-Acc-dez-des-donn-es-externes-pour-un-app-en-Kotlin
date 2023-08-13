package com.aura.service

import com.aura.model.balance.BalanceResult
import com.aura.model.login.Credentials
import com.aura.model.login.CredentialsResult
import com.aura.model.transfer.Transfer
import com.aura.model.transfer.TransferResult

interface ApiService {

    fun login(credentials: Credentials): CredentialsResult

    fun balance(id: String): BalanceResult

    fun transfer(transfer: Transfer): TransferResult

}