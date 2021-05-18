package academy.bangkit.project.capstone.vaccinekit

import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityMainBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    
    var mAuth = FirebaseAuth.getInstance()
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            login()
        }
        binding.regTxt.setOnClickListener{
            register()
        }
    }


    private fun login() {
        var email = binding.user.editableText
        var pass = binding.pass.editableText

        if(email.isNotEmpty() && pass.isNotEmpty()) {
            this.mAuth.signInWithEmailAndPassword(email.toString(), pass.toString()).addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, Timeline::class.java))
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
        startActivity(Intent(this, Register::class.java))
    }
}