package com.alpharays.mymedprofilefma.profilefma.profile.presentation.navigation

import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.PROFILE_SCREEN_ROUTE
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.UPDATE_PROFILE_SCREEN_ROUTE

sealed class AppScreens(val route: String) {
    data object ProfileScreen : AppScreens(PROFILE_SCREEN_ROUTE)
    data object UpdateProfileScreen : AppScreens(UPDATE_PROFILE_SCREEN_ROUTE)
}