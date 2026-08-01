package com.smartai.assistant.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkflowDao {

    @Query("SELECT * FROM workflows ORDER BY lastModified DESC")
    fun getAllWorkflows(): Flow<List<Workflow>>

    @Query("SELECT * FROM workflows WHERE id = :id")
    suspend fun getWorkflowById(id: Long): Workflow?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkflow(workflow: Workflow): Long

    @Update
    suspend fun updateWorkflow(workflow: Workflow)

    @Delete
    suspend fun deleteWorkflow(workflow: Workflow)

    @Query("DELETE FROM workflows WHERE id = :id")
    suspend fun deleteWorkflowById(id: Long)
}
