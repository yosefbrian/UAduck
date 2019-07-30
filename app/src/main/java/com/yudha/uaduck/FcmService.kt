package com.yudha.uaduck

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.urbanairship.push.fcm.AirshipFirebaseIntegration

class FcmService : FirebaseMessagingService() {

    override fun onNewToken(p0: String?) {
        AirshipFirebaseIntegration.processNewToken(applicationContext)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        AirshipFirebaseIntegration.processMessageSync(applicationContext, remoteMessage!!)
        Log.d("telo", "telo")
    }
}
