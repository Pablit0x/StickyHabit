package presentation.view_model.home

import getPlatform
import kotlinx.coroutines.CoroutineScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import presentation.view_model.CommonViewModel

expect abstract class HomeViewModel() : CommonViewModel<HomeScreenState, HomeScreenEffect>,
    HomeScreenIntents {
    final override val scope: CoroutineScope
    override val container: Container<HomeScreenState, HomeScreenEffect>
}

class HomeViewModelImpl : HomeViewModel() {
    private val platform = getPlatform()

    override fun onButtonClicked() = intent {
        reduce {
            state.copy(
                message = "Compose: Hello, ${platform.name}!",
                isImageDisplayed = !state.isImageDisplayed,
            )
        }
    }
}