package academy.bangkit.project.capstone.vaccinekit.checkvaccine.detail

import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.core.domain.usecase.VaccineUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

class DetailVaccineViewModel(private val useCase: VaccineUseCase) : ViewModel() {

    fun getDataByBarcode(barcode: String) : Flow<Vaccine> = useCase.getDataByBarcode(barcode)

}