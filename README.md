# CurrencyCore SDK for Kotlin & Java (Android / JVM)

Official client for the [CurrencyCore](https://currency-core.com) API — currency
conversion, FX rates, PPP, and analytics. Usable from Java as well as Kotlin.

Generated from the CurrencyCore OpenAPI 3.1 spec with
[OpenAPI Generator](https://openapi-generator.tech) (`kotlin`, OkHttp), plus a
thin `CurrencyCore.client()` helper for API-key and version handling.

## Install (Gradle, via JitPack)

```kotlin
repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.CurrencyCore:currencycore-kotlin:0.1.0")
}
```

## Quickstart

```kotlin
import com.currencycore.sdk.CurrencyCore

val api = CurrencyCore.client(apiKey = "cc_live_...") // or set CURRENCYCORE_API_KEY
val res = api.convert(from = "USD", to = "EUR", amount = java.math.BigDecimal(100))
println(res.results.first())
```

Public reference endpoints need no key:

```kotlin
val api = CurrencyCore.client()
println(api.currencies())
```

## API key

`CurrencyCore.client()` resolves the key as `apiKey` → `CURRENCYCORE_API_KEY`.
On Android, **never embed a secret key in the APK** — proxy requests through
your backend or use a short-lived token.

## API version

Base URL is `https://api.currency-core.com/{version}` (default `v1`):

```kotlin
CurrencyCore.client(version = "v1")
CurrencyCore.client(baseUrl = "https://api.currency-core.com/v1")
```

## Regenerate

The committed `openapi.json` is the source of truth:

```bash
bash scripts/generate.sh
```

Hand-written files (`src/main/kotlin/com/currencycore/sdk/Client.kt`, this README)
are protected by `.openapi-generator-ignore`.

## License

MIT
