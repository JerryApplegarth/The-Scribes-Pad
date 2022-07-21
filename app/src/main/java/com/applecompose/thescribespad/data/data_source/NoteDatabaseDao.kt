package com.applecompose.thescribespad.data.data_source

import androidx.room.*
import com.applecompose.thescribespad.data.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

	@Query(value = "SELECT * FROM notes_tbl")
	fun getNotes(): Flow<List<Note>>

	@Query(value = "SELECT * FROM notes_tbl WHERE id=:id" )
	suspend fun getNoteById(id: String): Note

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(note: Note)

	@Update(onConflict = OnConflictStrategy.REPLACE)
	suspend fun update(note: Note)

	@Query(value = "DELETE FROM notes_tbl")
	suspend fun deleteAll()

	@Delete
	suspend fun deleteNote(note: Note)

}
