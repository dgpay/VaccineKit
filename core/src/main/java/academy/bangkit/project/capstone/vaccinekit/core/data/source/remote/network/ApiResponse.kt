package academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.network

sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.network.ApiResponse<T>()
    data class Error(val errorMessage: String) : academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.network.ApiResponse<Nothing>()
    object Empty : academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.network.ApiResponse<Nothing>()
}