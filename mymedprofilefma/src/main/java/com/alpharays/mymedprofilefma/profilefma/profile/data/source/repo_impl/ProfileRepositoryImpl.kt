package com.alpharays.mymedprofilefma.profilefma.profile.data.source.repo_impl

import com.alpharays.alaskagemsdk.network.ResponseHandler
import com.alpharays.alaskagemsdk.network.ResponseResult
import com.alpharays.mymedprofilefma.profilefma.profile.data.source.remote.ProfileApiServices
import com.alpharays.mymedprofilefma.profilefma.profile.data.source.room.MedicoDao
import com.alpharays.mymedprofilefma.profilefma.profile.data.source.room.MedicoPatientProfileTable
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.profilescreen.Profile
import com.alpharays.mymedprofilefma.profilefma.profile.domain.model.profilescreen.userposts.UserCommunityPostsParent
import com.alpharays.mymedprofilefma.profilefma.profile.domain.repository.ProfileRepository
import com.alpharays.mymedprofilefma.profilefma.profile.profile_utils.util.ProfileConstants.SOMETHING_WENT_WRONG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileApiServices: ProfileApiServices,
    private val responseHandler: ResponseHandler,
    private val medicoDao: MedicoDao,
) : ProfileRepository {
    override suspend fun getProfileInfo(token: String): ResponseResult<Profile> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                responseHandler.callAPI {
                    withContext(Dispatchers.IO) {
                        profileApiServices.getProfileInfo(token)
                    }
                }
            } catch (e: Exception) {
                ResponseResult.Error(SOMETHING_WENT_WRONG)
            }
        }

    override suspend fun updateProfileInfo(
        profileInfo: Profile,
        token: String,
    ): ResponseResult<Profile> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                responseHandler.callAPI {
                    withContext(Dispatchers.IO) {
                        profileApiServices.updateProfileInfo(profileInfo, token)
                    }
                }
            } catch (e: Exception) {
                ResponseResult.Error(SOMETHING_WENT_WRONG)
            }
        }

    override suspend fun getMyCommunityPosts(docId: String): ResponseResult<UserCommunityPostsParent> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                responseHandler.callAPI {
                    withContext(Dispatchers.IO) {
                        profileApiServices.getMyAllPosts(docId)
                    }
                }
            } catch (e: Exception) {
                ResponseResult.Error(SOMETHING_WENT_WRONG)
            }
        }

    override suspend fun setCachedProfile(profile: MedicoPatientProfileTable) {
        withContext(Dispatchers.IO) {
            medicoDao.setPatientProfile(profile)
        }
    }

    override suspend fun getCachedProfile(): MedicoPatientProfileTable? {
        return try {
            medicoDao.getPatientProfile()
        } catch (e: Exception) {
            println(e.printStackTrace())
            null
        }
    }
}