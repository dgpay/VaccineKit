package academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.network

import retrofit2.http.POST

interface ApiService {

    @POST()
    suspend fun insetDataVaccine(
    )
}