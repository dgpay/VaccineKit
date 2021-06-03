package academy.bangkit.project.capstone.vaccinekituser.auth

import academy.bangkit.project.capstone.vaccinekituser.Helper.Constant
import academy.bangkit.project.capstone.vaccinekituser.Helper.PreferenceHelper
import academy.bangkit.project.capstone.vaccinekituser.MainActivity
import academy.bangkit.project.capstone.vaccinekituser.databinding.ActivityLoginBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel


class LoginUserActivity : AppCompatActivity() {

//    var mAuth = FirebaseAuth.getInstance()
    private lateinit var binding: ActivityLoginBinding
//    val db = Firebase.firestore

    private val viewModel: LoginViewModel by viewModel()
    lateinit var sharedpref: PreferenceHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedpref = PreferenceHelper(this)

        binding.loginBtn.setOnClickListener {
            login()
        }
    }

    private fun login() {
        var nik = binding.user.editableText.toString()
        var pass = binding.pass.editableText.toString()
        lifecycleScope.launch(Dispatchers.Default) {
            withContext(Dispatchers.Main) {
                viewModel.LoginUser(nik, pass).collectLatest {
                    saveSession(nik,pass)
                    moveIntent()
                }
            }
        }

    }

//    private fun loginF() {
//        var nik = binding.user.editableText
//        var pass = binding.pass.editableText
//        var status = false
//        val fstore = FirebaseFirestore.getInstance()
//        fstore.collection("coba").get().addOnCompleteListener{
//            if (it.isSuccessful){
//                for (document in it.result!!){
//                    if(document.data.getValue("nik")==nik.toString() && document.data.getValue("pass") == pass.toString()){
//                        //contoh
//                            saveSession(document.data.getValue("nik").toString(),document.data.getValue("pass").toString())
//                        status =true
//                        moveIntent()
//                    }
//                }
//            }
//        }
//        }

//    override fun onStart() {
//        super.onStart()
//        if(sharedpref.getBoolean(Constant.PREF_IS_LOGIN)){
//            moveIntent()
//        }
//    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun saveSession (nik: String, password:String){
        sharedpref.put(Constant.PREF_NIK,nik)
//        sharedpref.put(Constant.PREF_PASSWORD,password)
        sharedpref.put(Constant.PREF_IS_LOGIN,true)
    }
}

