package academy.bangkit.project.capstone.vaccinekit.core.domain.repository

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.AddVaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.NIKBarcode
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Verification
import kotlinx.coroutines.flow.Flow

interface IVaccineRepository {
    fun getVaccineData(nik: String): Flow<Vaccine>
    fun getDataByBarcode(barcode: String): Flow<Vaccine>
    fun getVerification(nik: String): Flow<Verification>
    fun getNIKBarcode(nik: String, photos: String): Flow<NIKBarcode>
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