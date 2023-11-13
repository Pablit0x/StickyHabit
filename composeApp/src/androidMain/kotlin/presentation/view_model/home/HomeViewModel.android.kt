package presentation.view_model.home

import kotlinx.coroutines.CoroutineScope
import org.orbitmvi.orbit.Container
import presentation.view_model.CommonViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.container

actual abstract class HomeViewModel actual constructor() :
    ViewModel(),
    CommonViewModel<HomeScreenState, HomeScreenEffect>,
    HomeScreenIntents {
    actual final override val scope: CoroutineScope
        get() = viewModelScope
    actual override val container: Container<HomeScreenState, HomeScreenEffect>
        get() = scope.container(HomeScreenState())
}