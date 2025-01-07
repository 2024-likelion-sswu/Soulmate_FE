package org.sopt.and.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.sswu.soulmate.home.Home
import com.sswu.soulmate.home.navigateHome
import com.sswu.soulmate.home.navigateMatch
import com.sswu.soulmate.home.navigateMatchResult
import com.sswu.soulmate.home.navigateMy
import com.sswu.soulmate.home.navigateRegist
import com.sswu.soulmate.main.MainBottomTab
import com.sswu.soulmate.main.TabRoute
import com.sswu.soulmate.test.navigateTest

class MainNavigation(
    val navController: NavHostController,
    val startDestination: TabRoute
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTab: MainBottomTab?
        @Composable
        get() = MainBottomTab.find { tab ->
            currentDestination?.hasRoute(tab::class) == true
        }

    val navOptions = navOptions {
        popUpTo<Home> {
            inclusive = false
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

    fun navigate(tab: MainBottomTab) {
        when (tab) {
            MainBottomTab.Home -> navController.navigateHome(navOptions = navOptions)

            MainBottomTab.Match -> navController.navigateMatch(navOptions = navOptions)

            MainBottomTab.My -> navController.navigateRegist(navOptions = navOptions)
        }
    }

    fun navigateUp() {
        navController.navigateUp()
    }

    fun navigateToHome() {
        navController.navigateHome(navOptions = navOptions)
    }

    fun navigateToMatch() {
        navController.navigateMatch(navOptions = navOptions)
    }

    fun navigateToMy() {
        navController.navigateMy(navOptions = navOptions)
    }

    fun navigateToTest() {
        navController.navigateTest(navOptions = navOptions)
    }

    fun navigateToMatchResult() {
        navController.navigateMatchResult(navOptions = navOptions)
    }

    @Composable
    fun shouldShowBottomBar() = MainBottomTab.contains {
        currentDestination?.hasRoute(it::class) == true

    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigation = remember(navController) {
    val startDestination = Home
    MainNavigation(navController, startDestination)
}
