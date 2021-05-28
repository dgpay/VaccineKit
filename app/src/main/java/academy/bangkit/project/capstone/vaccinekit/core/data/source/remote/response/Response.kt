package academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("createTime")
	val createTime: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("updateTime")
	val updateTime: String,

	@field:SerializedName("fields")
	val fields: Fields
)