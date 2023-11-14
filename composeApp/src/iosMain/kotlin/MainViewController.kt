import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.ComposeUIViewController
import presentation.view_model.home.HomeScreenEffect
import presentation.view_model.home.HomeViewModel
import presentation.view_model.home.HomeViewModelImpl

fun MainViewController(
    homeViewModel: HomeViewModel,
) = ComposeUIViewController {
    with(HomeViewModelImpl()) {

        val homeScreenState by container
            .stateFlow
            .collectAsState()

        val homeScreenEffect by container
            .sideEffectFlow
            .collectAsState(initial = HomeScreenEffect.Idle)

        App(
            homeScreenState = homeScreenState,
            homeScreenEffect = homeScreenEffect,
            homeScreenIntents = this
        )
    }
}
