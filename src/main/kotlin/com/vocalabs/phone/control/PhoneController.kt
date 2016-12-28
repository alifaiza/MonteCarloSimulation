package com.vocalabs.phone.control

/**
 * This provides commands for controlling a particular phone call.  Some implementations may be tied to a specific
 * telephony channel, while others may find the appropriate channel on the fly.
 *
 */
interface PhoneController {
    /**
     * Place a phone call. In other words, bridge this telephony channel to another channel and dial the remote channel.
     * The user should hear ringing, a busy signal, etc. on the line.
     *
     * This function succeeds no matter what the state of the call is.
     */
    fun dial()

    /**
     * Hang up a phone call. In other words, disconnect a bridged the remote channel.
     * The user should hear hold music on the line.
     *
     * This function succeeds no matter what the state of the call is.
     */
    fun hangup()

    /** Describe the current state of the phone call. */
    fun scriptState(): ScriptState
}

/**
 * Describes the state of the phone call.
 *
 * -  START:
 *           The script has been started, and is still being initialized.
 * - SHOULD_DIAL:
 *           The script has been told to dial but has not completed dialing.
 * -  DIALED:
 *           The call has been bridged to the remote channel. The user may be hearing a ring tone, busy signal, or
 *           other telephone signals, or may be in the middle of the call.
 * -  WAITING_TO_DIAL:
 *           The remote channel's call has been terminated. The user should be hearing hold music.
 * -  TERMINATED:
 *           This is the state when a call is either known to have been terminated, or when nothing is known
 *           about its state.
 */
enum class ScriptState {
    START,
    SHOULD_DIAL,
    DIALED,
    WAITING_TO_DIAL,
    TERMINATED
}

data class ScriptStatus(val state: ScriptState, val message: String)