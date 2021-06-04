package academy.bangkit.project.capstone.vaccinekituser.scanner

import academy.bangkit.project.capstone.vaccinekituser.Helper.Constant
import academy.bangkit.project.capstone.vaccinekituser.Helper.PreferenceHelper
import academy.bangkit.project.capstone.vaccinekituser.databinding.ActivityFaceBinding
import academy.bangkit.project.capstone.vaccinekituser.scanner.qrcode.QrCodeUserActivity
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import kotlin.random.Random
import org.koin.android.viewmodel.ext.android.viewModel

class  FaceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFaceBinding
    private var image_path: String? = null
    private var mStorageRef: StorageReference? = null
    private val PICK_IMAGE_REQUEST = 71
    private val PICK_CAMERA = 101
    private var filePath: Uri? = null

    private val viewModel: FaceViewModel by viewModel()

    lateinit var sharedpref: PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mStorageRef = FirebaseStorage.getInstance().reference

        sharedpref = PreferenceHelper(this)
        val NIK = sharedpref.getString(Constant.PREF_NIK)
        binding.btnUpload.setOnClickListener {
            upload(image_path.toString())
            checkBarcode(NIK.toString(), image_path.toString())
        }
        binding.btnOpen.setOnClickListener {
            cameraIntent()
        }
        binding.btnGallery.setOnClickListener {
            launchGallery()
        }
    }

    private fun checkBarcode(nik: String, path: String) {
        lifecycleScope.launch(Dispatchers.Default) {
            withContext(Dispatchers.Main) {
                viewModel.getVerifByNIKphoto(nik,path).collectLatest {
                    if (it.verification == "ok") {
                        moveToBarcode(it.barcode)
                    } else {
                        Toast.makeText(this@FaceActivity, "Not Match", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun moveToBarcode(string: String) {
        val intent = Intent(this, QrCodeUserActivity::class.java)
        intent.putExtra(QrCodeUserActivity.EXTRA_DATA, string)
        startActivity(intent)
    }

    private fun cameraIntent() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, PICK_CAMERA)
    }

    private fun upload(path: String){
        val file = Uri.fromFile(File(path))
        val meta = File(path)
        val storageRef = mStorageRef?.child("photo_request_verif/${meta.name}")
        storageRef?.putFile(file)
            ?.addOnSuccessListener {
                Toast.makeText(this, "File berhasil di upload", Toast.LENGTH_SHORT).show()
                finish()
            }?.addOnFailureListener {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
    }

    private fun resultCamera(data: Intent?) {
        val image = data?.extras?.get("data")
        val random = Random.nextInt(0, 999999)
        val name_file = "Camera$random"
        image_path = persistImage(image as Bitmap, name_file)
        binding.imgView.setImageBitmap(BitmapFactory.decodeFile(image_path))
    }

    private fun persistImage(bitmap: Bitmap, name: String): String {
        val filesDir = filesDir
        val imageFile = File(filesDir, "${name}.png")
        val image_path = imageFile.path
        val os: OutputStream?
        try {
            os = FileOutputStream(imageFile)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, os)
            os.flush()
            os.close()
        } catch (e: Exception){
            Log.e("TAG", "persistImage: ${e.message.toString()} ", e )
        }
        return image_path
    }

    private fun launchGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    private fun resultGallery(data: Intent?) {
        if(data == null || data.data == null){
            return
        }
        filePath = data.data
        try {
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
            val random = Random.nextInt(0, 999999)
            val name_file = "Camera$random"
            image_path = persistImage(bitmap, name_file)
            binding.imgView.setImageBitmap(BitmapFactory.decodeFile(image_path))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PICK_CAMERA) {
                resultCamera(data)
            }
            else if (requestCode == PICK_IMAGE_REQUEST) {
                resultGallery(data)
            }
        }
    }
}