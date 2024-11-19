package org.livewall.firebase.example

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.crashlytics.crashlytics
import dev.gitlive.firebase.initialize

class MyCrashlyticsSetup {
    fun initialiseCrashlytics() {
        Firebase.initialize()
        Firebase.crashlytics.setCrashlyticsCollectionEnabled(true)
    }
}