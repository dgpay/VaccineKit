package academy.bangkit.project.capstone.vaccinekit.insert

import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityInsertBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class InsertActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInsertBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}