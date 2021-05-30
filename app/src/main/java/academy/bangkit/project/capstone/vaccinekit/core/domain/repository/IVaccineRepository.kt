package academy.bangkit.project.capstone.vaccinekit.core.domain.repository

import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Verification
import kotlinx.coroutines.flow.Flow

interface IVaccineRepository {
    fun getVaccineData(nik: String): Flow<Vaccine>
    fun getVerification(nik: String): Flow<Verification>
}