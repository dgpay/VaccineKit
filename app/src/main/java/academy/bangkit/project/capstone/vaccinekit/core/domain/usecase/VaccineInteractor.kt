package academy.bangkit.project.capstone.vaccinekit.core.domain.usecase

import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Verification
import academy.bangkit.project.capstone.vaccinekit.core.domain.repository.IVaccineRepository
import kotlinx.coroutines.flow.Flow

class VaccineInteractor(private val vaccineRepository: IVaccineRepository) : VaccineUseCase {

    override fun getVaccineData(nik: String): Flow<Vaccine> = vaccineRepository.getVaccineData(nik)
    override fun getVerification(nik: String): Flow<Verification> = vaccineRepository.getVerification(nik)

}