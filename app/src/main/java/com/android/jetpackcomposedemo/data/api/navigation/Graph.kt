package com.android.jetpackcomposedemo.data.api.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
/*

fun NavGraphBuilder.userGraph(navController: NavController) {

    navigation(startDestination = Routes.userListRoute, route = Routes.userRoute) {
        composable(Routes.userListRoute, arguments = Listof()) {
        }
        UserListPage(
            onNavigateToDetail = { userId -> navController.navigate(Routes.userDetailRoute + userID) },
        )
    }
    composable(
        route = Routes.userDetailRouteWithArg,
        arguments = Listof(navArgument(name "userid") { type = NavType.LongType })
    ){
        UserDetailPage()
        }
    }
}

@Composable
    fun UserNavHost(
        navController: NavHostController,
        modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Routes.userRoute,
        modifier = modifier
    ) {
        userGraph(navController)
    }
}

fun NavGraphBuilder.starWarGraph(navController: NavController) {
    navigation(startDestination Routes.peopleListRoute, route Routes.starWarRoute) {
        composable(Routes.peopleListRoute, arguments = Listof()) {
            PeopleListPage(

            onavigateToletail = { userId ->
                //navController.navigate(Routes.userDetailRoute⚫ userId)

                    Composable
                    fun PeopleNaviost(
                        navController: NavHostController,
                        modifier:Modifier= Modidfier
                    ){
                        NavHost(
                            navController=navController,
                            startDestination=Routes.starWarRoute,
                            modifier=Modifier)
                        {starWarGraph(navController)}
                    }
            }


*/
