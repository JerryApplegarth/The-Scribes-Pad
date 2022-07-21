package com.applecompose.thescribespad.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.applecompose.thescribespad.data.model.Note
import com.applecompose.thescribespad.domain.utils.formatDate
import com.applecompose.thescribespad.ui.theme.cardBackground

@Composable
fun NoteRow(
	modifier: Modifier = Modifier,
	note: Note,
	onNoteClicked: (Note) -> Unit
) {
	Surface(
		modifier
			.padding(6.dp)
			.clip(
				RoundedCornerShape(CornerSize(16.dp)),
				)
			.fillMaxWidth(),
		color = MaterialTheme.colors.cardBackground,
		elevation = 6.dp
	) {
		Column(
			modifier = Modifier
				.padding(horizontal = 14.dp, vertical = 6.dp),
			horizontalAlignment = Alignment.Start
		) {
			Text(
				text = note.title,
				style = MaterialTheme.typography.h6
				)
			Text(
				text = note.description,
				style = MaterialTheme.typography.body2
				)
			Text(
				text = formatDate(note.entryDate.time),
				style = MaterialTheme.typography.caption
				)
			Icon(

				imageVector = Icons.Default.Delete,
				contentDescription = "Delete Icon",
				tint = Color.DarkGray,
				modifier = Modifier
					.padding(end = 16.dp)
					.align(Alignment.End)
					.clickable {
						onNoteClicked(note)
					}

				)
		}
	}
}