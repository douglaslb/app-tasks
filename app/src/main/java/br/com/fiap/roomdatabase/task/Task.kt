package br.com.fiap.roomdatabase.task

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val description: String
)