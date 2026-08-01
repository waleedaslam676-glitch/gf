package com.smartai.assistant.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
        ) {
            Text("Detection & AI settings, API keys, and providers will appear here in future updates.",
                style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Coming in next rounds:", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            listOf(
                "AI Providers & API Key Manager",
                "Detection Confidence & Retry Settings",
                "Screenshot & Annotation Tools",
                "Logs & Inspector Mode"
            ).forEach {
                Text("• $it", modifier = Modifier.padding(vertical = 2.dp))
            }
        }
    }
}
