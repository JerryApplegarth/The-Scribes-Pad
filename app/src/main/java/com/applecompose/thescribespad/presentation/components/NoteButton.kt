package com.applecompose.thescribespad.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.applecompose.thescribespad.ui.theme.buttonColor

@Composable
fun NoteButton(
	modifier: Modifier = Modifier,
	text: String,
	onClick: () -> Unit,
	enabled: Boolean = true,

) {
	Button(
		onClick = onClick,

		shape = RoundedCornerShape(6.dp),
		enabled = enabled,

		modifier = modifier,
		colors = ButtonDefaults.buttonColors(MaterialTheme.colors.buttonColor)

		) {
		Text(text = text)

	}

}