package com.eddwar.tote.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eddwar.tote.domain.model.Grosery
import com.eddwar.tote.domain.repository.Groseries

@Database(entities = [Grosery::class], version = 1, exportSchema = false)
abstract class GroseryDB: RoomDatabase() {
    abstract fun groseryDao(): GroseryDao
}