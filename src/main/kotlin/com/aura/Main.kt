package com.aura

import com.aura.model.login.Credentials
import com.aura.model.transfer.Transfer
import com.aura.repository.ApiRepository
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }

        install(CORS) {
            anyHost()
            allowHeader(HttpHeaders.ContentType)
        }

        routing {
            post("/login") {
                val credentials = call.receive<Credentials>()
                call.respond(ApiRepository.login(credentials))
            }

            get("/balance/{id}") {
                val id = call.parameters["id"] ?: throw IllegalArgumentException("Missing id path params")
                call.respond(ApiRepository.balance(id))
            }

            post("transfer") {
                val transfer = call.receive<Transfer>()
                call.respond(ApiRepository.transfer(transfer))
            }

            swaggerUI(path = "swagger", swaggerFile = "openapi/documentation.yaml")
        }
    }.start(wait = true)
}