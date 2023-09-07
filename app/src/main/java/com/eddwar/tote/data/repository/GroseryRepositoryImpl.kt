package com.eddwar.tote.data.repository

import com.eddwar.tote.data.network.GroseryDao
import com.eddwar.tote.domain.model.Grosery
import com.eddwar.tote.domain.repository.GroseryRepository

class GroseryRepositoryImpl (
    private  val groseryDao: GroseryDao
): GroseryRepository{
    override fun getGroseriesFromRoom() = groseryDao.getGroseries()
    override fun addGroseryToRoom(grosery: Grosery) = groseryDao.addGrosery(grosery)

    override fun getGroseryFromRoom(id: Int) = groseryDao.getGrosery(id)

    override fun updateGroseryInRoom(grosery: Grosery) =
        groseryDao.updateGrosery(grosery)

    override fun deleteGroseryFromRoom(grosery: Grosery) =
        groseryDao.deleteGrosery(grosery)


}