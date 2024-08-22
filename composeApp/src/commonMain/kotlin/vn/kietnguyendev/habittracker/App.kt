package vn.kietnguyendev.habittracker

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import vn.kietnguyendev.habittracker.presentation.home.HomeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        HomeScreen()
    }
}