package com.eddwar.tote.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eddwar.tote.core.Constants.Companion.GROSERY_TABLE

@Entity(tableName = GROSERY_TABLE)
data class Grosery (
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val name: String,
    val amount: String,
    val measure: String
)
