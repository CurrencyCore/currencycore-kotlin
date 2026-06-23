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
    implementation("com.github.CurrencyCore:currencycore-kotlin:0.1.1")
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

## Endpoints

All 14 endpoints are methods on the `api` client. `*` marks a required argument; the rest are optional. **Public** = no key; **Free** = any plan with a key; **Growth** = Growth plan or higher.

| Endpoint | Call | Plan |
| --- | --- | --- |
| Convert an amount (optional PPP) | `api.convert(from*, to*, amount, ppp, date)` | Free |
| Rate snapshot for a date (USD base) | `api.rates(date)` | Free |
| Rate snapshot in any base | `api.ratesByBase(base*, date)` | Free |
| One currency's daily time series | `api.history(currency*, from, to, base, interval)` | Growth |
| Trends, comparisons & movers | `api.historyAnalysis(base, currencies, from, to, period, sort, assetClass, limit, interval, stats)` | Growth |
| PPP factor over time / movers | `api.pppAnalysis(countries, from, to, period, sort, limit, stats)` | Growth |
| Volatility or stability ranking | `api.volatility(currency, base, from, to, sort, universe, limit)` | Growth |
| Return correlation vs a base | `api.correlation(currencies*, base, from, to)` | Growth |
| Max drawdown or ranking | `api.drawdown(currency, base, from, to, sort, universe, limit)` | Growth |
| Safe-haven score ranking | `api.safeHaven(currencies, base, from, to, limit)` | Growth |
| Mean-reversion ranking | `api.meanReversion(currencies, base, from, to, limit)` | Growth |
| Supported countries + currencies | `api.countries()` | Public |
| Supported ISO 4217 currencies | `api.currencies()` | Public |
| Natural-language question | `api.ai(q*)` | Free |

More calls:

```kotlin
api.rates()                                          // latest snapshot (USD base)
api.ratesByBase(base = "EUR")                        // same snapshot, EUR base
api.history(currency = "INR", from = "2024-01-01")
api.volatility(universe = "majors", sort = "volatile")
api.ai(q = "How has the rupee moved this year?")
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
