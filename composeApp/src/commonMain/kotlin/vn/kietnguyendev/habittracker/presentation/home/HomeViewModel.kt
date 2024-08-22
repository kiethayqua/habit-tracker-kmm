package vn.kietnguyendev.habittracker.presentation.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onClickPlus() {
        _uiState.value = _uiState.value.copy(count = _uiState.value.count + 1)
    }

    fun onClickMinus() {
        _uiState.value = _uiState.value.copy(count = _uiState.value.count - 1)
    }
}