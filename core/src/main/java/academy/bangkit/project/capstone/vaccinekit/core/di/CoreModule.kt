package academy.bangkit.project.capstone.vaccinekit.core.di

import academy.bangkit.project.capstone.vaccinekit.core.data.VaccineRepository
import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.RemoteDataSource
import academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.network.ApiService
import academy.bangkit.project.capstone.vaccinekit.core.domain.repository.IVaccineRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://34.101.148.177:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single {
        RemoteDataSource(
            get()
        )
    }
    single<IVaccineRepository> {
        VaccineRepository(
            get()
        )
    }
}

