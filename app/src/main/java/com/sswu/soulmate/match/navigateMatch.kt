package com.sswu.soulmate.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sswu.soulmate.main.TabRoute
import com.sswu.soulmate.match.MatchResultRoute
import kotlinx.serialization.Serializable

fun NavController.navigateMatch(
    navOptions: NavOptions
) {
    navigate(Match, navOptions)
}

fun NavController.navigateMatchResult(
    navOptions: NavOptions
) {
    navigate(MatchResult, navOptions)
}

fun NavGraphBuilder.matchNavGraph(
    paddingValues: PaddingValues,
    navigateToTest: () -> Unit,
    navigateToMatchResult: () -> Unit,
) {
    composable<Match> {
        MatchRoute(
            paddingValues = paddingValues,
            navigateToMatchResult = navigateToMatchResult
        )
    }
    composable<MatchResult> {
        MatchResultRoute(
            paddingValues = paddingValues,
            navigateToTest = navigateToTest
        )
    }
}

@Serializable
data object Match : TabRoute

@Serializable
data object MatchResult : TabRoute
