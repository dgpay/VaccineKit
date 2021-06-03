package academy.bangkit.project.capstone.vaccinekituser.auth

import academy.bangkit.project.capstone.vaccinekituser.Entity
import academy.bangkit.project.capstone.vaccinekituser.MainActivity
import academy.bangkit.project.capstone.vaccinekituser.databinding.ActivityLoginBinding
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
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

        binding.loginBtn.setOnClickListener {
            loginF()
        }
    }

    private fun login() {
        var email = binding.user.editableText
        var pass = binding.pass.editableText

    }

    private fun loginF() {
        var email = binding.user.editableText
        var pass = binding.pass.editableText
        var status = false
        val fstore = FirebaseFirestore.getInstance()
        fstore.collection("users").get().addOnCompleteListener{
            if (it.isSuccessful){
                for (document in it.result!!){
                    if(document.data.getValue("nik")==email.toString() && document.data.getValue("pass") == pass.toString()){
                        status =true
                    }
                }
                if(status == true){
                    startActivity(Intent(this, MainActivity::class.java))}
            }
        }
        }

}

