package com.sswu.soulmate.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sswu.soulmate.main.TabRoute
import kotlinx.serialization.Serializable

fun NavController.navigateMy(
    navOptions: NavOptions
) {
    navigate(My, navOptions)
}

fun NavGraphBuilder.myNavGraph(
    paddingValues: PaddingValues,
) {
    composable<My> {
        MyRoute(paddingValues = paddingValues)
    }
}

@Serializable
data object My : TabRoute
