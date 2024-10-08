package vn.kietnguyendev.habittracker.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object HomeTab : Tab {
    @Composable
    override fun Content() {
        HomeScreen()
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "Home",
                    icon = icon
                )
            }
        }
}

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel { HomeViewModel() }) {
    val state = viewModel.uiState.collectAsState()
    val onClickPlus = remember { viewModel::onClickPlus }
    val onClickMinus = remember { viewModel::onClickMinus }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Row {
            Text("-", modifier = Modifier.clickable {
                onClickMinus()
            })
            Spacer(modifier = Modifier.width(8.dp))
            Text(state.value.count.toString())
            Spacer(modifier = Modifier.width(8.dp))
            Text("+", modifier = Modifier.clickable {
                onClickPlus()
            })
        }
    }
}