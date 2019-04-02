package net.codecision.startask.lifecycle.data

inline fun <D, E> DataWrapper<D, E>.onLoading(action: () -> Unit): DataWrapper<D, E> {
    if (state == DataState.LOADING) {
        action()
    }
    return this
}

inline fun <D, E> DataWrapper<D, E>.onFailure(action: (error: E) -> Unit): DataWrapper<D, E> {
    if (state == DataState.FAILURE) {
        if (error != null) {
            action(error)
        } else {
            throw IllegalArgumentException("Failure error can't be NULL")
        }
    }
    return this
}

inline fun <D, E> DataWrapper<D, E>.onFailureNullable(action: (error: E?) -> Unit): DataWrapper<D, E> {
    if (state == DataState.FAILURE) {
        action(error)
    }
    return this
}


@Suppress("UNCHECKED_CAST")
inline fun <D, E> DataWrapper<D, E>.onSuccess(action: (value: D) -> Unit): DataWrapper<D, E> {
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
inline fun <D, E> DataWrapper<D, E>.onSuccessNullable(action: (value: D?) -> Unit): DataWrapper<D, E> {
    if (state == DataState.SUCCESS) {
        action(data)
    }
    return this
}

@Suppress("UNCHECKED_CAST")
inline fun <D, E> DataWrapper<D, E>.onSuccess(defError: E, action: (value: D) -> Unit): DataWrapper<D, E> {
    if (state == DataState.SUCCESS) {
        if (data != null) {
            action(data)
        } else {
            DataWrapper.failure<D, E>(defError)
        }
    }
    return this
}