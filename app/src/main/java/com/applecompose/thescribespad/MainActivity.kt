package com.applecompose.thescribespad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.applecompose.thescribespad.data.model.Note
import com.applecompose.thescribespad.presentation.screens.NoteScreen
import com.applecompose.thescribespad.presentation.screens.NoteViewModel
import com.applecompose.thescribespad.ui.theme.TheScribesPadTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
					// val noteViewModel = viewModel<NoteViewModel>() //also works
					val noteViewModel: NoteViewModel by viewModels()
					HomeScreen(noteViewModel)

				}
			}
		}
	}
}


@Composable
fun HomeScreen(noteViewModel: NoteViewModel) {

	val notesList = noteViewModel.noteList.collectAsState().value

	NoteScreen(
		notes = notesList,
		onAddNote = {
			noteViewModel.addNote(it)
		},
		onRemoveNote = {
			noteViewModel.removeNote(it)
		})
}

