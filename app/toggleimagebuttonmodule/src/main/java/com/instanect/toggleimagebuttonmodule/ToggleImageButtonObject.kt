package com.instanect.toggleimagebuttonmodule

class ToggleImageButtonObject {
    var resIdForStateA = -1
    var resIdForStateNotA = -1
    var currentState = STATE_A
    var toggleImageBeforeToggleButtonClickListener: ToggleImageBeforeToggleButtonClickListener? = null
    var toggleImageAfterToggleButtonClickListener: ToggleImageAfterToggleButtonClickListener? = null;

    companion object {
        const val STATE_A = 1
        const val STATE_NOT_A = 0
    }
}