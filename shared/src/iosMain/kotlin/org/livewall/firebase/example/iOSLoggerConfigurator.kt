package org.livewall.firebase.example

import co.touchlab.crashkios.crashlytics.setCrashlyticsUnhandledExceptionHook

class iOSLoggerConfigurator {
    fun setupLoggerWithCrashlytics() {
        SharedLogger.initializeCrashlyticsLogging()
        setCrashlyticsUnhandledExceptionHook()
    }
}