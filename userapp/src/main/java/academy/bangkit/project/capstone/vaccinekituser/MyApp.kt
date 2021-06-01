package academy.bangkit.project.capstone.vaccinekituser

import academy.bangkit.project.capstone.vaccinekit.core.di.networkModule
import academy.bangkit.project.capstone.vaccinekit.core.di.repositoryModule
import academy.bangkit.project.capstone.vaccinekituser.di.useCaseModule
import academy.bangkit.project.capstone.vaccinekituser.di.viewModelModule
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApp)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}