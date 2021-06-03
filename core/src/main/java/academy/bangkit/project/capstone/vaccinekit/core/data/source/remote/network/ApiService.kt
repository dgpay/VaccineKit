package academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.network

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.AddVaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.NIKBarcodeResponse
import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.VaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.VerifResponse
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
        @Field("nik") nik: String,
        @Field("name") name: String,
        @Field("address") address: String,
        @Field("photo") photo: String,
        @Field("ttl") ttl: String,
        @Field("firstVaccineData") firstVaccineData: String,
        @Field("secondVaccineDate") secondVaccineDate: String,
        @Field("vaccineStatus") vaccineStatus: String
    ): AddVaccineResponse

    @GET("photo_verification")
    suspend fun getVerifBarcodeNIK(
        @Query("nik") nik: String,
        @Query("photo") photo: String
    ) : NIKBarcodeResponse
}