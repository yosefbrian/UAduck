package com.yudha.uaduck

import android.util.Log
import com.urbanairship.Autopilot
import com.urbanairship.UAirship
import com.urbanairship.push.NotificationActionButtonInfo
import com.urbanairship.push.NotificationInfo
import com.urbanairship.push.NotificationListener
import com.urbanairship.push.notifications.NotificationActionButtonGroup
import android.R
import com.urbanairship.push.notifications.NotificationActionButton




/**
 * Created by yudha on 25,July,2019
 */
class UAAutoPilot: Autopilot() {

     val TAG = "urban airship"

    override fun onAirshipReady(airship: UAirship) {
        airship.pushManager.userNotificationsEnabled = true
//        airship.setDeepLinkListener {
//            return@setDeepLinkListener true
//        }

        airship.pushManager.setNotificationListener(object : NotificationListener {
            override fun onNotificationPosted(notificationInfo: NotificationInfo) {
                Log.i(
                    TAG,
                    "Notification posted. Alert: " + notificationInfo.message.alert + ". NotificationId: " + notificationInfo.notificationId
                )
            }

            override fun onNotificationOpened(notificationInfo: NotificationInfo): Boolean {
                Log.i(
                    TAG,
                    "Notification opened. Alert: " + notificationInfo.message.alert + ". NotificationId: " + notificationInfo.notificationId
                )
                // Return false here to allow Airship to auto launch the launcher activity
                return false
            }

            override fun onNotificationForegroundAction(
                notificationInfo: NotificationInfo,
                actionButtonInfo: NotificationActionButtonInfo
            ): Boolean {
                Log.i(
                   TAG,
                    "Notification foreground action. Button ID: " + actionButtonInfo.buttonId + ". NotificationId: " + notificationInfo.notificationId
                )
                return false
            }

            override fun onNotificationBackgroundAction(
                notificationInfo: NotificationInfo,
                actionButtonInfo: NotificationActionButtonInfo
            ) {
                Log.i(
                    TAG,
                    "Notification background action. Button ID: " + actionButtonInfo.buttonId + ". NotificationId: " + notificationInfo.notificationId
                )
            }

            override fun onNotificationDismissed(notificationInfo: NotificationInfo) {
                Log.i(
                    TAG,
                    "Notification dismissed. Alert: " + notificationInfo.message.alert + ". Notification ID: " + notificationInfo.notificationId
                )
            }
        })
    }
}