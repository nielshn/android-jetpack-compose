package com.dicoding.mynavdrawer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Management State dan State Holder

class FormInputState(initialInput: String) {
    var input by mutableStateOf(initialInput)
}

@Composable
fun rememberFormInputState(input: String): FormInputState = remember(input) {
    FormInputState(input)
}


@Composable
fun FormInput(state: FormInputState = rememberFormInputState("")) {
    OutlinedTextField(
        value = state.input,
        onValueChange = {state.input = it},
        label = { Text("Nama") },
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun MyForm() {
    val input = rememberFormInputState("")
    FormInput(state = input)
}

