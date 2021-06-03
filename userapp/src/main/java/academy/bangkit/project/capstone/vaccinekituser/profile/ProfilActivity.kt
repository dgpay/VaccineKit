package academy.bangkit.project.capstone.vaccinekituser.profile

import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekituser.databinding.ActivityProfilBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel

class ProfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfilBinding
    private val viewModel: ProfileViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.Default) {
            withContext(Dispatchers.Main) {
                viewModel.getVaccineData("0000000000000014").collectLatest {
                    showData(it)
                }
            }
        }
    }

    private fun showData(vaccine: Vaccine) {
        binding.tvName.text = vaccine.name
        binding.tvAddress.text = vaccine.address
    }
}