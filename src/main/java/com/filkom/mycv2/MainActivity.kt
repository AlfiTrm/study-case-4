package com.filkom.mycv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.filkom.mycv2.screen.Login
import com.filkom.mycv2.screen.DaftarScreen
import com.filkom.mycv2.screen.DetailScreen
import com.filkom.mycv2.ui.daftar.DaftarViewModel
import com.filkom.mycv2.ui.theme.MyCV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCV2Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MyAppNavigation()
                }
            }
        }
    }
}

@Composable
fun MyAppNavigation() {
    val nav = rememberNavController()
    val daftarVM: DaftarViewModel = viewModel()

    NavHost(navController = nav, startDestination = "login") {

        composable("login") {
            Login(
                onLogin = { nav.navigate("daftar") { popUpTo("login") { inclusive = true } } },
                onDaftar = { nav.navigate("daftar") }
            )
        }

        composable("daftar") {
            DaftarScreen(
                onSimpan = { nav.navigate("detail") },
                vm = daftarVM
            )
        }

        composable("detail") {
            DetailScreen(
                vm = daftarVM,
                onBackToLogin = {
                    daftarVM.clearForm()
                    nav.navigate("login") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

    }
}
