package academy.bangkit.project.capstone.vaccinekit.core.domain.model

data class Vaccine(
    val NIK: String,
    val name: String,
    val photo: String,
    val qrCode: String,
    val TTL: String,
    val address: String,
    val firstVaccine: String,
    val secondVaccine: String
)