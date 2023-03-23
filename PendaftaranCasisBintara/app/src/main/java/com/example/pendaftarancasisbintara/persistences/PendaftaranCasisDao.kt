package com.example.pendaftarancasisbintara.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pendaftarancasisbintara.model.PendaftaranCasis

@Dao
interface PendaftaranCasisDao {
    @Query("SELECT * FROM PendaftaranCasis")
    fun loadAll(): LiveData<List<PendaftaranCasis>>

    @Query("SELECT * FROM PendaftaranCasis WHERE id = :id")
    fun find(id: String): PendaftaranCasis?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: PendaftaranCasis)
    @Delete
    fun delete(item: PendaftaranCasis)
}