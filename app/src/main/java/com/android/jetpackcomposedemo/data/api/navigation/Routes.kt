package com.android.jetpackcomposedemo.data.api.navigation

object Routes {
const val userRoute ="user_route"
const val userListRoute = "user_list_route"
const val profileScreen = "profileScreen"
const val profileScreenWithArg="profileScreen/{${RouteArgs.firstName}}"

const val starWarRoute = "star_war_route"
const val peopleListRoute = "people_list_route"
const val peopleDetailRoute = "people_detail_route/"
const val peopleDetailRouteWithArg = "people_detail_route/{${RouteArgs.peopleUrl}}"
}

object RouteArgs {
    const val firstName = "firstName"
    const val peopleUrl = "peopleUrl"
}

