package academy.bangkit.project.capstone.vaccinekit.core.domain.usecase

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.AddVaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.LoginUser
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.NIKBarcode
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Verification
import kotlinx.coroutines.flow.Flow

interface VaccineUseCase {
    fun loginUser(nik: String, pass: String): Flow<LoginUser>
    fun getVaccineData(nik: String): Flow<Vaccine>
    fun getVerification(nik: String): Flow<Verification>
    fun getDataByBarcode(barcode: String): Flow<Vaccine>
    fun getNIKBarcode(nik: String,photos: String): Flow<NIKBarcode>
    fun addVaccineData(
        nik: String,
        name: String,
        address: String,
        photos: String,
        ttl: String,
        firstVaccineData: String,
        secondVaccineDate: String,
        vaccineStatus: String
    ): Flow<AddVaccineResponse>
}