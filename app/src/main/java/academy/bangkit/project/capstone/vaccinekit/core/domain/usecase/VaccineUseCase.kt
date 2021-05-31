package academy.bangkit.project.capstone.vaccinekit.core.domain.usecase

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.AddVaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Verification
import kotlinx.coroutines.flow.Flow

interface VaccineUseCase {
    fun getVaccineData(nik: String): Flow<Vaccine>
    fun getVerification(nik: String): Flow<Verification>
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