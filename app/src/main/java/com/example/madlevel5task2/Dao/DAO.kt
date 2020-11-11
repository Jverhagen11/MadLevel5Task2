package com.example.madlevel5task2.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.madlevel5task2.Models.Game

@Dao
interface DAO {

    @Query("SELECT * FROM Game")
    fun getAllBacklogGames(): LiveData<List<Game>>

    @Insert
    fun insertBacklogGame(backlogGame: Game)

    @Delete
    fun deleteBacklogGame(backlogGame: Game)

    @Query("DELETE FROM Game")
    suspend fun deleteAllBacklogGames()
}