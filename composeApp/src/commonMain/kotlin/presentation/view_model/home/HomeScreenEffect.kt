package presentation.view_model.home

sealed class HomeScreenEffect {
    data object Idle : HomeScreenEffect()
}