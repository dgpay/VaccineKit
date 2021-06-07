package academy.bangkit.project.capstone.vaccinekit.home

import academy.bangkit.project.capstone.vaccinekit.MainActivity
import academy.bangkit.project.capstone.vaccinekit.checkvaccine.ScannerBarcodeActivity
import academy.bangkit.project.capstone.vaccinekit.databinding.FragmentHomeBinding
import academy.bangkit.project.capstone.vaccinekit.regisforuser.RegisUserFragment
import academy.bangkit.project.capstone.vaccinekit.regisforuser.UserRegisterActivity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardHome.setOnClickListener{
            activity?.let{
                val intent = Intent (it, MainActivity::class.java)
                it.startActivity(intent)
            }
        }
        binding.cardLost.setOnClickListener{
            activity?.let{
                val intent = Intent (it, ScannerBarcodeActivity::class.java)
                it.startActivity(intent)
            }
        }
        binding.cardRegister.setOnClickListener{

            activity?.let{
                val intent = Intent (it, UserRegisterActivity::class.java)
                it.startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}