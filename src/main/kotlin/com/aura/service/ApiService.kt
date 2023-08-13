package com.aura.service

import com.aura.model.balance.BalanceResult
import com.aura.model.login.Credentials
import com.aura.model.login.CredentialsResult

interface ApiService {

    fun login(credentials: Credentials): CredentialsResult

    fun balance(id: String): BalanceResult

}