package ps.code.sticky_habit

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.Job
import presentation.view_model.home.HomeScreenEffect
import presentation.view_model.home.HomeScreenIntents
import presentation.view_model.home.HomeScreenState
import presentation.view_model.home.HomeViewModel
import presentation.view_model.home.HomeViewModelImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val homeViewModel by viewModels<HomeViewModel> {
            viewModelFactory {
                addInitializer(HomeViewModel::class) {
                    HomeViewModelImpl()
                }
            }
        }

        setContent {
            with(homeViewModel) {
                val homeScreenState by container.stateFlow.collectAsState()
                val homeScreenEffect by container.sideEffectFlow.collectAsState(initial = HomeScreenEffect.Idle)
                App(
                    homeScreenState = homeScreenState,
                    homeScreenEffect = homeScreenEffect,
                    homeScreenIntents = this,
                )
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(homeScreenState = HomeScreenState(),
        homeScreenEffect = HomeScreenEffect.Idle,
        homeScreenIntents = object : HomeScreenIntents {
            override fun onButtonClicked(): Job {
                TODO("Not yet implemented")
            }
        }
    )
}