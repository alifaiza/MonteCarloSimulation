package com.vocalabs.phone.control

/**
 * Factory for obtaining a PhoneController.
 */
interface PhoneControllerSource {

    /** Return a PhoneController that is linked to a Survey Administrator.  For this type of PhoneController, the
     * TERMINATED state is not permanent, but may change to any other state if the Administrator calls back in.
     */
    fun controllerForAdministratorId(administratorId: Int): PhoneController

    /**
     * Given the ID for an inbound Asterisk Channel, find the matching controller.  If there is no such channel
     * in use, or the channel is not inbound (i.e. Asterisk did not answer the call), or the channel is not running
     * the appropriate script, then the PhoneController is permanently in the TERMINATED state.
     */
    fun controllerForChannelId(channelId: String): PhoneController

    /**
     * Similar to [[controllerForChannelId]] except that it returns the first channel in use.  This is only useful
     * for debugging, and may be disabled in the production system.  If no appropriate channel is available, then the
     * PhoneController is permanently in the TERMINATED state.
     */
    fun anyController(): PhoneController
}