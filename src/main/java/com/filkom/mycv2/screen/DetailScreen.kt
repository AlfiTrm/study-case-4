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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.filkom.mycv2.ui.daftar.DaftarViewModel

@Composable
fun DetailScreen(
    onBackToLogin: () -> Unit,
    vm: DaftarViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("DETAIL", fontSize = 20.sp, textAlign = TextAlign.Center)
        Spacer(Modifier.height(12.dp))

        Text("NIM: ${vm.nim.value}", fontSize = 14.sp)
        Text("Nama: ${vm.nama.value}", fontSize = 14.sp)
        Text("Email: ${vm.email.value}", fontSize = 14.sp)
        Text("Alamat: ${vm.alamat.value}", fontSize = 14.sp)

        Spacer(Modifier.height(20.dp))
        Button(
            onClick = onBackToLogin,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("KEMBALI KE LOGIN")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailPreview() {
    DetailScreen(onBackToLogin = {})
}
