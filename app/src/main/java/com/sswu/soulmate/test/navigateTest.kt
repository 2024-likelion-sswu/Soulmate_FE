package com.sswu.soulmate.test

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sswu.soulmate.main.TabRoute
import kotlinx.serialization.Serializable

fun NavController.navigateTest(
    navOptions: NavOptions
) {
    navigate(Test, navOptions)
}

fun NavGraphBuilder.testNavGraph(
    paddingValues: PaddingValues,
) {
    composable<Test> {
        TestRoute(paddingValues = paddingValues)
    }
}

@Serializable
data object Test : TabRoute
