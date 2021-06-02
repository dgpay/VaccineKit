package academy.bangkit.project.capstone.vaccinekituser.scanner

import academy.bangkit.project.capstone.vaccinekit.core.domain.model.NIKBarcode
import academy.bangkit.project.capstone.vaccinekit.core.domain.usecase.VaccineUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

class FaceViewModel(private val useCase: VaccineUseCase) : ViewModel() {

    fun getVerifByNIKphoto(nik: String, photo: String): Flow<NIKBarcode> = useCase.getNIKBarcode(nik, photo)

}