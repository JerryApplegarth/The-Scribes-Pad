package com.applecompose.thescribespad.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applecompose.thescribespad.R
import com.applecompose.thescribespad.presentation.components.NoteButton
import com.applecompose.thescribespad.presentation.components.NoteInputText
import com.applecompose.thescribespad.ui.theme.newBackgroundColor
import com.applecompose.thescribespad.ui.theme.topbarColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteScreen() {

	var title by remember { mutableStateOf("") }
	var description by remember { mutableStateOf("") }

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
					bottom = 8.dp),
				text = title,
				label = "Title",
				onTextChange = {
					if (it.all { char ->
							char.isLetter() || char.isWhitespace()
						}) title = it
				} )

			NoteInputText(
				modifier = Modifier.padding(
					top = 9.dp,
					bottom = 8.dp),
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
				onClick = { /*TODO*/ },

				)

		}
	}

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NoteScreenPreview() {
	NoteScreen()
}