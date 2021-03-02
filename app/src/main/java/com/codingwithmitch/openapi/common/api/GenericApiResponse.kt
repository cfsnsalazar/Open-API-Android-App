package com.codingwithmitch.openapi.common.api

import retrofit2.Response

sealed class GenericApiResponse<T> {

    class ApiEmptyResponse<T> : GenericApiResponse<T>()
    data class ApiSuccessResponse<T>(val body: T) : GenericApiResponse<T>()
    data class ApiErrorResponse<T>(val errorMessage: String) : GenericApiResponse<T>()

    companion object {
        private val TAG = "AppDebug"
        fun <T> create(error: Throwable): ApiErrorResponse<T> {
            return ApiErrorResponse(error.message ?: "unknown error")
        }

        fun <T> create(response: Response<T>): GenericApiResponse<T> {
            return if (response.isSuccessful) {
                response.toApiResponse()
            } else {
                response.toApiFailedResponse()
            }
        }

        private fun <T> Response<T>.toApiResponse(): GenericApiResponse<T> {
            val body = body()
            return when {
                body == null || code() == 204 -> {
                    ApiEmptyResponse()
                }
                code() == 401 -> {
                    ApiErrorResponse("401 Unauthorized. Token may be invalid.")
                }
                else -> {
                    ApiSuccessResponse(body = body)
                }
            }
        }

        private fun <T> Response<T>.toApiFailedResponse(): ApiErrorResponse<T> {
            return ApiErrorResponse(
                errorBody()?.string() ?: message() ?: "unknown error"
            )
        }
    }
}