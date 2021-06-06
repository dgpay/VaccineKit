package academy.bangkit.project.capstone.vaccinekit.auth

import academy.bangkit.project.capstone.vaccinekit.MainActivity
import academy.bangkit.project.capstone.vaccinekit.R
import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityLoginBinding
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    var mAuth = FirebaseAuth.getInstance()
    private lateinit var binding: ActivityLoginBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showHideBtn.setOnClickListener {
            if(binding.showHideBtn.background.equals(resources.getDrawable(R.drawable.show_pass,theme))){
                binding.pass.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.showHideBtn.background = resources.getDrawable(R.drawable.show_pass,theme)
                binding.showHideBtn.text = "show"
            } else{
                binding.pass.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.showHideBtn.background = resources.getDrawable(R.drawable.ic_baseline_remove_red_eye_24,theme)
                binding.showHideBtn.text = "hide"
            }
        }

        binding.loginBtn.setOnClickListener {
            login()
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
                    finish()
                } else {
                    Toast.makeText(this, "Error Logging in :(", Toast.LENGTH_SHORT).show()
                }
            })
        }else {
            Toast.makeText(this, "Please fill up the Credentials :|", Toast.LENGTH_SHORT).show()
        }
    }
}