package academy.bangkit.project.capstone.vaccinekit.insert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.project.capstone.vaccinekit.databinding.FragmentInsertBinding
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel

class InsertFragment : Fragment() {

    private var _binding: FragmentInsertBinding? = null
    private val binding get() = _binding!!
    val db = Firebase.firestore
    private val viewModel: InsertViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInsertBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            insertVaccine()
        }
    }

    private fun insertVaccine() {
        val nik = binding.edtNik.text.toString()
        val name = binding.edtName.text.toString()
        val ttl = binding.edtTtl.text.toString()
        val address = binding.edtAddress.text.toString()
        val photo = binding.edtPhoto.text.toString()

        val user = hashMapOf(
            "nik" to nik,
            "name" to name,
            "ttl" to ttl,
            "address" to address,
            "photo" to photo,
            "qr_id" to "",
            "firstVaccineDate" to "",
            "secondVaccineDate" to "",
            "vaccineStatus" to ""
        )

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}