# CurrencyCoreApi

All URIs are relative to *https://api.currency-core.com/v1*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**ai**](CurrencyCoreApi.md#ai) | **GET** /ai | AI |
| [**convert**](CurrencyCoreApi.md#convert) | **GET** /convert | Convert |
| [**correlation**](CurrencyCoreApi.md#correlation) | **GET** /correlation | Correlation |
| [**countries**](CurrencyCoreApi.md#countries) | **GET** /countries | Countries |
| [**currencies**](CurrencyCoreApi.md#currencies) | **GET** /currencies | Currencies |
| [**drawdown**](CurrencyCoreApi.md#drawdown) | **GET** /drawdown | Drawdown |
| [**history**](CurrencyCoreApi.md#history) | **GET** /history | History |
| [**historyAnalysis**](CurrencyCoreApi.md#historyAnalysis) | **GET** /history/analysis | History analysis |
| [**meanReversion**](CurrencyCoreApi.md#meanReversion) | **GET** /mean-reversion | Mean reversion |
| [**pppAnalysis**](CurrencyCoreApi.md#pppAnalysis) | **GET** /ppp/analysis | PPP analysis |
| [**rates**](CurrencyCoreApi.md#rates) | **GET** /rates | Rates |
| [**ratesByBase**](CurrencyCoreApi.md#ratesByBase) | **GET** /rates/{base} | Rates by base |
| [**safeHaven**](CurrencyCoreApi.md#safeHaven) | **GET** /safe-haven | Safe haven |
| [**volatility**](CurrencyCoreApi.md#volatility) | **GET** /volatility | Volatility |


<a id="ai"></a>
# **ai**
> AiResponse ai(q)

AI

Ask a natural-language currency question; the model answers using live rates.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
val q : kotlin.String = Convert 50 euro to indian rupees // kotlin.String | A natural-language question, e.g. \"Convert 50 euro to indian rupees\" or \"What's the USD to EUR rate today?\".
try {
    val result : AiResponse = apiInstance.ai(q)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#ai")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#ai")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **q** | **kotlin.String**| A natural-language question, e.g. \&quot;Convert 50 euro to indian rupees\&quot; or \&quot;What&#39;s the USD to EUR rate today?\&quot;. | |

### Return type

[**AiResponse**](AiResponse.md)

### Authorization


Configure bearerAuth statically:
```kotlin
ApiClient.accessToken = ""
```
Configure bearerAuth dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="convert"></a>
# **convert**
> ConvertResponse convert(from, to, amount, ppp, date)

Convert

Convert an amount between currencies, optionally PPP-adjusted.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
val from : kotlin.String = USD // kotlin.String | Source currency (ISO 4217), e.g. USD. For PPP (ppp=true) pair it with a country as CUR:COUNTRY, e.g. USD:USA.
val to : kotlin.String = EUR,INR // kotlin.String | One or more target currencies, comma-separated, e.g. EUR,INR (max 25). For PPP use CUR:COUNTRY pairs, e.g. EUR:DEU,INR:IND.
val amount : java.math.BigDecimal = 100 // java.math.BigDecimal | Amount to convert. Optional, defaults to 1 (so each result equals the rate).
val ppp : kotlin.Boolean = false // kotlin.Boolean | When true, apply a PPP adjustment. Every currency must then carry a country code.
val date : kotlin.String = date_example // kotlin.String | Rate date in YYYY-MM-DD (UTC). Must not be in the future. Defaults to latest.
try {
    val result : ConvertResponse = apiInstance.convert(from, to, amount, ppp, date)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#convert")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#convert")
    e.printStackTrace()
}
```

### Parameters
| **from** | **kotlin.String**| Source currency (ISO 4217), e.g. USD. For PPP (ppp&#x3D;true) pair it with a country as CUR:COUNTRY, e.g. USD:USA. | |
| **to** | **kotlin.String**| One or more target currencies, comma-separated, e.g. EUR,INR (max 25). For PPP use CUR:COUNTRY pairs, e.g. EUR:DEU,INR:IND. | |
| **amount** | **java.math.BigDecimal**| Amount to convert. Optional, defaults to 1 (so each result equals the rate). | [optional] |
| **ppp** | **kotlin.Boolean**| When true, apply a PPP adjustment. Every currency must then carry a country code. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **date** | **kotlin.String**| Rate date in YYYY-MM-DD (UTC). Must not be in the future. Defaults to latest. | [optional] |

### Return type

[**ConvertResponse**](ConvertResponse.md)

### Authorization


Configure bearerAuth statically:
```kotlin
ApiClient.accessToken = ""
```
Configure bearerAuth dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="correlation"></a>
# **correlation**
> CorrelationResponse correlation(currencies, base, from, to)

Correlation

Correlation of each currency&#39;s daily returns with a base currency&#39;s, over a window. Growth plan or higher.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
val currencies : kotlin.String = GBP,CHF,SEK // kotlin.String | Comma-separated currencies to correlate with `base`, e.g. GBP,CHF,SEK.
val base : kotlin.String = EUR // kotlin.String | Reference currency to correlate against (3-letter ISO 4217). Defaults to USD (a non-USD base is more meaningful).
val from : kotlin.String = from_example // kotlin.String | Window start YYYY-MM-DD (UTC). Defaults to 365 days before `to`.
val to : kotlin.String = to_example // kotlin.String | Window end YYYY-MM-DD (UTC). Defaults to today.
try {
    val result : CorrelationResponse = apiInstance.correlation(currencies, base, from, to)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#correlation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#correlation")
    e.printStackTrace()
}
```

### Parameters
| **currencies** | **kotlin.String**| Comma-separated currencies to correlate with &#x60;base&#x60;, e.g. GBP,CHF,SEK. | |
| **base** | **kotlin.String**| Reference currency to correlate against (3-letter ISO 4217). Defaults to USD (a non-USD base is more meaningful). | [optional] |
| **from** | **kotlin.String**| Window start YYYY-MM-DD (UTC). Defaults to 365 days before &#x60;to&#x60;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **to** | **kotlin.String**| Window end YYYY-MM-DD (UTC). Defaults to today. | [optional] |

### Return type

[**CorrelationResponse**](CorrelationResponse.md)

### Authorization


Configure bearerAuth statically:
```kotlin
ApiClient.accessToken = ""
```
Configure bearerAuth dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="countries"></a>
# **countries**
> kotlin.collections.List&lt;CountriesResponseInner&gt; countries()

Countries

The supported countries and their official currencies. Public, no key needed.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
try {
    val result : kotlin.collections.List<CountriesResponseInner> = apiInstance.countries()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#countries")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#countries")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;CountriesResponseInner&gt;**](CountriesResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="currencies"></a>
# **currencies**
> kotlin.collections.List&lt;CurrenciesResponseInner&gt; currencies()

Currencies

The full list of supported ISO 4217 currencies. Use it to resolve a name or symbol to its code, or to check whether a currency is supported (so a missing one fails clearly, not silently). Public, no key needed.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
try {
    val result : kotlin.collections.List<CurrenciesResponseInner> = apiInstance.currencies()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#currencies")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#currencies")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;CurrenciesResponseInner&gt;**](CurrenciesResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="drawdown"></a>
# **drawdown**
> DrawdownResponse drawdown(currency, base, from, to, sort, universe, limit)

Drawdown

Maximum peak-to-trough decline vs a base (with peak/trough/recovery), or a drawdown ranking. Growth plan or higher.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
val currency : kotlin.String = EUR // kotlin.String | Currency to measure (3-letter ISO 4217), or a comma-separated list. OMIT to RANK the liquid set by drawdown.
val base : kotlin.String = USD // kotlin.String | Base currency to measure against (3-letter ISO 4217). Defaults to USD.
val from : kotlin.String = from_example // kotlin.String | Window start YYYY-MM-DD (UTC). Defaults to 365 days before `to`.
val to : kotlin.String = to_example // kotlin.String | Window end YYYY-MM-DD (UTC). Defaults to today.
val sort : kotlin.String = deepest // kotlin.String | Ranking direction: deepest (largest decline first, default) or recovery (fastest recovery first).
val universe : kotlin.String = liquid // kotlin.String | Ranking universe: liquid (default) or majors.
val limit : java.math.BigDecimal = 10 // java.math.BigDecimal | Ranking: how many to return (default 10, max 50).
try {
    val result : DrawdownResponse = apiInstance.drawdown(currency, base, from, to, sort, universe, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#drawdown")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#drawdown")
    e.printStackTrace()
}
```

### Parameters
| **currency** | **kotlin.String**| Currency to measure (3-letter ISO 4217), or a comma-separated list. OMIT to RANK the liquid set by drawdown. | [optional] |
| **base** | **kotlin.String**| Base currency to measure against (3-letter ISO 4217). Defaults to USD. | [optional] |
| **from** | **kotlin.String**| Window start YYYY-MM-DD (UTC). Defaults to 365 days before &#x60;to&#x60;. | [optional] |
| **to** | **kotlin.String**| Window end YYYY-MM-DD (UTC). Defaults to today. | [optional] |
| **sort** | **kotlin.String**| Ranking direction: deepest (largest decline first, default) or recovery (fastest recovery first). | [optional] |
| **universe** | **kotlin.String**| Ranking universe: liquid (default) or majors. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **limit** | **java.math.BigDecimal**| Ranking: how many to return (default 10, max 50). | [optional] |

### Return type

[**DrawdownResponse**](DrawdownResponse.md)

### Authorization


Configure bearerAuth statically:
```kotlin
ApiClient.accessToken = ""
```
Configure bearerAuth dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="history"></a>
# **history**
> HistoryResponse history(currency, from, to, base, interval)

History

A single currency&#39;s daily rate time series over a date range. Growth plan or higher.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
val currency : kotlin.String = INR // kotlin.String | The currency whose history to fetch (3-letter ISO 4217), e.g. INR. One currency per call.
val from : kotlin.String = from_example // kotlin.String | Start date YYYY-MM-DD (UTC). Defaults to 7 days before `to`.
val to : kotlin.String = to_example // kotlin.String | End date YYYY-MM-DD (UTC). Defaults to today; a future date clamps to today.
val base : kotlin.String = USD // kotlin.String | Base currency the rates are expressed against (3-letter ISO 4217). Defaults to USD.
val interval : kotlin.String = daily // kotlin.String | Aggregation: daily (default), weekly, monthly, or yearly. Coarser intervals average the daily rates per bucket (weekly key = the week's Monday, monthly = YYYY-MM, yearly = YYYY).
try {
    val result : HistoryResponse = apiInstance.history(currency, from, to, base, interval)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#history")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#history")
    e.printStackTrace()
}
```

### Parameters
| **currency** | **kotlin.String**| The currency whose history to fetch (3-letter ISO 4217), e.g. INR. One currency per call. | |
| **from** | **kotlin.String**| Start date YYYY-MM-DD (UTC). Defaults to 7 days before &#x60;to&#x60;. | [optional] |
| **to** | **kotlin.String**| End date YYYY-MM-DD (UTC). Defaults to today; a future date clamps to today. | [optional] |
| **base** | **kotlin.String**| Base currency the rates are expressed against (3-letter ISO 4217). Defaults to USD. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **interval** | **kotlin.String**| Aggregation: daily (default), weekly, monthly, or yearly. Coarser intervals average the daily rates per bucket (weekly key &#x3D; the week&#39;s Monday, monthly &#x3D; YYYY-MM, yearly &#x3D; YYYY). | [optional] |

### Return type

[**HistoryResponse**](HistoryResponse.md)

### Authorization


Configure bearerAuth statically:
```kotlin
ApiClient.accessToken = ""
```
Configure bearerAuth dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="historyAnalysis"></a>
# **historyAnalysis**
> HistoryAnalysisResponse historyAnalysis(base, currencies, from, to, period, sort, assetClass, limit, interval, stats)

History analysis

Trends, comparisons &amp; &#39;movers&#39;: % change, strength, and min/max/avg over a window. Growth plan or higher.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
val base : kotlin.String = USD // kotlin.String | Currency everything is measured against (3-letter ISO 4217). Defaults to USD.
val currencies : kotlin.String = GBP,EUR,AED // kotlin.String | Comma-separated currencies to compare, e.g. GBP,EUR,AED. OMIT to rank ALL currencies vs base ('movers' mode).
val from : kotlin.String = from_example // kotlin.String | Window start YYYY-MM-DD (UTC). Defaults to 20 years (2 decades) before `to`. See `period` for a shorthand.
val to : kotlin.String = to_example // kotlin.String | Window end YYYY-MM-DD (UTC). Defaults to today; a future date clamps to today.
val period : kotlin.String = 10y // kotlin.String | Relative window shorthand for `from`: e.g. 10y, 6m, 30d, ytd, max. Ignored if `from` is given.
val sort : kotlin.String = strengthened // kotlin.String | Movers ranking: strengthened (default) or weakened.
val assetClass : kotlin.String = fiat // kotlin.String | Movers universe: fiat (default, the liquid tradeable currencies), metals (XAU/XAG/XPT/XPD), or all (every currency incl. illiquid/frontier). fiat excludes metals/synthetics + illiquid frontier codes; redenomination artifacts are always dropped.
val limit : java.math.BigDecimal = 10 // java.math.BigDecimal | Movers: how many top results to return (default 10, max 200).
val interval : kotlin.String = yearly // kotlin.String | Attach a trend series per named currency: weekly, monthly, or yearly (compare mode only).
val stats : kotlin.Boolean = true // kotlin.Boolean | Include min/max/avg over the window per currency. Defaults to true; pass false to skip.
try {
    val result : HistoryAnalysisResponse = apiInstance.historyAnalysis(base, currencies, from, to, period, sort, assetClass, limit, interval, stats)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#historyAnalysis")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#historyAnalysis")
    e.printStackTrace()
}
```

### Parameters
| **base** | **kotlin.String**| Currency everything is measured against (3-letter ISO 4217). Defaults to USD. | [optional] |
| **currencies** | **kotlin.String**| Comma-separated currencies to compare, e.g. GBP,EUR,AED. OMIT to rank ALL currencies vs base (&#39;movers&#39; mode). | [optional] |
| **from** | **kotlin.String**| Window start YYYY-MM-DD (UTC). Defaults to 20 years (2 decades) before &#x60;to&#x60;. See &#x60;period&#x60; for a shorthand. | [optional] |
| **to** | **kotlin.String**| Window end YYYY-MM-DD (UTC). Defaults to today; a future date clamps to today. | [optional] |
| **period** | **kotlin.String**| Relative window shorthand for &#x60;from&#x60;: e.g. 10y, 6m, 30d, ytd, max. Ignored if &#x60;from&#x60; is given. | [optional] |
| **sort** | **kotlin.String**| Movers ranking: strengthened (default) or weakened. | [optional] |
| **assetClass** | **kotlin.String**| Movers universe: fiat (default, the liquid tradeable currencies), metals (XAU/XAG/XPT/XPD), or all (every currency incl. illiquid/frontier). fiat excludes metals/synthetics + illiquid frontier codes; redenomination artifacts are always dropped. | [optional] |
| **limit** | **java.math.BigDecimal**| Movers: how many top results to return (default 10, max 200). | [optional] |
| **interval** | **kotlin.String**| Attach a trend series per named currency: weekly, monthly, or yearly (compare mode only). | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **stats** | **kotlin.Boolean**| Include min/max/avg over the window per currency. Defaults to true; pass false to skip. | [optional] |

### Return type

[**HistoryAnalysisResponse**](HistoryAnalysisResponse.md)

### Authorization


Configure bearerAuth statically:
```kotlin
ApiClient.accessToken = ""
```
Configure bearerAuth dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="meanReversion"></a>
# **meanReversion**
> MeanReversionResponse meanReversion(currencies, base, from, to, limit)

Mean reversion

Ranks currencies by how strongly they revert to their mean (crossing frequency + reversion half-life). Growth plan or higher.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
val currencies : kotlin.String = EUR,GBP // kotlin.String | Comma-separated currencies to score, e.g. EUR,GBP. OMIT to rank the liquid set.
val base : kotlin.String = USD // kotlin.String | Base currency to measure against (3-letter ISO 4217). Defaults to USD.
val from : kotlin.String = from_example // kotlin.String | Window start YYYY-MM-DD (UTC). Defaults to ~2 years before `to`.
val to : kotlin.String = to_example // kotlin.String | Window end YYYY-MM-DD (UTC). Defaults to today.
val limit : java.math.BigDecimal = 10 // java.math.BigDecimal | How many to return (default 10, max 50).
try {
    val result : MeanReversionResponse = apiInstance.meanReversion(currencies, base, from, to, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#meanReversion")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#meanReversion")
    e.printStackTrace()
}
```

### Parameters
| **currencies** | **kotlin.String**| Comma-separated currencies to score, e.g. EUR,GBP. OMIT to rank the liquid set. | [optional] |
| **base** | **kotlin.String**| Base currency to measure against (3-letter ISO 4217). Defaults to USD. | [optional] |
| **from** | **kotlin.String**| Window start YYYY-MM-DD (UTC). Defaults to ~2 years before &#x60;to&#x60;. | [optional] |
| **to** | **kotlin.String**| Window end YYYY-MM-DD (UTC). Defaults to today. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **limit** | **java.math.BigDecimal**| How many to return (default 10, max 50). | [optional] |

### Return type

[**MeanReversionResponse**](MeanReversionResponse.md)

### Authorization


Configure bearerAuth statically:
```kotlin
ApiClient.accessToken = ""
```
Configure bearerAuth dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="pppAnalysis"></a>
# **pppAnalysis**
> PppAnalysisResponse pppAnalysis(countries, from, to, period, sort, limit, stats)

PPP analysis

PPP over time: how a country&#39;s purchasing-power-parity factor changed, comparing countries, or &#39;movers&#39;. Growth plan or higher.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
val countries : kotlin.String = IND,DEU,USA // kotlin.String | Comma-separated ISO 3166-1 alpha-3 country codes to compare, e.g. IND,DEU,USA. OMIT to rank ALL countries by PPP-factor change ('movers' mode).
val from : kotlin.String = from_example // kotlin.String | Window start YEAR (e.g. 2015). Defaults to 10 years before `to`. See `period` for a shorthand.
val to : kotlin.String = to_example // kotlin.String | Window end YEAR (e.g. 2024). Defaults to the current year.
val period : kotlin.String = 10y // kotlin.String | Relative window shorthand for `from`: e.g. 10y, 20y, max. Ignored if `from` is given.
val sort : kotlin.String = increased // kotlin.String | Movers ranking: increased (PPP factor rose most, default) or decreased.
val limit : java.math.BigDecimal = 10 // java.math.BigDecimal | Movers: how many top results to return (default 10, max 200).
val stats : kotlin.Boolean = true // kotlin.Boolean | Include min/max/avg of the PPP factor over the window per country. Defaults to true; pass false to skip.
try {
    val result : PppAnalysisResponse = apiInstance.pppAnalysis(countries, from, to, period, sort, limit, stats)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#pppAnalysis")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#pppAnalysis")
    e.printStackTrace()
}
```

### Parameters
| **countries** | **kotlin.String**| Comma-separated ISO 3166-1 alpha-3 country codes to compare, e.g. IND,DEU,USA. OMIT to rank ALL countries by PPP-factor change (&#39;movers&#39; mode). | [optional] |
| **from** | **kotlin.String**| Window start YEAR (e.g. 2015). Defaults to 10 years before &#x60;to&#x60;. See &#x60;period&#x60; for a shorthand. | [optional] |
| **to** | **kotlin.String**| Window end YEAR (e.g. 2024). Defaults to the current year. | [optional] |
| **period** | **kotlin.String**| Relative window shorthand for &#x60;from&#x60;: e.g. 10y, 20y, max. Ignored if &#x60;from&#x60; is given. | [optional] |
| **sort** | **kotlin.String**| Movers ranking: increased (PPP factor rose most, default) or decreased. | [optional] |
| **limit** | **java.math.BigDecimal**| Movers: how many top results to return (default 10, max 200). | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **stats** | **kotlin.Boolean**| Include min/max/avg of the PPP factor over the window per country. Defaults to true; pass false to skip. | [optional] |

### Return type

[**PppAnalysisResponse**](PppAnalysisResponse.md)

### Authorization


Configure bearerAuth statically:
```kotlin
ApiClient.accessToken = ""
```
Configure bearerAuth dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="rates"></a>
# **rates**
> RatesResponse rates(date)

Rates

The full exchange-rate snapshot for a date (USD base).

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
val date : kotlin.String = date_example // kotlin.String | YYYY-MM-DD. Defaults to the latest available date.
try {
    val result : RatesResponse = apiInstance.rates(date)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#rates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#rates")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **date** | **kotlin.String**| YYYY-MM-DD. Defaults to the latest available date. | [optional] |

### Return type

[**RatesResponse**](RatesResponse.md)

### Authorization


Configure bearerAuth statically:
```kotlin
ApiClient.accessToken = ""
```
Configure bearerAuth dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="ratesByBase"></a>
# **ratesByBase**
> RatesByBaseResponse ratesByBase(base, date)

Rates by base

The same snapshot re-expressed against any base currency.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
val base : kotlin.String = EUR // kotlin.String | Base currency (3-letter ISO 4217), e.g. EUR.
val date : kotlin.String = date_example // kotlin.String | YYYY-MM-DD. Defaults to the latest available date.
try {
    val result : RatesByBaseResponse = apiInstance.ratesByBase(base, date)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#ratesByBase")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#ratesByBase")
    e.printStackTrace()
}
```

### Parameters
| **base** | **kotlin.String**| Base currency (3-letter ISO 4217), e.g. EUR. | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **date** | **kotlin.String**| YYYY-MM-DD. Defaults to the latest available date. | [optional] |

### Return type

[**RatesByBaseResponse**](RatesByBaseResponse.md)

### Authorization


Configure bearerAuth statically:
```kotlin
ApiClient.accessToken = ""
```
Configure bearerAuth dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="safeHaven"></a>
# **safeHaven**
> SafeHavenResponse safeHaven(currencies, base, from, to, limit)

Safe haven

Ranks currencies by a composite safe-haven score (low volatility + shallow drawdown + 2008-crisis resilience). Growth plan or higher.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
val currencies : kotlin.String = CHF,JPY // kotlin.String | Comma-separated currencies to score, e.g. CHF,JPY. OMIT to rank the safe-haven pool (includes gold).
val base : kotlin.String = USD // kotlin.String | Base currency to measure against (3-letter ISO 4217). Defaults to USD.
val from : kotlin.String = from_example // kotlin.String | Window start YYYY-MM-DD (UTC). Defaults to 2007-01-01 (spans the 2008 crisis + COVID).
val to : kotlin.String = to_example // kotlin.String | Window end YYYY-MM-DD (UTC). Defaults to today.
val limit : java.math.BigDecimal = 10 // java.math.BigDecimal | How many to return (default 10, max 50).
try {
    val result : SafeHavenResponse = apiInstance.safeHaven(currencies, base, from, to, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#safeHaven")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#safeHaven")
    e.printStackTrace()
}
```

### Parameters
| **currencies** | **kotlin.String**| Comma-separated currencies to score, e.g. CHF,JPY. OMIT to rank the safe-haven pool (includes gold). | [optional] |
| **base** | **kotlin.String**| Base currency to measure against (3-letter ISO 4217). Defaults to USD. | [optional] |
| **from** | **kotlin.String**| Window start YYYY-MM-DD (UTC). Defaults to 2007-01-01 (spans the 2008 crisis + COVID). | [optional] |
| **to** | **kotlin.String**| Window end YYYY-MM-DD (UTC). Defaults to today. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **limit** | **java.math.BigDecimal**| How many to return (default 10, max 50). | [optional] |

### Return type

[**SafeHavenResponse**](SafeHavenResponse.md)

### Authorization


Configure bearerAuth statically:
```kotlin
ApiClient.accessToken = ""
```
Configure bearerAuth dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="volatility"></a>
# **volatility**
> VolatilityResponse volatility(currency, base, from, to, sort, universe, limit)

Volatility

Annualized volatility of a currency vs a base, or a stability ranking of the liquid currencies. Growth plan or higher.

### Example
```kotlin
// Import classes:
//import com.currencycore.sdk.infrastructure.*
//import com.currencycore.sdk.models.*

val apiInstance = CurrencyCoreApi()
val currency : kotlin.String = EUR // kotlin.String | Currency to measure (3-letter ISO 4217), or a comma-separated list to compare. OMIT to RANK the liquid-currency set by stability.
val base : kotlin.String = USD // kotlin.String | Base currency to measure against (3-letter ISO 4217). Defaults to USD.
val from : kotlin.String = from_example // kotlin.String | Window start YYYY-MM-DD (UTC). Defaults to 365 days before `to`.
val to : kotlin.String = to_example // kotlin.String | Window end YYYY-MM-DD (UTC). Defaults to today; a future date clamps to today.
val sort : kotlin.String = stable // kotlin.String | Ranking direction: stable (least volatile first, default) or volatile.
val universe : kotlin.String = liquid // kotlin.String | Ranking universe: liquid (default, broad set) or majors (USD/EUR/GBP/JPY/CHF/CAD/AUD/NZD). Use majors for 'most volatile major pair'.
val limit : java.math.BigDecimal = 10 // java.math.BigDecimal | Ranking: how many to return (default 10, max 50).
try {
    val result : VolatilityResponse = apiInstance.volatility(currency, base, from, to, sort, universe, limit)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CurrencyCoreApi#volatility")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CurrencyCoreApi#volatility")
    e.printStackTrace()
}
```

### Parameters
| **currency** | **kotlin.String**| Currency to measure (3-letter ISO 4217), or a comma-separated list to compare. OMIT to RANK the liquid-currency set by stability. | [optional] |
| **base** | **kotlin.String**| Base currency to measure against (3-letter ISO 4217). Defaults to USD. | [optional] |
| **from** | **kotlin.String**| Window start YYYY-MM-DD (UTC). Defaults to 365 days before &#x60;to&#x60;. | [optional] |
| **to** | **kotlin.String**| Window end YYYY-MM-DD (UTC). Defaults to today; a future date clamps to today. | [optional] |
| **sort** | **kotlin.String**| Ranking direction: stable (least volatile first, default) or volatile. | [optional] |
| **universe** | **kotlin.String**| Ranking universe: liquid (default, broad set) or majors (USD/EUR/GBP/JPY/CHF/CAD/AUD/NZD). Use majors for &#39;most volatile major pair&#39;. | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **limit** | **java.math.BigDecimal**| Ranking: how many to return (default 10, max 50). | [optional] |

### Return type

[**VolatilityResponse**](VolatilityResponse.md)

### Authorization


Configure bearerAuth statically:
```kotlin
ApiClient.accessToken = ""
```
Configure bearerAuth dynamically:
```kotlin
apiInstance.accessTokenProvider = { "" }
```

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

