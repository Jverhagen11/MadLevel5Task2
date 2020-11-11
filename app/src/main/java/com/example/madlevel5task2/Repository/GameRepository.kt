package com.example.madlevel5task2.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.madlevel5task2.Dao.DAO
import com.example.madlevel5task2.Database.GamesDatabase
import com.example.madlevel5task2.Models.Game

class GameRepository(context: Context) {

    private val backlogGameDao: DAO

    init {
        val database = GamesDatabase.getDatabase(context)
        backlogGameDao = database!!.backlogGameDao()
    }

    fun getAllBacklogGames(): LiveData<List<Game>> {
        return backlogGameDao.getAllBacklogGames()
    }

    fun insertBacklogGame(game: Game) {
        backlogGameDao.insertBacklogGame(game)
    }

    suspend fun deleteAllBacklogGames() {
        backlogGameDao.deleteAllBacklogGames()
    }

    fun deleteBacklogGame(game: Game) {
        backlogGameDao.deleteBacklogGame(game)
    }
}