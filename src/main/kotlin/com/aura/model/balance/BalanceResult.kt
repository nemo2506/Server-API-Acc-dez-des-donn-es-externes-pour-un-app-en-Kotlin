package com.aura.model.balance

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BalanceResult(
    @SerialName("amount") val id: Double?
)
