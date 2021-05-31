package academy.bangkit.project.capstone.vaccinekit.detail

import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityDetailVaccineBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel

class DetailVaccineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailVaccineBinding
    private val viewModel: DetailVaccineViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVaccineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.Default) {
            withContext(Dispatchers.Main) {
                viewModel.getVaccineData("0123768763618736918").collectLatest {
                    showData(it)
                }
            }
        }
    }

    private fun showData(vaccine: Vaccine) {
        binding.tvName.text = vaccine.name
        binding.tvNik.text = vaccine.nik
        binding.tvAddress.text = vaccine.address
    }
}