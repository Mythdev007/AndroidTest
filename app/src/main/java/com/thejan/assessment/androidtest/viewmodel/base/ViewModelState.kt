package com.thejan.assessment.androidtest.viewmodel.base


class ViewModelState constructor(
    var status: Status,
    var error: Throwable? = null
) {
    companion object {
        fun saved(): ViewModelState {
            return ViewModelState(Status.SAVED)
        }
        fun invalid(): ViewModelState {
            return ViewModelState(Status.INVALID)
        }
    }
}