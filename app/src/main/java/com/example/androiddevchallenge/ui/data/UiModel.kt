package com.example.androiddevchallenge.ui.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UiModel : ViewModel() {

    var currentScreen by mutableStateOf(PuppiesScreen() as ScreenData)
        private set

    private val backStack = arrayListOf<ScreenData>()

    val isRootScreen
        get() = backStack.isEmpty()

    private fun setScreen(screen: ScreenData) {
        backStack.clear()
        currentScreen = screen
    }

    fun addScreen(screen: ScreenData) {
        backStack.add(currentScreen)
        currentScreen = screen
    }

    fun closeScreen(): Boolean = if ( backStack.size > 0 ) {
        currentScreen = backStack.removeLast()
        true
    } else false

}