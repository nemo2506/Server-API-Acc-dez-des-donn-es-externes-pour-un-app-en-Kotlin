package com.aura.model.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Credentials(
    @SerialName("id") val id: String,
    @SerialName("password") val password: String
)
