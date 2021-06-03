package academy.bangkit.project.capstone.vaccinekit.core.domain.model

import com.google.gson.annotations.SerializedName

data class Vaccine(
    val date: String,
    val vaccineStatus: String,
    val nik: String,
    val firstVaccineDate: String,
    val address: String,
    val name: String,
    val secondVaccineDate: String,
    val photo: String,
    val ttl: String,
    val barcode: String
)