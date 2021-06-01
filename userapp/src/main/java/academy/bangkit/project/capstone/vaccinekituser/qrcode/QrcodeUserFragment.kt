package academy.bangkit.project.capstone.vaccinekituser.qrcode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import academy.bangkit.project.capstone.vaccinekituser.databinding.FragmentQrcodeuserBinding
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class QrcodeUserFragment : Fragment() {
    private lateinit var generateBtn : Button
    private lateinit var ImageQr : ImageView
    private var _binding: FragmentQrcodeuserBinding? = null
    private val binding get() = _binding!!
    val contentText = "12uyr723g8fwef"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQrcodeuserBinding.inflate(inflater, container, false)

        val data = contentText
        binding.buttonGenerate.setOnClickListener {
            if( data.isNotEmpty()){
                generateQr()
            }else{
                showSnackbarMessage("You are not yet got Vaccine")
            }
        }
        return binding.root
    }

    private fun generateQr() {
        val multiFormatWriter = MultiFormatWriter()
        try {
            val bitMatrix = multiFormatWriter.encode(
                contentText,
                BarcodeFormat.QR_CODE,
                300,
                300
            )
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)
            binding.imgQrcode.setImageBitmap(bitmap)
        }catch (e: WriterException){
            e.printStackTrace()
        }

    }
    private fun showSnackbarMessage(message: String) {
        Snackbar.make(binding.myqrcode, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}