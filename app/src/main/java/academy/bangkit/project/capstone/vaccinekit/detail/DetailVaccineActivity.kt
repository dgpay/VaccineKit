package academy.bangkit.project.capstone.vaccinekit.detail

import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityDetailVaccineBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailVaccineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailVaccineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVaccineBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}