package com.applecompose.thescribespad.presentation.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.applecompose.thescribespad.data.NotesDataSource
import com.applecompose.thescribespad.domain.model.Note

class NoteViewModel: ViewModel() {
	var noteList = mutableStateListOf<Note>()
	// loads notes when app is started
	init {
		noteList.addAll(NotesDataSource().loadNotes())
	}

	fun addNote(note: Note) {
		noteList.add(note)

	}
	fun removeNote(note: Note) {
		noteList.remove(note)
	}
	fun getAllNotes(): List<Note> {
		return noteList
	}
}