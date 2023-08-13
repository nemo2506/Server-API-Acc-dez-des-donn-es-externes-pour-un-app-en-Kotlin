package com.aura.model.transfer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TransferResult(
    @SerialName("done") val granted: Boolean,
)
