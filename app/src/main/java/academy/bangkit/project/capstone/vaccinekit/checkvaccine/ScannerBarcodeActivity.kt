package academy.bangkit.project.capstone.vaccinekit.checkvaccine

import academy.bangkit.project.capstone.vaccinekit.checkvaccine.detail.DetailVaccineActivity
import academy.bangkit.project.capstone.vaccinekit.databinding.ActivityScannerBarcodeBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode

class ScannerBarcodeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScannerBarcodeBinding

    private lateinit var codeScanner: CodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannerBarcodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        codeScanner()
    }

    private fun codeScanner(){
        codeScanner = CodeScanner(this, binding.scannerView)

        codeScanner.apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS

            autoFocusMode = AutoFocusMode.SAFE
            scanMode = ScanMode.SINGLE
            isAutoFocusEnabled = true
            isFlashEnabled = true

            decodeCallback = DecodeCallback {
                runOnUiThread {
                    if (it.text.isNotEmpty()) {
                        moveToDetail(it.text)
                    }
                }
            }
            errorCallback = ErrorCallback {
                runOnUiThread{
                    Log.e("Main","Camera initialization error: ${it.message}")
                }
            }
        }
        binding.scannerView.setOnClickListener{
            codeScanner.startPreview()
        }
    }

    private fun moveToDetail(string: String) {
        val intent = Intent(this, DetailVaccineActivity::class.java)
        intent.putExtra(DetailVaccineActivity.EXTRA_DATA, string)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}