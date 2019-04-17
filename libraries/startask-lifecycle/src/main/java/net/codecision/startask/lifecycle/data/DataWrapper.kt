package net.codecision.startask.lifecycle.data

class DataWrapper<D, E> private constructor(
        val state: DataState,
        val data: D? = null,
        val error: E? = null
) {

    companion object {

        fun <D, E> loading(): DataWrapper<D, E> {
            return loading(null)
        }

        fun <D, E> loading(data: D?): DataWrapper<D, E> {
            return DataWrapper(DataState.LOADING, data, null)
        }

        fun <D, E> success(): DataWrapper<D, E> {
            return success(null)
        }

        fun <D, E> success(data: D?): DataWrapper<D, E> {
            return DataWrapper(DataState.SUCCESS, data, null)
        }

        fun <D, E> failure(error: E): DataWrapper<D, E> {
            return failure(error, null)
        }

        fun <D, E> failure(error: E, data: D?): DataWrapper<D, E> {
            return DataWrapper(DataState.FAILURE, data, error)
        }

    }

}