package com.eddwar.tote.domain.repository

import com.eddwar.tote.domain.model.Grosery
import kotlinx.coroutines.flow.Flow

typealias  Groseries = List<Grosery>
interface GroseryRepository {
    fun getGroseriesFromRoom() : Flow<Groseries>
    fun addGroseryToRoom(grosery: Grosery)
    fun getGroseryFromRoom(id: Int): Grosery
    fun updateGroseryInRoom(grosery: Grosery)
    fun deleteGroseryFromRoom(grosery: Grosery)
}