package com.peopleinteractive.domain



sealed class ResultState<T> {

    /**
     * A state of [data] which shows that we know there is still an update to come.
     */
    data class Loading<T>(val data: T) : ResultState<T>()

    /**
     * A state that shows the [data] is the last known update.
     */
    data class Success<T>(val data: T) : ResultState<T>()

    /**
     * Only a user message with code is propagated to UI.
     */
    data class Error<T>(val error: Entity.Error) : ResultState<T>()
}