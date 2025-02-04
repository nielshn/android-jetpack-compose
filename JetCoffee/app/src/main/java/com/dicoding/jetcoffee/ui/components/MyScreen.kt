package com.dicoding.jetcoffee.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.jetcoffee.ui.theme.JetCoffeeTheme

@Composable
fun MyScreen() {
    // state hanya ada di MyScreen
    var checked by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
        MySwitch(checked = checked, onCheckChanged = { checked = it })
        Text(
            text = if (checked) "ON" else "OFF",
            Modifier.clickable {
                checked = !checked
            }
        )
    }
}

// checked bersifat Immutable (tidak dapat diubah)
@Composable
fun MySwitch(checked: Boolean, onCheckChanged: (Boolean) -> Unit) {
    Switch(
        checked = checked,
        onCheckedChange = {
            onCheckChanged(it)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    JetCoffeeTheme {
        MyScreen()
    }
}
