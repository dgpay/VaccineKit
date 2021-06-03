package academy.bangkit.project.capstone.vaccinekituser.di

import academy.bangkit.project.capstone.vaccinekit.core.domain.usecase.VaccineInteractor
import academy.bangkit.project.capstone.vaccinekit.core.domain.usecase.VaccineUseCase
import academy.bangkit.project.capstone.vaccinekituser.profile.ProfileViewModel
import academy.bangkit.project.capstone.vaccinekituser.scanner.FaceViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<VaccineUseCase> { VaccineInteractor(get()) }
}

val viewModelModule = module {
    viewModel { ProfileViewModel(get()) }
    viewModel { FaceViewModel(get()) }
}