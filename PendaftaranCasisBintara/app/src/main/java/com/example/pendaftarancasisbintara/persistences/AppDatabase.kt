package com.example.pendaftarancasisbintara.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pendaftarancasisbintara.model.PendaftaranCasis

@Database(entities = [PendaftaranCasis::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun PendaftaranCasisDao(): PendaftaranCasisDao
}