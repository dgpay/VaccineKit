package academy.bangkit.project.capstone.vaccinekituser.scanner.qrcode

import academy.bangkit.project.capstone.vaccinekituser.databinding.ActivityQrCodeUserBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class QrCodeUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQrCodeUserBinding

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrCodeUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.getStringExtra(EXTRA_DATA)
        generateQr(intent.toString())
    }

    private fun generateQr(string: String) {
        val multiFormatWriter = MultiFormatWriter()
        try {
            val bitMatrix = multiFormatWriter.encode(
                string,
                BarcodeFormat.CODE_128,
                900,
                200
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
}