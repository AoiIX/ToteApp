package com.eddwar.tote.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Update
import com.eddwar.tote.core.Constants.Companion.GROSERY_TABLE
import com.eddwar.tote.domain.model.Grosery
import com.eddwar.tote.domain.repository.Groseries
import kotlinx.coroutines.flow.Flow

@Dao
interface GroseryDao {
    @Query("SELECT * FROM $GROSERY_TABLE ORDER BY id ASC")
    fun getGroseries(): Flow<Groseries>

    @Insert(onConflict = IGNORE)
    fun addGrosery(grosery: Grosery)

    @Query("SELECT * FROM $GROSERY_TABLE WHERE id = :id")
    fun getGrosery(id: Int): Grosery

    @Update
    fun updateGrosery(grosery: Grosery)

    @Delete
    fun deleteGrosery(grosery: Grosery)

}