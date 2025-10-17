package com.filkom.mycv2.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filkom.mycv2.data.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)

class AuthViewModel(
    private val repo: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChange(v: String) = _uiState.update { it.copy(email = v, error = null) }
    fun onPasswordChange(v: String) = _uiState.update { it.copy(password = v, error = null) }

    fun submitLogin() {
        val s = _uiState.value
        if (s.email.isBlank() || s.password.length < 6) {
            _uiState.update { it.copy(error = "Email ga boleh kosong & password ≥ 6") }
            return
        }
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true, error = null) }
            val ok = repo.login(s.email, s.password)
            _uiState.update {
                it.copy(
                    loading = false,
                    success = ok,
                    error = if (!ok) "Email/Password salah (dummy)" else null
                )
            }
        }
    }

    fun consumeSuccess() {
        _uiState.update { it.copy(success = false) }
    }
}
