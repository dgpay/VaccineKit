package academy.bangkit.project.capstone.vaccinekit.checkvaccine.detail

import academy.bangkit.project.capstone.vaccinekit.CommonUntils
import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityDetailVaccineBinding
import android.app.Dialog
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

    private var loadingDialog: Dialog? = null

    private lateinit var binding: ActivityDetailVaccineBinding
    private val viewModel: DetailVaccineViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVaccineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val barcode = intent.getStringExtra(EXTRA_DATA)


        lifecycleScope.launch(Dispatchers.Default) {
            withContext(Dispatchers.Main) {
                viewModel.getDataByBarcode("0000000000000051CixSB").collectLatest {
                        showData(it)
                    }
                }
            }
        }

    private fun showData(vaccine: Vaccine) {
        binding.tvName.text = vaccine.name
        binding.tvAddress.text = vaccine.address
        binding.tvNik.text = vaccine.nik
        binding.tvTtl.text = vaccine.ttl
        binding.tvFirstVaccine.text = vaccine.firstVaccineDate
        binding.tvSecondVaccine.text = vaccine.secondVaccineDate
    }

    private fun hideLoading(){
        loadingDialog?.let{
            if(it.isShowing)it.cancel()
        }
    }

    private fun showLoading(){
        hideLoading()
        loadingDialog = CommonUntils.showLoadingDialog(this)
    }

}

