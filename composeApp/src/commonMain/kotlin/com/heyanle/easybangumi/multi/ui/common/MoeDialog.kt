package com.heyanle.easybangumi.multi.ui.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties
import com.heyanle.easybangumi.multi.utils.stringOrResource
import easybangumi.composeapp.generated.resources.Res
import easybangumi.composeapp.generated.resources.cancel
import easybangumi.composeapp.generated.resources.confirm
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi

val moeDialogQueue = mutableStateListOf<MoeDialogData>()

@OptIn(ExperimentalResourceApi::class)
data class MoeDialogData constructor(
    val text: @Composable ((MoeDialogData) -> Unit)? = null,
    val title: @Composable ((MoeDialogData) -> Unit)? = null,
    val modifier: Modifier = Modifier,
    val onDismiss: ((MoeDialogData) -> Unit)? = null,
    val onConfirm: ((MoeDialogData) -> Unit)? = null,
    val dismissLabel: Any = Res.string.cancel,
    val confirmLabel: Any = Res.string.confirm,
    val properties: DialogProperties = DialogProperties(),
    val content: @Composable ((MoeDialogData) -> Unit)? = null,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoeDialog() {
    moeDialogQueue.forEach {
        if (it.content == null) {
            AlertDialog(
                modifier = it.modifier,
                onDismissRequest = { it.dismiss() },
                properties = it.properties,
                title = {
                    it.title?.invoke(it)
                },
                text = {
                    it.text?.invoke(it)
                },
                confirmButton = {
                    if (it.onConfirm != null) {
                        TextButton(onClick = {
                            it.onConfirm.invoke(it)
                            it.dismiss()
                        }) {
                            Text(text = stringOrResource( it.confirmLabel))
                        }
                    }
                },
                dismissButton = {
                    it.onDismiss?.run {
                        TextButton(onClick = {
                            it.onDismiss.invoke(it)
                            it.dismiss()
                        }) {
                            Text(text = stringOrResource( it.dismissLabel))
                        }
                    }
                }
            )
        } else {
            BasicAlertDialog(
                onDismissRequest = { it.dismiss() },
                properties = it.properties,
                modifier = it.modifier,
                content = { it.content.invoke(it) }
            )
        }
    }
}

fun MoeDialogData.dismiss() = apply {
    mainMoeScope.launch {
        moeDialogQueue.remove(this@dismiss)
    }
}

fun MoeDialogData.show() = apply {
    mainMoeScope.launch {
        moeDialogQueue.add(this@show)
    }
}

@OptIn(ExperimentalResourceApi::class)
fun String.moeDialog(
    title: String? = null,
    onConfirm: ((MoeDialogData) -> Unit)? = null,
    onDismiss: ((MoeDialogData) -> Unit)? = null,
    confirmLabel: Any = Res.string.confirm,
    dismissLabel: Any = Res.string.cancel,
    modifier: Modifier = Modifier,
    properties: DialogProperties = DialogProperties(),
    content: @Composable ((MoeDialogData) -> Unit)? = null,
) = MoeDialogData(
    { Text(text = this) },
    { title?.let { Text(text = it) } },
    modifier,
    onDismiss,
    onConfirm,
    dismissLabel,
    confirmLabel,
    properties,
    content = content
).apply { show() }

fun Any?.dialog() = this.toString().moeDialog()