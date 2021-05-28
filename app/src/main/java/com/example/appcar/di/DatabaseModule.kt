package com.example.appcar.di

import android.content.Context
import androidx.room.Room
import com.example.appcar.data.AppDatabase
import com.example.appcar.data.CarTypeDao
import com.example.appcar.data.RelationDao
import com.example.appcar.data.RoadDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app.db"
        ).build()
    }

    @Provides
    fun provideRoadDao(database: AppDatabase) : RoadDao {
        return database.roadDao()
    }

    @Provides
    fun provideCarType(database: AppDatabase) : CarTypeDao {
        return database.carTypeDao()
    }

    @Provides
    fun provideRelationDao(database: AppDatabase) : RelationDao {
        return database.relationDao()
    }


}