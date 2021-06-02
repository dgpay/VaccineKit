package academy.bangkit.project.capstone.vaccinekit.core.data.source.remote

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.network.ApiService
import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.AddVaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.NIKBarcodeResponse
import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.VaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.VerifResponse
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource (private val apiService: ApiService) {

    fun getDataByBarcode(barcode: String): Flow<VaccineResponse> {
        return flow {
            try {
                val response = apiService.getDataByBarcode(barcode)
                emit(response)
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getVerifNIKBarcode(nik: String, photos: String): Flow<NIKBarcodeResponse> {
        return flow {
            try {
                val response = apiService.getVerifBarcodeNIK(nik, photos)
                emit(response)
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }


    fun getVerifNik(nik: String): Flow<VerifResponse> {
        return flow {
            try {
                val response = apiService.getVerifNik(nik)
                emit(response)
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getVaccineData(nik: String): Flow<VaccineResponse> {
        return flow {
            try {
                val response = apiService.getVaccine(nik)
                emit(response)
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun postVaccineData(
        nik: String,
        name: String,
        address: String,
        photos: String,
        ttl: String,
        firstVaccineData: String,
        secondVaccineDate: String,
        vaccineStatus: String
    ): Flow<AddVaccineResponse> {
        return flow {
            try {
                val response = apiService.postVaccine(nik,name, address, photos, ttl, firstVaccineData, secondVaccineDate, vaccineStatus)
                emit(response)
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}