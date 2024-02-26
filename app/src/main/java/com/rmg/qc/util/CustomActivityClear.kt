package com.foodibd.rider.util

import android.app.Activity
import android.content.Intent

class CustomActivityClear {
    companion object {
        fun doClearActivity(intent: Intent, activity: Activity) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            activity.startActivity(intent)
            activity.finish()

        }
    }
}