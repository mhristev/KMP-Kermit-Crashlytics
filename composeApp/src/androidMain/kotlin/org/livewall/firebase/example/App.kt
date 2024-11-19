package org.livewall.firebase.example

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

            Button(onClick = {
                SharedLogger.logInfo("I am trying to trigger a crash with out of bounds from the Android application.")
                CrashSimulator().triggerCrashOutOfBounds()
            }) {
                Text("Trigger crash out of bounds in the shared code")
            }
        }
    }
}