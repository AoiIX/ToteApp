package com.eddwar.tote.di

import android.content.Context
import androidx.room.Room
import com.eddwar.tote.core.Constants.Companion.GROSERY_TABLE
import com.eddwar.tote.data.network.GroseryDB
import com.eddwar.tote.data.network.GroseryDao
import com.eddwar.tote.data.repository.GroseryRepositoryImpl
import com.eddwar.tote.domain.repository.GroseryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideGroseryDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context, GroseryDB::class.java, GROSERY_TABLE).build()

    @Provides
    fun provideGroseryDao(groseryDB: GroseryDB) = groseryDB.groseryDao()

    @Provides
    fun provideGroseryRepository(groseryDao: GroseryDao
    ): GroseryRepository = GroseryRepositoryImpl(groseryDao = groseryDao)

}