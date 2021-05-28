package academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Fields(

	@field:SerializedName("last")
	val last: Last,

	@field:SerializedName("born")
	val born: Born,

	@field:SerializedName("first")
	val first: First
)