package academy.bangkit.project.capstone.vaccinekit.insert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.project.capstone.vaccinekit.R
import academy.bangkit.project.capstone.vaccinekit.databinding.FragmentInsertBinding
import android.content.ContentValues
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class InsertFragment : Fragment() {

    private var _binding: FragmentInsertBinding? = null
    private val binding get() = _binding!!
    var db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInsertBinding.inflate(inflater, container, false)
        return binding.root

        binding.btnSubmit.setOnClickListener {
            addDatabase()
        }
    }

    private fun addDatabase() {

        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )

        Toast.makeText(activity,"pencet", Toast.LENGTH_SHORT).show()
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }
    }
}