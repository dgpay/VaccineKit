package academy.bangkit.project.capstone.vaccinekituser.profile

import academy.bangkit.project.capstone.vaccinekit.core.domain.model.Vaccine
import academy.bangkit.project.capstone.vaccinekituser.CommonUtilsUser
import academy.bangkit.project.capstone.vaccinekituser.Helper.Constant
import academy.bangkit.project.capstone.vaccinekituser.Helper.PreferenceHelper
import academy.bangkit.project.capstone.vaccinekituser.databinding.ActivityProfilBinding
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel

class ProfilActivity : AppCompatActivity() {

    lateinit var sharedpref: PreferenceHelper
    private lateinit var binding: ActivityProfilBinding
    private val viewModel: ProfileViewModel by viewModel()
    private var loadingDialog: Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedpref = PreferenceHelper(this)
        val NIK = sharedpref.getString(Constant.PREF_NIK).toString()

        lifecycleScope.launch(Dispatchers.Default) {
            withContext(Dispatchers.Main) {
                viewModel.getVaccineData(NIK!!).collectLatest {
                    showLoading()
                    Handler().postDelayed({
                        hideLoading()
                        showData(it)
                    },5000)

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
        loadingDialog = CommonUtilsUser.showLoadingDialog(this)
    }

}