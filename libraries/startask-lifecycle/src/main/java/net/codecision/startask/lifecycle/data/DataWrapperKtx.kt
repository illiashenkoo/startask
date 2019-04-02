package net.codecision.startask.lifecycle.data

inline fun <T> DataWrapper<T>.onLoading(action: () -> Unit): DataWrapper<T> {
    if (state == DataState.LOADING) {
        action()
    }
    return this
}

inline fun <T> DataWrapper<T>.onFailure(action: (error: DataError) -> Unit): DataWrapper<T> {
    if (state == DataState.FAILURE) {
        if (error != null) {
            action(error)
        } else {
            throw IllegalArgumentException("Failure error can't be NULL")
        }
    }
    return this
}

inline fun <T> DataWrapper<T>.onFailureNullable(action: (error: DataError?) -> Unit): DataWrapper<T> {
    if (state == DataState.FAILURE) {
        action(error)
    }
    return this
}


@Suppress("UNCHECKED_CAST")
inline fun <T> DataWrapper<T>.onSuccess(action: (value: T) -> Unit): DataWrapper<T> {
    if (state == DataState.SUCCESS) {
        if (data != null) {
            action(data)
        } else {
            throw IllegalArgumentException("Success data can't be NULL")
        }
    }
    return this
}

@Suppress("UNCHECKED_CAST")
inline fun <T> DataWrapper<T>.onSuccessNullable(action: (value: T?) -> Unit): DataWrapper<T> {
    if (state == DataState.SUCCESS) {
        action(data)
    }
    return this
}

@Suppress("UNCHECKED_CAST")
inline fun <T> DataWrapper<T>.onSuccess(defError: DataError, action: (value: T) -> Unit): DataWrapper<T> {
    if (state == DataState.SUCCESS) {
        if (data != null) {
            action(data)
        } else {
            DataWrapper.failure<T>(defError)
        }
    }
    return this
}