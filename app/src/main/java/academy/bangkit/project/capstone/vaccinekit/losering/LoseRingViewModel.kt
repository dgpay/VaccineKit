package academy.bangkit.project.capstone.vaccinekit.losering

import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Verification
import academy.bangkit.project.capstone.vaccinekit.core.domain.usecase.VaccineUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

class LoseRingViewModel(private val useCase: VaccineUseCase) : ViewModel() {

    fun getVerificationNIK(nik: String) : Flow<Verification> = useCase.getVerification(nik)

}