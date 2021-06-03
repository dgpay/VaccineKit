package academy.bangkit.project.capstone.vaccinekituser.auth

import academy.bangkit.project.capstone.vaccinekit.core.domain.model.LoginUser
import academy.bangkit.project.capstone.vaccinekit.core.domain.usecase.VaccineUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

class LoginViewModel(private val useCase: VaccineUseCase) : ViewModel() {

    fun LoginUser(nik:String, pass:String): Flow<LoginUser> = useCase.loginUser(nik, pass)

}