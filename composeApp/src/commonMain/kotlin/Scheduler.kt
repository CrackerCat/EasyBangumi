import com.heyanle.inject.core.Inject
import module.getPlatformModules
import module.getPlatformRootModules

/**
 * Created by heyanlin on 2024/4/23.
 */
object Scheduler {

    fun runOnAppInit() {
       getPlatformRootModules().forEach {
            it.registerWith(Inject)
        }
    }

    fun runOnAppCreate() {
        getPlatformModules().forEach {
            it.registerWith(Inject)
        }
    }

}