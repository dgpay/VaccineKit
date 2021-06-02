package academy.bangkit.project.capstone.vaccinekituser.profile

import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.usecase.VaccineUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

class ProfileViewModel(private val useCase: VaccineUseCase) : ViewModel() {
    fun getVaccineData(nik: String): Flow<Vaccine> = useCase.getVaccineData(nik)
}