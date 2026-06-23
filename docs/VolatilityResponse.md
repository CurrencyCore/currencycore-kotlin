
# VolatilityResponse

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **base** | **kotlin.String** |  |  |
| **from** | **kotlin.String** |  |  |
| **to** | **kotlin.String** |  |  |
| **mode** | [**inline**](#Mode) |  |  |
| **basis** | [**inline**](#Basis) |  |  |
| **results** | [**kotlin.collections.List&lt;VolatilityResponseResultsInner&gt;**](VolatilityResponseResultsInner.md) |  |  |
| **sort** | [**inline**](#Sort) |  |  [optional] |
| **universe** | [**inline**](#Universe) |  |  [optional] |


<a id="Mode"></a>
## Enum: mode
| Name | Value |
| ---- | ----- |
| mode | compare, ranking |


<a id="Basis"></a>
## Enum: basis
| Name | Value |
| ---- | ----- |
| basis | annualized-daily |


<a id="Sort"></a>
## Enum: sort
| Name | Value |
| ---- | ----- |
| sort | stable, volatile |


<a id="Universe"></a>
## Enum: universe
| Name | Value |
| ---- | ----- |
| universe | liquid, majors |



