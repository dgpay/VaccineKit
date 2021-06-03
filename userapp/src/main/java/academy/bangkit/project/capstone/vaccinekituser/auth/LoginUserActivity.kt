package academy.bangkit.project.capstone.vaccinekituser.auth

import academy.bangkit.project.capstone.vaccinekituser.Helper.Constant
import academy.bangkit.project.capstone.vaccinekituser.Helper.PreferenceHelper
import academy.bangkit.project.capstone.vaccinekituser.MainActivity
import academy.bangkit.project.capstone.vaccinekituser.databinding.ActivityLoginBinding
import academy.bangkit.project.capstone.vaccinekituser.profile.ProfilActivity
import academy.bangkit.project.capstone.vaccinekituser.scanner.FaceActivity
import android.app.Activity
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

    lateinit var sharedpref: PreferenceHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedpref = PreferenceHelper(this)


        binding.loginBtn.setOnClickListener {
            loginF()
        }
    }

    private fun login() {
        var email = binding.user.editableText
        var pass = binding.pass.editableText

    }

    private fun loginF() {
        var nik = binding.user.editableText
        var pass = binding.pass.editableText
        var status = false
        val fstore = FirebaseFirestore.getInstance()
        fstore.collection("coba").get().addOnCompleteListener{
            if (it.isSuccessful){
                for (document in it.result!!){
                    if(document.data.getValue("nik")==nik.toString() && document.data.getValue("pass") == pass.toString()){
                        //contoh
                            saveSession(document.data.getValue("nik").toString(),document.data.getValue("pass").toString())
                        status =true
                        moveIntent()
                    }
                }
            }
        }
        }

    override fun onStart() {
        super.onStart()
        if(sharedpref.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }
    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun saveSession (nik: String, password:String){
        sharedpref.put(Constant.PREF_NIK,nik)
        sharedpref.put(Constant.PREF_PASSWORD,password)
        sharedpref.put(Constant.PREF_IS_LOGIN,true)
    }
}

