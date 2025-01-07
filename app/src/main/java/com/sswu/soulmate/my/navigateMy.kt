package com.sswu.soulmate.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sswu.soulmate.main.TabRoute
import com.sswu.soulmate.my.RegistRoute
import kotlinx.serialization.Serializable

fun NavController.navigateMy(
    navOptions: NavOptions
) {
    navigate(My, navOptions)
}

fun NavController.navigateRegist(
    navOptions: NavOptions
) {
    navigate(Regist, navOptions)
}

fun NavGraphBuilder.myNavGraph(
    paddingValues: PaddingValues,
    navigateToMy: () -> Unit
) {
    composable<My> {
        MyRoute(paddingValues = paddingValues)
    }
    composable<Regist> {
        RegistRoute(paddingValues = paddingValues, navigateToMy = navigateToMy)
    }
}

@Serializable
data object My : TabRoute

@Serializable
data object Regist : TabRoute
