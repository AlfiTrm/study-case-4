package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun detail(onDaftar: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "DETAIL",
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "NIM: 2251506000001", fontSize = 14.sp)
        Text(text = "Nama: Tsan", fontSize = 14.sp)
        Text(text = "Email: tsan@example.com", fontSize = 14.sp)
        Text(text = "Alamat: Malang", fontSize = 14.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onDaftar() }) {
            Text("DAFTAR")
        }
    }
}

@Preview
@Composable
fun detailPreview() {
    detail({})
}
