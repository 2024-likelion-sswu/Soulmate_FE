package com.sswu.soulmate.main

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.sswu.soulmate.R

enum class MainBottomTab(
    @DrawableRes val icon: Int,
    val title: String,
    val route: TabRoute,
) {
    Match(
        icon = R.drawable.ic_match,
        title = "match",
        route = com.sswu.soulmate.home.Match,
    ),
    Home(
        icon = R.drawable.ic_home,
        title = "home",
        route = com.sswu.soulmate.home.Home,
    ),
    My(
        icon = R.drawable.ic_my,
        title = "mypage",
        route = com.sswu.soulmate.home.My,
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (TabRoute) -> Boolean): MainBottomTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (TabRoute) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}

