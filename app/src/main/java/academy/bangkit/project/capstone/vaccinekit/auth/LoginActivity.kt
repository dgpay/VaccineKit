package academy.bangkit.project.capstone.vaccinekit.auth

import academy.bangkit.project.capstone.vaccinekit.MainActivity
import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityLoginBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    var mAuth = FirebaseAuth.getInstance()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            login()
        }
        binding.regTxtButton.setOnClickListener{
            register()
        }
    }

    private fun login() {
        var email = binding.user.editableText
        var pass = binding.pass.editableText

        if(email.isNotEmpty() && pass.isNotEmpty()) {
            this.mAuth.signInWithEmailAndPassword(email.toString(), pass.toString()).addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    Toast.makeText(this, "Successfully Logged in :)", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Error Logging in :(", Toast.LENGTH_SHORT).show()
                }
            })
        }else {
            Toast.makeText(this, "Please fill up the Credentials :|", Toast.LENGTH_SHORT).show()
        }
    }

    private fun register () {
//        startActivity(Intent(this, RegisterActivity::class.java))
    }
}