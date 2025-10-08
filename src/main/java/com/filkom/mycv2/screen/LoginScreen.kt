package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Login(onLogin: () -> Unit, onDaftar: () -> Unit) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "LOGIN")

        OutlinedTextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text("NIM") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        )

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        )

        Button(
            modifier = Modifier.padding(top = 16.dp),
            onClick = { onLogin() }
        ) {
            Text("LOGIN")
        }

        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = { onDaftar() }
        ) {
            Text("DAFTAR")
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    Login({}, {})
}
