package academy.bangkit.project.capstone.vaccinekituser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Entity(
    var nik:String,
    var pass:String
) : Parcelable