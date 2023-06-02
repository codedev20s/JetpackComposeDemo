package com.android.jetpackcomposedemo.data.api.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.navigation
import com.android.jetpackcomposedemo.login.presentation.CreateUI

fun NavGraphBuilder.userGraph(navController: NavController) {
    navigation(startDestination = Routes.userListRoute, route = Routes.userRoute) {
        composable(route=Routes.userListRoute, arguments = listOf()) {
            CreateUI(){
            }
        }
        composable(route = Routes.userDetailRouteWithArg,
            arguments = listOf(navArgument("userid") {
                type = NavType.LongType
            })) {
       // UserDetailPage()
        }
    }
}

@Composable
fun UserNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Routes.userRoute,
        modifier = modifier)
    {
        userGraph(navController)
    }
}

