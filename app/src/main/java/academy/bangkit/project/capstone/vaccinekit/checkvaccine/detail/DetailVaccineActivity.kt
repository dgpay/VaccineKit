package academy.bangkit.project.capstone.vaccinekit.checkvaccine.detail

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

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailVaccineBinding
    private val viewModel: DetailVaccineViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVaccineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val barcode = intent.getStringExtra(EXTRA_DATA)

        lifecycleScope.launch(Dispatchers.Default) {
            withContext(Dispatchers.Main) {
                viewModel.getDataByBarcode(barcode.toString()).collectLatest {
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

