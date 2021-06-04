package academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.network

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.*
import retrofit2.http.*

interface ApiService {

    @GET("verification_account_using_nik")
    suspend fun getVerifNik(
        @Query("nik") nik: String
    ): VerifResponse

    @GET("get_vaccine_data")
    suspend fun getVaccine(
        @Query("nik") nik: String
    ): VaccineResponse

    @GET("get_vaccine_data_barcode")
    suspend fun getDataByBarcode(
        @Query("barcode") barcode: String
    ): VaccineResponse

    @FormUrlEncoded
    @POST("add_data_vaccine")
    suspend fun postVaccine(
        @FieldMap params: HashMap<String, String>
    ): AddVaccineResponse

    @GET("photo_verification")
    suspend fun getVerifBarcodeNIK(
        @Query("nik") nik: String,
        @Query("photo") photo: String
    ) : NIKBarcodeResponse

    @GET("verification_account")
    suspend fun getLoginUser(
        @Query("nik") nik: String,
        @Query("password") password: String
    ) : LoginUserResponse
}