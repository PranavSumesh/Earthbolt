package com.app.earthbolt

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PhotoDao {
    @Insert
    suspend fun insertPhoto(photo: Photo)

    @Query("SELECT * FROM photos WHERE albumName = :albumName ORDER BY timestamp DESC")
    suspend fun getPhotosByAlbum(albumName: String): List<Photo>

    @Query("SELECT DISTINCT albumName FROM photos")
    suspend fun getAllAlbums(): List<String>
}