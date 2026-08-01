package com.smartai.assistant.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class HomeAction(val title: String, val icon: ImageVector, val route: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {

    val actions = listOf(
        HomeAction("Create Workflow", Icons.Filled.AddCircle, "create_workflow"),
        HomeAction("Workflow Library", Icons.AutoMirrored.Filled.List, "workflow_list"),
        HomeAction("Record Workflow", Icons.Filled.FiberManualRecord, "workflow_list"),
        HomeAction("Screenshot Library", Icons.Filled.PhotoLibrary, "workflow_list"),
        HomeAction("AI Providers", Icons.Filled.SmartToy, "settings"),
        HomeAction("API Manager", Icons.Filled.VpnKey, "settings"),
        HomeAction("Logs", Icons.Filled.Description, "settings"),
        HomeAction("Settings", Icons.Filled.Settings, "settings")
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Smart AI Assistant", fontWeight = FontWeight.Bold) })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                "Welcome back",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                "Automate anything on your phone",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            Spacer(modifier = Modifier.height(20.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(actions) { action ->
                    HomeActionCard(action) { onNavigate(action.route) }
                }
            }
        }
    }
}

@Composable
private fun HomeActionCard(action: HomeAction, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Icon(
                imageVector = action.icon,
                contentDescription = action.title,
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                action.title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
