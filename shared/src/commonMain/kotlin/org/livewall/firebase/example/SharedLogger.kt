package org.livewall.firebase.example

import co.touchlab.kermit.ExperimentalKermitApi
import co.touchlab.kermit.Logger
import co.touchlab.kermit.crashlytics.CrashlyticsLogWriter

object SharedLogger {
    val logger: Logger = Logger.withTag("SharedLogger")

    @OptIn(ExperimentalKermitApi::class)
    fun initializeCrashlyticsLogging() {
        Logger.addLogWriter(CrashlyticsLogWriter())
        logInfo("In the init in shared")
    }

    fun logError(exception: Throwable, message: String) {
        logger.e(exception) { message }
    }

    fun triggerEveryTypeOfSeverityLog() {
        logger.v { "This is a verbose log message" }
        logger.d { "This is a debug log message" }
        logger.i { "This is an info log message" }
        logger.w { "This is a warning log message" }
        logger.e { "This is an error log message" }
        logger.a { "This is an assert log message" }
    }

    fun logInfo(message: String) {
        logger.i { message }
    }
}