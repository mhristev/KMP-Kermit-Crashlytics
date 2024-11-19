package org.livewall.firebase.example

class CrashSimulator {
    fun triggerCrashOutOfBounds() {
        SharedLogger.logInfo("I am in the shared CrashSimulator, calling triggerCrashOutOfBounds() method.")
        val myList = listOf(1, 2, 3)
        try {
            val element = myList[5]
            println("Element at index 5: $element")
        } catch (e: IndexOutOfBoundsException) {
           SharedLogger.logError(e, "An error occurred during the operation in the shared code with accessing list element in triggerCrashOutOfBounds().")
            throw e
        }
    }
    @Throws(RuntimeException:: class)
    fun triggerCrashFromSharedCode() {
        SharedLogger.logInfo("I am in the share CrashSimulator, calling basic triggerCrashFromSharedCode() method.")
        throw RuntimeException("Test crash from the shared Kotlin Multiplatform code")
    }
}