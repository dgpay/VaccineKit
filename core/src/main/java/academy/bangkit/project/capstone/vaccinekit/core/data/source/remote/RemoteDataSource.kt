package academy.bangkit.project.capstone.vaccinekit.core.data.source.remote

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.network.ApiService
import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.*
import android.util.Log
import com.squareup.okhttp.RequestBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource (private val apiService: ApiService) {

    fun loginUser(nik: String, pass: String): Flow<LoginUserResponse> {
        return flow{
            try {
                val response = apiService.getLoginUser(nik,pass)
                emit(response)
            }  catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

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
        params: HashMap<String, String>
    ): Flow<AddVaccineResponse> {
        return flow {
            try {
                val response = apiService.postVaccine(params)
                emit(response)
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}