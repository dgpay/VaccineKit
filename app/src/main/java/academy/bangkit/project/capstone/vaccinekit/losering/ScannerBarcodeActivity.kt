package academy.bangkit.project.capstone.vaccinekit.losering

import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityScannerBarcodeBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ScannerBarcodeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScannerBarcodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannerBarcodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}