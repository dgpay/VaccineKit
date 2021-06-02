package academy.bangkit.project.capstone.vaccinekituser.profile

import academy.bangkit.project.capstone.vaccinekituser.databinding.ActivityProfilBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}