package com.tirgei.domain

/**
 * Class to handle responses from Repositories that can either succeed of fail
 */
sealed class Result<out T> {
    class Success<out T>(val data: T): Result<T>()
    class Error(val message: String): Result<Nothing>()
}

/**
 * Inline function called when request [Result] is a [Result.Success]
 * @param callback - lambda function with the data fetched
 */
inline fun <reified T> Result<T>.onSuccess(callback: (data: T) -> Unit): Result<T> {
    if (this is Result.Success) callback(this.data)
    return this
}

/**
 * Inline function called when request [Result] is a [Result.Error]
 * @param callback - lambda function with the message of the failed request
 */
inline fun <reified T> Result<T>.onError(callback: (message: String) -> Unit): Result<T> {
    if (this is Result.Error) callback(this.message)
    return this
}