package academy.bangkit.project.capstone.vaccinekituser.scanner

import academy.bangkit.project.capstone.vaccinekituser.databinding.ActivityFaceBinding
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
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import kotlin.random.Random

class FaceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFaceBinding
    private var image_path: String? = null
    private var mStorageRef: StorageReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mStorageRef = FirebaseStorage.getInstance().reference
        binding.btnUpload.setOnClickListener {
            upload(image_path.toString())
        }
        binding.btnOpen.setOnClickListener {
            cameraIntent()
        }
    }


    private fun cameraIntent() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 101)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 101) {
                resultCamera(data)
            }
        }
    }
}