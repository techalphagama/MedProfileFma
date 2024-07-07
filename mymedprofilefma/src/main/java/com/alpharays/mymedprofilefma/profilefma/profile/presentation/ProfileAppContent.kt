package com.alpharays.mymedprofilefma.profilefma.profile.presentation

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.navigation.AppNavGraph

@Composable
fun AppContent() {
    MaterialTheme {
        val navController = rememberNavController()
        Scaffold(modifier = Modifier.navigationBarsPadding()) { innerPaddingModifier ->
            AppNavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPaddingModifier)
            )
        }
    }
}