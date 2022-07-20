package com.applecompose.thescribespad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.applecompose.thescribespad.domain.model.Note
import com.applecompose.thescribespad.presentation.screens.NoteScreen
import com.applecompose.thescribespad.presentation.screens.NoteViewModel
import com.applecompose.thescribespad.ui.theme.TheScribesPadTheme

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			TheScribesPadTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					val noteViewModel: NoteViewModel by viewModels()
					HomeScreen(noteViewModel)

				}
			}
		}
	}
}


@Composable
fun HomeScreen(noteViewModel: NoteViewModel = viewModel()) {

	val notesList = noteViewModel.getAllNotes()

	NoteScreen(
		notes = notesList,
		onAddNote = {
			noteViewModel.addNote(it)
		},
		onRemoveNote = {
			noteViewModel.removeNote(it)
		})
}

