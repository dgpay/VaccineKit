package academy.bangkit.project.capstone.vaccinekituser.qrcode

import academy.bangkit.project.capstone.vaccinekituser.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class QrCodeUserActivity : AppCompatActivity() {
    private var contentText = "random"
    private lateinit var generateBtn : Button
    private lateinit var ImageQr : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_code_user)

        generateBtn = findViewById(R.id.button_generate)
        ImageQr = findViewById(R.id.img_qrcode)

        val data = contentText.toString()
        generateBtn.setOnClickListener {
            if( data.isNotEmpty()){
                generateQr()
            }else{
                val toast = Toast.makeText(this,"Input The code", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }
        }

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
            ImageQr.setImageBitmap(bitmap)
        }catch (e: WriterException){
            e.printStackTrace()
        }

    }
}