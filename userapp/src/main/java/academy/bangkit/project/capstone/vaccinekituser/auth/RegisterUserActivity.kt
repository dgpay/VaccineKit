package academy.bangkit.project.capstone.vaccinekituser.auth
import academy.bangkit.project.capstone.vaccinekituser.databinding.ActivityRegisterBinding
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterUserActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference
    private lateinit var binding: ActivityRegisterBinding

    val db = Firebase.firestore
    val fstore = FirebaseFirestore.getInstance()
    lateinit var mDoc : DocumentReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mDatabase = FirebaseDatabase.getInstance().getReference("Names")
        binding.regis.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val emailTxt = binding.email.editableText
        val passTxt = binding.passw.editableText
        val nameTxt = binding.name.editableText

        if (emailTxt.toString().isNotEmpty()
            && passTxt.toString().isNotEmpty()
            && nameTxt.toString().isNotEmpty()) {
            mAuth.createUserWithEmailAndPassword(emailTxt.toString(), passTxt.toString())
                .addOnCompleteListener(this, OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = mAuth.currentUser
                        val uid = user!!.uid
                        mDatabase.child(uid).child("Name").setValue(nameTxt.toString())

                        val userReg = hashMapOf(
                            "Email" to emailTxt.toString(),
                            "Password" to passTxt.toString(),
                            "Name" to nameTxt.toString(),
                            "IsUser" to 1
                        )
                        db.collection("UserVaccineKit")
                            .add(userReg)
                            .addOnSuccessListener { documentReference ->
                                Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                            }
                            .addOnFailureListener { e ->
                                Log.w(ContentValues.TAG, "Error adding document", e)
                            }
                        mDoc = fstore.collection("UserKit").document(uid)
                        mDoc.set(userReg)
//                        startActivity(Intent(this, Timeline::class.java))
                        Toast.makeText(this, "Successfully registered :)", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this, "Error registering, try again later :(", Toast.LENGTH_LONG).show()
                    }
                })
        }else {
            Toast.makeText(this,"Please fill up the Credentials :|", Toast.LENGTH_LONG).show()
        }
    }
}