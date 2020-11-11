package com.example.madlevel5task2.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.madlevel5task2.Models.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class GamesDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "BACKLOG_GAME_DATABASE"

        @Volatile
        private var gameDatabaseInstance: GamesDatabase? = null

        fun getDatabase(context: Context): GamesDatabase? {
            if(gameDatabaseInstance == null) {
                synchronized(GamesDatabase::class.java) {
                    if(gameDatabaseInstance == null) {
                        gameDatabaseInstance = Room.databaseBuilder(
                                context.applicationContext,
                                GamesDatabase::class.java,
                                DATABASE_NAME
                        )
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }
            }
            return gameDatabaseInstance
        }
    }
}