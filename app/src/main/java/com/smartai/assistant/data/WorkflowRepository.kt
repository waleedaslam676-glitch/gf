package com.smartai.assistant.data

import kotlinx.coroutines.flow.Flow

class WorkflowRepository(private val dao: WorkflowDao) {
    val allWorkflows: Flow<List<Workflow>> = dao.getAllWorkflows()

    suspend fun addWorkflow(name: String, description: String) {
        dao.insertWorkflow(Workflow(name = name, description = description))
    }

    suspend fun deleteWorkflow(workflow: Workflow) {
        dao.deleteWorkflow(workflow)
    }

    suspend fun updateWorkflow(workflow: Workflow) {
        dao.updateWorkflow(workflow)
    }
}
