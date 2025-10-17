package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.filkom.mycv2.ui.daftar.DaftarViewModel

@Composable
fun DaftarScreen(
    onSimpan: () -> Unit,
    vm: DaftarViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("DAFTAR")

        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = vm.nim.value,
            onValueChange = { vm.nim.value = it; vm.nimError.value = null },
            label = { Text("NIM") },
            isError = vm.nimError.value != null,
            modifier = Modifier.fillMaxWidth()
        )
        vm.nimError.value?.let {
            Spacer(Modifier.height(4.dp))
            Text(it, color = MaterialTheme.colorScheme.error)
        }

        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = vm.nama.value,
            onValueChange = { vm.nama.value = it; vm.namaError.value = null },
            label = { Text("Nama") },
            isError = vm.namaError.value != null,
            modifier = Modifier.fillMaxWidth()
        )
        vm.namaError.value?.let {
            Spacer(Modifier.height(4.dp))
            Text(it, color = MaterialTheme.colorScheme.error)
        }

        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = vm.email.value,
            onValueChange = { vm.email.value = it; vm.emailError.value = null },
            label = { Text("Email") },
            isError = vm.emailError.value != null,
            modifier = Modifier.fillMaxWidth()
        )
        vm.emailError.value?.let {
            Spacer(Modifier.height(4.dp))
            Text(it, color = MaterialTheme.colorScheme.error)
        }

        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = vm.alamat.value,
            onValueChange = { vm.alamat.value = it; vm.alamatError.value = null },
            label = { Text("Alamat") },
            isError = vm.alamatError.value != null,
            modifier = Modifier.fillMaxWidth()
        )
        vm.alamatError.value?.let {
            Spacer(Modifier.height(4.dp))
            Text(it, color = MaterialTheme.colorScheme.error)
        }

        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                if (vm.onSimpan()) onSimpan()
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("SIMPAN") }
    }
}

@Preview
@Composable
private fun DaftarPreview() {
    DaftarScreen(onSimpan = {})
}
