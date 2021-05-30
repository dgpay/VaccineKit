package academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.network

import academy.bangkit.project.capstone.vaccinekit.core.data.source.local.entity.VaccineEntity
import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.VaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.VerifResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("verification_account_using_nik")
    suspend fun getVerifNik(
        @Query("nik") nik: String
    ): VerifResponse

    @GET("get_vaccine_data")
    suspend fun getVaccine(
        @Query("nik") nik: String
    ): VaccineResponse

    @POST("get_vaccine_data")
    suspend fun postVaccine(
    ): VaccineResponse
}