import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.view_model.home.HomeScreenEffect
import presentation.view_model.home.HomeScreenIntents
import presentation.view_model.home.HomeScreenState

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(
    homeScreenState: HomeScreenState,
    homeScreenEffect: HomeScreenEffect,
    homeScreenIntents: HomeScreenIntents,
) {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                homeScreenIntents.onButtonClicked()
            }) {
                Text(homeScreenState.message)
            }
            AnimatedVisibility(homeScreenState.isImageDisplayed){
                Image(
                    painterResource("compose-multiplatform.xml"),
                    null
                )
            }
        }
    }
}