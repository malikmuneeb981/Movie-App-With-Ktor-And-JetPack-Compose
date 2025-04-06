package com.example.cricket.scorrer.ktorprac.Di

import com.example.cricket.scorrer.ktorprac.ApiService.ApiService
import com.example.cricket.scorrer.ktorprac.ApiService.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val KoinModule = module {

    single<HttpClient> {
        HttpClient(OkHttp) {
            // ✅ Content Negotiation (Auto JSON Parsing)
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true // Ignores unknown fields

                    prettyPrint = true       // Makes JSON output readable
                })
            }

            // ✅ Logging (Logs API Calls)
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("KtorLog: $message") // ✅ Check Logcat for this
                    }
                }
                level = LogLevel.ALL // Logs everything (requests, responses, headers, etc.)
            }
        }
    }
    single<ApiService> {
        ApiService(get())
    }
    viewModelOf(::ViewModel)
}