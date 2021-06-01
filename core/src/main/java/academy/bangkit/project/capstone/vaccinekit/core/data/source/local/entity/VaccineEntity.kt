package academy.bangkit.project.capstone.vaccinekit.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "vaccine_tbl")
class VaccineEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "NIK")
    var NIK: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "photo")
    var photo: String,

    @ColumnInfo(name = "qrCode")
    var qrCode: String,

    @ColumnInfo(name = "TTL")
    var TTL: String,

    @ColumnInfo(name = "address")
    var address: String,

    @ColumnInfo(name = "firstVaccine")
    var firstVaccine: String,

    @ColumnInfo(name = "secondVaccine")
    var secondVaccine: String
)