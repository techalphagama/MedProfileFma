package com.alpharays.mymedprofilefma.profilefma.profile.v2.di


import com.alpharays.mymedprofilefma.profilefma.profile.v2.modules.profile.ProfileFeatureApi




object DependencyProviderProfile {

    private lateinit var profileFeatureApi: ProfileFeatureApi

    fun provideImpl(
        profileFeatureApi: ProfileFeatureApi,
    ) {
        DependencyProviderProfile.profileFeatureApi = profileFeatureApi
    }

    fun profileFeature(): ProfileFeatureApi = profileFeatureApi


}