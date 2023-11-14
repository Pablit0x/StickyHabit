package presentation.view_model.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.container
import presentation.view_model.CommonViewModel

actual abstract class HomeViewModel actual constructor() :
    ViewModel(),
    CommonViewModel<HomeScreenState, HomeScreenEffect>,
    HomeScreenIntents {
    actual final override val scope: CoroutineScope
        get() = viewModelScope
    actual override val container: Container<HomeScreenState, HomeScreenEffect>
        get() = scope.container(HomeScreenState())
}
