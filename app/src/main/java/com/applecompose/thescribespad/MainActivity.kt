package com.applecompose.thescribespad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.applecompose.thescribespad.data.NotesDataSource
import com.applecompose.thescribespad.domain.model.Note
import com.applecompose.thescribespad.presentation.screens.NoteScreen
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
					HomeScreen()

				}
			}
		}
	}
}

@Composable
fun HomeScreen() {
	val notes = remember { mutableStateListOf<Note>()}
	NoteScreen(
		notes = notes,
		onAddNote = {
					notes.add(it)
		},
		onRemoveNote = {
			notes.remove(it)

		})

}



