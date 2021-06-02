package academy.bangkit.project.capstone.vaccinekit.regisforuser

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.AddVaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.domain.usecase.VaccineUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

class InsertViewModel(private val useCase: VaccineUseCase) : ViewModel() {

    fun addVaccineData(
        nik: String,
        name: String,
        address: String,
        photos: String,
        ttl: String,
        firstVaccineData: String,
        secondVaccineDate: String,
        vaccineStatus: String
    ): Flow<AddVaccineResponse> =
        useCase.addVaccineData(nik, name, address, photos, ttl, firstVaccineData, secondVaccineDate, vaccineStatus)

}