package com.aura.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResult<T>(@SerialName("response") val response: T)
