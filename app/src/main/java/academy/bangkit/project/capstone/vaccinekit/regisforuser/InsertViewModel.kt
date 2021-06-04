package academy.bangkit.project.capstone.vaccinekit.regisforuser

import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response.AddVaccineResponse
import academy.bangkit.project.capstone.vaccinekit.core.domain.usecase.VaccineUseCase
import androidx.lifecycle.ViewModel
import com.squareup.okhttp.RequestBody
import kotlinx.coroutines.flow.Flow

class InsertViewModel(private val useCase: VaccineUseCase) : ViewModel() {

    fun addVaccineData(params: HashMap<String, String>
    ): Flow<AddVaccineResponse> =
        useCase.addVaccineData(params)

}