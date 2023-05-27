package com.android.jetpackcomposedemo.data.api.navigation

object Routes {
const val user ="user_route"
const val userListRoute = "user_list_route"
const val userDetailRoute = "user_detail_route/"
const val userDetailRouteWithArg="user_detail_route/{${RouteArgs.userId}}"

const val starWarRoute = "star_war_route"
const val peopleListRoute = "people_list_route"
const val peopleDetailRoute = "people_detail_route/"
const val peopleDetailRouteWithArg = "people_detail_route/{${RouteArgs.peopleUrl}}"
}

object RouteArgs {
    const val userId = "userId"
    const val peopleUrl = "peopleUrl"
}

