package academy.bangkit.project.capstone.vaccinekit.core.domain.usecase

import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Verification
import kotlinx.coroutines.flow.Flow

interface VaccineUseCase {
    fun getVaccineData(nik: String): Flow<Vaccine>
    fun getVerification(nik: String): Flow<Verification>
}