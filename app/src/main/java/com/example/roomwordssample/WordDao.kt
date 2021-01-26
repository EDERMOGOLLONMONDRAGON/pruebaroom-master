package com.example.roomwordssample

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query( "SELECT * from word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}