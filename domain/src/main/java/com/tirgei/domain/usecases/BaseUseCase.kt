package com.tirgei.domain.usecases

interface BaseUseCase<in Parameter, out Result> {
    suspend fun invoke(params: Parameter? = null): Result
}