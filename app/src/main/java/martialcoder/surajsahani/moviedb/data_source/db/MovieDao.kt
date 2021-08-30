package com.example.movieappkotlin.data_source.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import martialcoder.surajsahani.moviedb.model.Movie


@Dao
interface MovieDao {
    @get:Query("SELECT * FROM Movie")
    val all: List<Movie>

    @Query("SELECT * FROM Movie")
    fun getAllPaged(): DataSource.Factory<Int, Movie>

    @Insert
    fun insert(movie: Movie?)

    @Query("DELETE FROM Movie")
    fun delete()
}
