package academy.bangkit.project.capstone.vaccinekit.core.domain.repository

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.AddVaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.LoginUser
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.NIKBarcode
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Verification
import com.squareup.okhttp.RequestBody
import kotlinx.coroutines.flow.Flow

interface IVaccineRepository {
    fun loginUser(nik: String, pass: String): Flow<LoginUser>
    fun getVaccineData(nik: String): Flow<Vaccine>
    fun getDataByBarcode(barcode: String): Flow<Vaccine>
    fun getVerification(nik: String): Flow<Verification>
    fun getNIKBarcode(nik: String, photos: String): Flow<NIKBarcode>
    fun addVaccineData(params: HashMap<String, String>
    ): Flow<AddVaccineResponse>
}