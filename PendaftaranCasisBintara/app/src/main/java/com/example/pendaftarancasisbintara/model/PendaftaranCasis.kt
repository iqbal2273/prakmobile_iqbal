package com.example.pendaftarancasisbintara.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PendaftaranCasis(
    @PrimaryKey val id: String,
    val nama: String,
    val alamat: String,
    val usia: String,
    val tanggal: String,
)