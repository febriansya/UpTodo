package com.example.uptodo.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration

sealed class WindowsSize(val size: Int) {
    data class Small(val smallSize: Int) : WindowsSize(smallSize)
    data class Compact(val compactSize: Int) : WindowsSize(compactSize)
    data class Medium(val mediumSize: Int) : WindowsSize(mediumSize)
    data class Large(val largeSize: Int) : WindowsSize(largeSize)

}

data class WindowSizeClass(
    val width: WindowsSize,
    val height: WindowsSize
)

@Composable
fun rememberWindowSizeClass(modifier: Modifier = Modifier): WindowSizeClass {

    val config = LocalConfiguration.current

    val width by remember(config) {
        mutableIntStateOf(config.screenWidthDp)
    }

    val height by remember(config) {
        mutableIntStateOf(config.screenHeightDp)
    }

    // portrait mode
    val windowWidthClass = when {
        width <= 360 -> WindowsSize.Small(width)
        width in 361..488 -> WindowsSize.Compact(width)
        width in 481..720 -> WindowsSize.Medium(width)
        else -> WindowsSize.Large(width)
    }

    // landscape mode
    val windowHeightClass = when {
        height <= 360 -> WindowsSize.Small(height)
        height in 361..488 -> WindowsSize.Compact(height)
        height in 481..720 -> WindowsSize.Medium(height)
        else -> WindowsSize.Large(height)
    }

    return WindowSizeClass(windowWidthClass, windowHeightClass)

}