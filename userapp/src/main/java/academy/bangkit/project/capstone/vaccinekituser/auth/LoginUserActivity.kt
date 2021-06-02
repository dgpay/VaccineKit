package academy.bangkit.project.capstone.vaccinekituser.auth

import academy.bangkit.project.capstone.vaccinekituser.databinding.ActivityLoginBinding
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class LoginUserActivity : AppCompatActivity() {

    var mAuth = FirebaseAuth.getInstance()
    private lateinit var binding: ActivityLoginBinding
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.loginBtn.setOnClickListener {
//            login()
//        }
//        binding.regTxtButton.setOnClickListener{
//            register()
//        }
    }

    fun login() {
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("TAG", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }


//    private fun login() {
//        var email = binding.user.editableText
//        var pass = binding.pass.editableText
//
//        if(email.isNotEmpty() && pass.isNotEmpty()) {
//            this.mAuth.signInWithEmailAndPassword(email.toString(), pass.toString()).addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
//                if (task.isSuccessful) {
//                    startActivity(Intent(this, MainActivity::class.java))
//                    Toast.makeText(this, "Successfully Logged in :)", Toast.LENGTH_LONG).show()
//                } else {
//                    Toast.makeText(this, "Error Logging in :(", Toast.LENGTH_SHORT).show()
//                }
//            })
//        }else {
//            Toast.makeText(this, "Please fill up the Credentials :|", Toast.LENGTH_SHORT).show()
//        }
//    }

//    private fun register () {
////        startActivity(Intent(this, RegisterUserActivity::class.java))
//    }
}