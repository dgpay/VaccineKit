package academy.bangkit.project.capstone.vaccinekit.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class NIKBarcodeResponse(

	@field:SerializedName("barcode")
	val barcode: String,

	@field:SerializedName("verification")
	val verification: String
)
