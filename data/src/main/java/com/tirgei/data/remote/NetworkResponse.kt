package com.tirgei.data.remote


/**
 * A wrapper class to hold a model type with its given API status (i.e. LOADING, ERROR, SUCCESS).
 */
sealed class NetworkResponse<out T> {
    object Loading : NetworkResponse<Nothing>()
    class Success<out T>(val data: T): NetworkResponse<T>()
    class Error(val message: String): NetworkResponse<Nothing>()
}

/**
 * Inline function called when response [NetworkResponse] status is [NetworkStatus.LOADING]
 * @param callback - lambda function called
 */
inline fun <reified T> NetworkResponse<T>.onLoading(callback: () -> Unit): NetworkResponse<T> {
    if (this is NetworkResponse.Loading) callback()
    return this
}

/**
 * Inline function called when response [NetworkResponse] status is [NetworkStatus.SUCCESS]
 * @param callback - lambda function called with the data
 */
inline fun <reified T> NetworkResponse<T>.onSuccess(callback: (data: T) -> Unit): NetworkResponse<T> {
    if (this is NetworkResponse.Success) callback(this.data)
    return this
}

/**
 * Inline function called when response [NetworkResponse] status is [NetworkStatus.ERROR]
 * @param callback - lambda function called with error message
 */
inline fun <reified T> NetworkResponse<T>.onError(callback: (message: String) -> Unit): NetworkResponse<T> {
    if (this is NetworkResponse.Error) callback(this.message)
    return this
}