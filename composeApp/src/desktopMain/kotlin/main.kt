import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.runBlocking

fun main() = application {
    runBlocking {
        Scheduler.runOnAppInit()
    }
    Window(onCloseRequest = ::exitApplication, title = "EasyBangumi") {
        LaunchedEffect(Unit){
            Scheduler.runOnAppCreate()
        }
        App()
    }
}