package academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class LoginUserResponse(

	@field:SerializedName("status_verification")
	val statusVerification: String
)