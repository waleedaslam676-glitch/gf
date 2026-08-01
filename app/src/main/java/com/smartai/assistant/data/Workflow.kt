package com.smartai.assistant.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workflows")
data class Workflow(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String = "",
    val stepCount: Int = 0,
    val screenshotCount: Int = 0,
    val status: String = "Idle",
    val createdAt: Long = System.currentTimeMillis(),
    val lastModified: Long = System.currentTimeMillis()
)
