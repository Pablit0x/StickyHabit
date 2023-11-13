package presentation.view_model.home

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.container
import presentation.view_model.CommonViewModel

actual abstract class HomeViewModel actual constructor() :
    CommonViewModel<HomeScreenState, HomeScreenEffect>,
    HomeScreenIntents {
    actual final override val scope: CoroutineScope
        get() = CoroutineScope(Dispatchers.Unconfined + Job())
    actual override val container: Container<HomeScreenState, HomeScreenEffect>
        get() = scope.container(HomeScreenState())
}