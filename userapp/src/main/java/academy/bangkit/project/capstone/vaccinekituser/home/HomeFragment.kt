package academy.bangkit.project.capstone.vaccinekituser.home

import academy.bangkit.project.capstone.vaccinekituser.MainActivity
import academy.bangkit.project.capstone.vaccinekituser.databinding.FragmentHomeBinding
import academy.bangkit.project.capstone.vaccinekituser.profile.ProfilActivity
import academy.bangkit.project.capstone.vaccinekituser.scanner.FaceActivity
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
        binding.CardHome.setOnClickListener{
            activity?.let{
                val intent = Intent (it, MainActivity::class.java)
                it.startActivity(intent)
            }
        }
        binding.cardLost.setOnClickListener{
            activity?.let{
                val intent = Intent (it, FaceActivity::class.java)
                it.startActivity(intent)
            }
        }
        binding.cardProfil.setOnClickListener{
            activity?.let{
                val intent = Intent (it, ProfilActivity::class.java)
                it.startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}