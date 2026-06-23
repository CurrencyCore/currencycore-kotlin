
# HistoryAnalysisResponse

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **base** | **kotlin.String** |  |  |
| **from** | **kotlin.String** |  |  |
| **to** | **kotlin.String** |  |  |
| **mode** | [**inline**](#Mode) |  |  |
| **stats** | **kotlin.Boolean** |  |  |
| **results** | [**kotlin.collections.List&lt;HistoryAnalysisResponseResultsInner&gt;**](HistoryAnalysisResponseResultsInner.md) |  |  |
| **sort** | [**inline**](#Sort) |  |  [optional] |
| **assetClass** | [**inline**](#AssetClass) |  |  [optional] |
| **interval** | [**inline**](#Interval) |  |  [optional] |


<a id="Mode"></a>
## Enum: mode
| Name | Value |
| ---- | ----- |
| mode | compare, movers |


<a id="Sort"></a>
## Enum: sort
| Name | Value |
| ---- | ----- |
| sort | strengthened, weakened |


<a id="AssetClass"></a>
## Enum: assetClass
| Name | Value |
| ---- | ----- |
| assetClass | fiat, metals, all, crypto |


<a id="Interval"></a>
## Enum: interval
| Name | Value |
| ---- | ----- |
| interval | daily, weekly, monthly, yearly |



