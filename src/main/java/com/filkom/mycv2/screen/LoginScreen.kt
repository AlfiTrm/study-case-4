package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Login(onLogin: () -> Unit, onDaftar:()-> Unit)
{
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Text(text = "LOGIN")
        OutlinedTextField(
            value = "email",
            onValueChange = {},
            label = { Text("email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
        OutlinedTextField(
            value = "passwd",
            onValueChange = { },
            label = { Text("password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )

        Button (
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 10.dp),
            onClick = {onLogin})
        {
            Text("LOGIN")
        }
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {onDaftar})
        {
            Text("DAFTAR")
        }
    }
}

@Preview
@Composable
fun loginPreview() {
    Login({},{})
}