package com.currencycore.sdk

import com.currencycore.sdk.apis.CurrencyCoreApi
import com.currencycore.sdk.infrastructure.ApiClient

/** Environment-aware factory for [CurrencyCoreApi]. */
object CurrencyCore {
    private const val DEFAULT_HOST = "https://api.currency-core.com"

    /**
     * Build a [CurrencyCoreApi]. Resolves the API key as [apiKey] ->
     * `CURRENCYCORE_API_KEY` and the base URL as [baseUrl] ->
     * `CURRENCYCORE_BASE_URL` -> the public host with [version]. Omit the key
     * for the public reference endpoints.
     */
    fun client(
        apiKey: String? = System.getenv("CURRENCYCORE_API_KEY"),
        baseUrl: String? = System.getenv("CURRENCYCORE_BASE_URL"),
        version: String = "v1",
    ): CurrencyCoreApi {
        apiKey?.let { ApiClient.accessToken = it }
        return CurrencyCoreApi(basePath = baseUrl ?: "$DEFAULT_HOST/$version")
    }
}
