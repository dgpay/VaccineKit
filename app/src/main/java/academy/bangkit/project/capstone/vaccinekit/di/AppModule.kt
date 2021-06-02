package academy.bangkit.project.capstone.vaccinekit.di

import academy.bangkit.project.capstone.vaccinekit.core.domain.usecase.VaccineInteractor
import academy.bangkit.project.capstone.vaccinekit.core.domain.usecase.VaccineUseCase
import academy.bangkit.project.capstone.vaccinekit.checkvaccine.detail.DetailVaccineViewModel
import academy.bangkit.project.capstone.vaccinekit.regisforuser.InsertViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<VaccineUseCase> { VaccineInteractor(get()) }
}

val viewModelModule = module {
    viewModel { DetailVaccineViewModel(get()) }
    viewModel { InsertViewModel(get()) }
}