package academy.bangkit.project.capstone.vaccinekit

import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityRegisterBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference
    private lateinit var binding: ActivityRegisterBinding

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
                        startActivity(Intent(this, Timeline::class.java))
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