package com.applecompose.thescribespad.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.applecompose.thescribespad.data.model.Note
import com.applecompose.thescribespad.domain.utils.DateConverter
import com.applecompose.thescribespad.domain.utils.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {

	abstract fun noteDao(): NoteDatabaseDao


}