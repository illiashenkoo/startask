package net.codecision.startask.lifecycle.data

class DataWrapper<T> private constructor(
        val state: DataState,
        val data: T? = null,
        val error: DataError? = null
) {

    companion object {

        fun <T> loading(): DataWrapper<T> {
            return loading(null)
        }

        fun <T> loading(data: T?): DataWrapper<T> {
            return DataWrapper(DataState.LOADING, data, null)
        }

        fun <T> success(): DataWrapper<T> {
            return success(null)
        }

        fun <T> success(data: T?): DataWrapper<T> {
            return DataWrapper(DataState.SUCCESS, data, null)
        }

        fun <T> failure(error: DataError): DataWrapper<T> {
            return failure(error, null)
        }

        fun <T> failure(error: DataError, data: T?): DataWrapper<T> {
            return DataWrapper(DataState.FAILURE, data, error)
        }

    }

}