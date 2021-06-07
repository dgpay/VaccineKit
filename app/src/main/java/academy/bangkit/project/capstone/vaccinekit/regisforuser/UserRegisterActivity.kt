package academy.bangkit.project.capstone.vaccinekit.regisforuser

import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityUploadBinding
import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityUserRegisterBinding
import academy.bangkit.project.capstone.vaccinekit.databinding.FragmentRegisUserBinding
import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UserRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserRegisterBinding
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSubmit.setOnClickListener {
            insertVaccine()
        }

    }
    private fun insertVaccine() {
        val nik = binding.edtNik.text.toString()
        val name = binding.edtName.text.toString()
        val ttl = binding.edtTtl.text.toString()
        val address = binding.edtAddress.text.toString()
        val first = binding.edtFirstVaccine.text.toString()
        val second = binding.edtSecondVaccine.text.toString()
        val status = binding.edtStatusVaccine.text.toString()

        val user = hashMapOf(
            "nik" to nik,
            "name" to name,
            "ttl" to ttl,
            "address" to address,
            "photo" to nik,
            "barcode" to "${nik}${getRandomString(5)}",
            "password" to "123456",
            "firstVaccineDate" to first,
            "secondVaccineDate" to second,
            "vaccineStatus" to status,
            "date" to ""
        )

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                moveToUpload(nik)
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }
    }

    private fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

    private fun moveToUpload(string: String) {
        val intent = Intent(this, UploadActivity::class.java)
        intent.putExtra(UploadActivity.EXTRA_DATA, string)
        startActivity(intent)
    }

    fun copyText(text:String){
        val myClipboard = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val myClip: ClipData = ClipData.newPlainText("Label", text)
        myClipboard.setPrimaryClip(myClip)
    }

}