package academy.bangkit.project.capstone.vaccinekit.core.domain.usecase

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.AddVaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Verification
import academy.bangkit.project.capstone.vaccinekit.core.domain.repository.IVaccineRepository
import kotlinx.coroutines.flow.Flow

class VaccineInteractor(private val vaccineRepository: IVaccineRepository) : VaccineUseCase {

    override fun getVaccineData(nik: String): Flow<Vaccine> = vaccineRepository.getVaccineData(nik)
    override fun getVerification(nik: String): Flow<Verification> = vaccineRepository.getVerification(nik)
    override fun addVaccineData(
        nik: String,
        name: String,
        address: String,
        photos: String,
        ttl: String,
        firstVaccineData: String,
        secondVaccineDate: String,
        vaccineStatus: String
    ): Flow<AddVaccineResponse> =
        vaccineRepository.addVaccineData(nik, name, address, photos, ttl, firstVaccineData, secondVaccineDate, vaccineStatus)

}