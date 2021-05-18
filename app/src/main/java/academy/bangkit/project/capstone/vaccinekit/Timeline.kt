package academy.bangkit.project.capstone.vaccinekit

import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityTimelineBinding
import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Timeline : AppCompatActivity() {

    private lateinit var binding: ActivityTimelineBinding
    lateinit var mDatabase : DatabaseReference
    var mAuth = FirebaseAuth.getInstance()
    var user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimelineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var uid = user!!.uid

        mDatabase = FirebaseDatabase.getInstance().getReference("Names")

        mDatabase.child(uid).child("Name").addValueEventListener( object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item!!.itemId == R.id.signOut) {
            mAuth.signOut()
            Toast.makeText(this, "Signed Out :(", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

}