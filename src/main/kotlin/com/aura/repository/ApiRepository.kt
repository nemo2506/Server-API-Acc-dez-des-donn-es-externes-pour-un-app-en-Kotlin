package com.aura.repository

import com.aura.model.balance.BalanceResult
import com.aura.model.login.Credentials
import com.aura.model.login.CredentialsResult
import com.aura.service.ApiService
import com.aura.service.LocalApiService

object ApiRepository: ApiService {

    private val apiService: ApiService = LocalApiService()

    override fun login(credentials: Credentials): CredentialsResult {
        return apiService.login(credentials)
    }

    override fun balance(id: String): BalanceResult {
        return apiService.balance(id)
    }

}