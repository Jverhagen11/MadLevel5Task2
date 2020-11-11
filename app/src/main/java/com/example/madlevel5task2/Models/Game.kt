package com.example.madlevel5task2.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
    data class Game (
            var name: String,
            var platform: String,
            var date: LocalDate,

            @PrimaryKey(autoGenerate = true)
            var id: Long? = null
    )