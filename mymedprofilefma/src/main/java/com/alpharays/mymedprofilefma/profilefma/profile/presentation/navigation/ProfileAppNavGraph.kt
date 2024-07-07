package com.alpharays.mymedprofilefma.profilefma.profile.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alpharays.alaskagemsdk.core.register
import com.alpharays.mymedprofilefma.profilefma.profile.v2.di.DependencyProviderProfile


@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = DependencyProviderProfile.profileFeature().profileRoute
    ) {
        register(
            DependencyProviderProfile.profileFeature(),
            navController = navController,
            modifier = modifier
        )
    }

}

