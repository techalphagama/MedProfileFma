package com.alpharays.mymedprofilefma.profilefma.profile

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.alpharays.mymedprofilefma.profilefma.profile.presentation.AppContent
import com.alpharays.mymedprofilefma.profilefma.profile.v2.di.DependencyProviderProfile
import com.alpharays.mymedprofilefma.profilefma.profile.v2.navigation.ProfileFeatureImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DependencyProviderProfile.provideImpl(profileFeatureApi = ProfileFeatureImpl())
        setContent {
            MaterialTheme {
                WindowCompat.setDecorFitsSystemWindows(window, true)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent()
                }
            }
        }
    }
}
