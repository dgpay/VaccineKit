package academy.bangkit.project.capstone.vaccinekit.core.domain.usecase

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.AddVaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.LoginUser
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.NIKBarcode
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Verification
import academy.bangkit.project.capstone.vaccinekit.core.domain.repository.IVaccineRepository
import kotlinx.coroutines.flow.Flow

class VaccineInteractor(private val vaccineRepository: IVaccineRepository) : VaccineUseCase {
    override fun loginUser(nik: String, pass: String): Flow<LoginUser> = vaccineRepository.loginUser(nik, pass)
    override fun getVaccineData(nik: String): Flow<Vaccine> = vaccineRepository.getVaccineData(nik)
    override fun getVerification(nik: String): Flow<Verification> = vaccineRepository.getVerification(nik)
    override fun getDataByBarcode(barcode: String): Flow<Vaccine> = vaccineRepository.getDataByBarcode(barcode)
    override fun getNIKBarcode(nik: String, photos: String): Flow<NIKBarcode> = vaccineRepository.getNIKBarcode(nik, photos)
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