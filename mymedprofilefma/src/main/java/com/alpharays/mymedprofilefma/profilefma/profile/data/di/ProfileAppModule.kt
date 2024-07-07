package com.alpharays.mymedprofilefma.profilefma.profile.data.di

import com.alpharays.alaskagemsdk.network.ResponseHandler
import com.alpharays.mymedprofilefma.MedProfileFmaRouter.context
import com.alpharays.mymedprofilefma.profilefma.profile.data.source.remote.ProfileApiServices
import com.alpharays.mymedprofilefma.profilefma.profile.data.source.repo_impl.ProfileRepositoryImpl
import com.alpharays.mymedprofilefma.profilefma.profile.data.source.room.MedicoDao
import com.alpharays.mymedprofilefma.profilefma.profile.data.source.room.MedicoDatabase
import com.alpharays.mymedprofilefma.profilefma.profile.domain.repository.ProfileRepository
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.API_SAFE_KEY
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.API_SAFE_KEY_VALUE
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.BASE_URL
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProfileAppModule {
    @Provides
    @Singleton
    fun provideHttpClient(): ProfileApiServices {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        // Create an OkHttpClient with an interceptor to add the token header
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val newRequest = originalRequest.newBuilder()
                    .header(
                        API_SAFE_KEY,
                        API_SAFE_KEY_VALUE
                    )
                    .build()
                chain.proceed(newRequest)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setLenient().setPrettyPrinting().create()
                )
            )
            .build()
            .create(ProfileApiServices::class.java)
    }


    @Provides
    @Singleton
    fun provideMedicoDao(
    ): MedicoDao {
        return MedicoDatabase.getDatabase(context).medicoDao()
    }

    @Provides
    @Singleton
    fun provideHomeRepository(
        apiServices: ProfileApiServices,
        medicoDao: MedicoDao,
    ): ProfileRepository {
        return ProfileRepositoryImpl(apiServices, ResponseHandler(), medicoDao)
    }

}