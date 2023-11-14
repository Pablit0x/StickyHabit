package presentation.view_model.home

import kotlinx.coroutines.Job

interface HomeScreenIntents {
    fun onButtonClicked(): Job
}