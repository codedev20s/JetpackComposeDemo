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
import com.android.jetpackcomposedemo.login.data.LoginResonse
import com.android.jetpackcomposedemo.login.presentation.CreateUI
import com.android.jetpackcomposedemo.login.presentation.LoginViewModel
import com.android.jetpackcomposedemo.profile.CreateProfileCard

fun NavGraphBuilder.userGraph(navController: NavController, loginViewModel: LoginViewModel) {
    navigation(startDestination = Routes.userListRoute, route = Routes.userRoute) {
        composable(route = Routes.userListRoute, arguments = listOf()) {
            CreateUI(loginViewModel = loginViewModel) {
                navController.navigate(Routes.profileScreenWithArg + it.firstName)
            }
        }
        composable(
            route = Routes.profileScreenWithArg,
            arguments = listOf(navArgument("firstName") { type = NavType.StringType })
        ) {
            CreateProfileCard()
        }
    }
}

@Composable
fun UserNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Routes.userRoute,
        modifier = modifier
    )
    {
        userGraph(navController, loginViewModel)
    }
}

