package com.jetpack.moviecataloguejetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jetpack.moviecataloguejetpack.model.entity.movie.FavoriteMovie
import com.jetpack.moviecataloguejetpack.model.entity.tv.FavoriteTv

@Database(entities = [FavoriteMovie::class, FavoriteTv::class], version = 1, exportSchema = false)
abstract class FavoriteDatabase : RoomDatabase() {

    abstract fun favoriteDao() : FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE : FavoriteDatabase? = null

        @Synchronized
        fun getInstance(context: Context) : FavoriteDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<FavoriteDatabase>(context.applicationContext, FavoriteDatabase::class.java, "favorite_db").fallbackToDestructiveMigration().build()
            }
            return INSTANCE as FavoriteDatabase
        }

        fun getDatabase(context: Context) : FavoriteDatabase? {
            if (INSTANCE == null) {
                synchronized(FavoriteDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext, FavoriteDatabase::class.java, "favorite_db").build()
                    }
                }
            }
            return INSTANCE
        }
    }
}