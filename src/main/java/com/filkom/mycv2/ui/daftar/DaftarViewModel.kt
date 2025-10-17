package com.filkom.mycv2.ui.daftar

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DaftarViewModel : ViewModel() {
    var nim = mutableStateOf("")
    var nama = mutableStateOf("")
    var email = mutableStateOf("")
    var alamat = mutableStateOf("")

    var nimError = mutableStateOf<String?>(null)
    var namaError = mutableStateOf<String?>(null)
    var emailError = mutableStateOf<String?>(null)
    var alamatError = mutableStateOf<String?>(null)

    fun onSimpan(): Boolean {
        nimError.value = null
        namaError.value = null
        emailError.value = null
        alamatError.value = null

        val nNim = nim.value.trim()
        val nNama = nama.value.trim()
        val nEmail = email.value.trim()
        val nAlamat = alamat.value.trim()

        var ok = true
        if (nNim.isBlank())   { nimError.value = "NIM wajib diisi"; ok = false }
        if (nNama.isBlank())  { namaError.value = "Nama wajib diisi"; ok = false }
        if (nEmail.isBlank()) { emailError.value = "Email wajib diisi"; ok = false }
        else if (!Patterns.EMAIL_ADDRESS.matcher(nEmail).matches()) {
            emailError.value = "Format email tidak valid"; ok = false
        }
        if (nAlamat.isBlank()){ alamatError.value = "Alamat wajib diisi"; ok = false }

        return ok
    }

    fun clearForm() {
        nim.value = ""
        nama.value = ""
        email.value = ""
        alamat.value = ""

        nimError.value = null
        namaError.value = null
        emailError.value = null
        alamatError.value = null
    }
}
