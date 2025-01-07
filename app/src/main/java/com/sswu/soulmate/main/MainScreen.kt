package com.sswu.soulmate.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.sswu.soulmate.home.homeNavGraph
import com.sswu.soulmate.home.matchNavGraph
import com.sswu.soulmate.home.myNavGraph
import com.sswu.soulmate.test.testNavGraph
import org.sopt.and.feature.main.MainNavigation
import org.sopt.and.feature.main.rememberMainNavigator

@Composable
fun MainScreen(
    navigator: MainNavigation = rememberMainNavigator()
) {
    Scaffold(
        content = { innerPadding ->
            NavHost(
                navController = navigator.navController,
                startDestination = navigator.startDestination
            ) {
                homeNavGraph(
                    paddingValues = innerPadding
                )
                matchNavGraph(
                    paddingValues = innerPadding,
                    navigateToTest = { navigator.navigateToTest() },
                    navigateToMatchResult = { navigator.navigateToMatchResult() }
                )
                myNavGraph(
                    paddingValues = innerPadding,
                )
                testNavGraph(
                    paddingValues = innerPadding,
                )
            }
        },
        bottomBar = {
            MainBottomBar(
                isVisible = navigator.shouldShowBottomBar(),
                tabs = MainBottomTab.entries.toList(),
                currentTab = navigator.currentTab,
                onTabSelected = { selectedTab -> navigator.navigate(selectedTab) }
            )
        }
    )
}


