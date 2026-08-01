package com.smartai.assistant.ui.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.smartai.assistant.data.AppDatabase
import com.smartai.assistant.data.Workflow
import com.smartai.assistant.data.WorkflowRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WorkflowViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WorkflowRepository

    val workflows: StateFlow<List<Workflow>>

    init {
        val dao = AppDatabase.getInstance(application).workflowDao()
        repository = WorkflowRepository(dao)
        workflows = repository.allWorkflows.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    }

    fun addWorkflow(name: String, description: String) {
        if (name.isBlank()) return
        viewModelScope.launch {
            repository.addWorkflow(name, description)
        }
    }

    fun deleteWorkflow(workflow: Workflow) {
        viewModelScope.launch {
            repository.deleteWorkflow(workflow)
        }
    }
}
