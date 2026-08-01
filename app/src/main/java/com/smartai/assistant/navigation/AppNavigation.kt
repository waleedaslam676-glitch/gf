package com.smartai.assistant.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smartai.assistant.ui.screens.CreateWorkflowScreen
import com.smartai.assistant.ui.screens.HomeScreen
import com.smartai.assistant.ui.screens.SettingsScreen
import com.smartai.assistant.ui.screens.WorkflowListScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onNavigate = { route -> navController.navigate(route) })
        }
        composable("workflow_list") {
            WorkflowListScreen(
                onBack = { navController.popBackStack() },
                onCreateNew = { navController.navigate("create_workflow") }
            )
        }
        composable("create_workflow") {
            CreateWorkflowScreen(
                onBack = { navController.popBackStack() },
                onSaved = { navController.popBackStack() }
            )
        }
        composable("settings") {
            SettingsScreen(onBack = { navController.popBackStack() })
        }
    }
}
