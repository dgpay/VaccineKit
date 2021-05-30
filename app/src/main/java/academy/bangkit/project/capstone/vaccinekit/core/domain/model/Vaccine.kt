package academy.bangkit.project.capstone.vaccinekit.core.domain.model

data class Vaccine(
    val nik: String,
    val name: String,
    val photo: String,
    val vaccineStatus: String,
    val ttl: String,
    val address: String,
    val firstVaccine: String,
    val secondVaccine: String
)