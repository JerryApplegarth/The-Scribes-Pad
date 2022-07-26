package com.applecompose.thescribespad.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applecompose.thescribespad.R
import com.applecompose.thescribespad.data.data_source.NotesDataSource
import com.applecompose.thescribespad.data.model.Note
import com.applecompose.thescribespad.presentation.components.NoteButton
import com.applecompose.thescribespad.presentation.components.NoteInputText
import com.applecompose.thescribespad.presentation.components.NoteRow
import com.applecompose.thescribespad.ui.theme.newBackgroundColor
import com.applecompose.thescribespad.ui.theme.topbarColor

@Composable
fun NoteScreen(
	notes: List<Note>,
	onAddNote: (Note) -> Unit,
	onRemoveNote: (Note) -> Unit
) {
	var title by remember { mutableStateOf("") }
	var description by remember { mutableStateOf("") }
	val context = LocalContext.current

	Column(
		modifier = Modifier
			.padding(6.dp)
			.background(MaterialTheme.colors.newBackgroundColor)
			.height(24.dp)
	) {
		TopAppBar(
			backgroundColor = MaterialTheme.colors.topbarColor,
			title = {
				Text(
					modifier = Modifier
						.background(Color.Transparent),
					text = stringResource(
						id = R.string.app_name,
					)
				)
			},
			actions = {
				Icon(
					imageVector = Icons.Default.Android,
					contentDescription = "Android Icon",
					modifier = Modifier
						.padding(end = 16.dp)
				)
			},
		)
		//Add text field
		Column(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			NoteInputText(
				modifier = Modifier.padding(
					top = 9.dp,
					bottom = 8.dp
				),
				text = title,
				label = "Title",
				onTextChange = {
					if (it.all { char ->
							char.isLetter() || char.isWhitespace()
						}) title = it
				})
			NoteInputText(
				modifier = Modifier.padding(
					top = 9.dp,
					bottom = 8.dp
				),
				text = description,
				label = "Add a note",
				maxLine = 10,
				onTextChange = {
					if (it.all { char ->
							char.isLetter() || char.isWhitespace()
						}) description = it
				})
			// Add a Button
			NoteButton(
				text = "Save",
				onClick = {
					if (title.isNotEmpty()
						&& description.isNotEmpty()
					) {
						onAddNote(Note(title = title, description = description))
						description = ""
						title = ""
						Toast.makeText(context, "Scribe, your Note is Saved", Toast.LENGTH_SHORT)
							.show()
					}
				},
			)
		}
		Divider(modifier = Modifier.padding(10.dp))
		LazyColumn {
			items(notes) { note ->
				NoteRow(
					note = note,
					onNoteClicked = {
						onRemoveNote(note)
					})
			}
		}
	}
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NoteScreenPreview() {
	NoteScreen(notes = NotesDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}