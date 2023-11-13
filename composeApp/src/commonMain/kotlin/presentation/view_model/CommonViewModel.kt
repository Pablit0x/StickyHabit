package presentation.view_model

import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import kotlinx.coroutines.CoroutineScope

interface CommonViewModel<STATE : Any, SIDE_EFFECT : Any> : ContainerHost<STATE, SIDE_EFFECT> {
    val scope: CoroutineScope
    override val container: Container<STATE, SIDE_EFFECT>
}