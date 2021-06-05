package academy.bangkit.project.capstone.vaccinekituser

import academy.bangkit.project.capstone.vaccinekituser.auth.LoginUserActivity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.View
import androidx.core.graphics.drawable.toDrawable
import cn.pedant.SweetAlert.SweetAlertDialog




object CommonUtilsUser {
    fun showLoadingDialog(context: Context): Dialog {
        val progressDialog = Dialog(context)

        progressDialog.let{
            it.show()
            it.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.progress_bar_user)
            it.setCancelable(false)

            return it
        }
    }

    fun showSweetAlert(type: String, context: Context, title: String, content: String){
        when(type){
            "success" -> {
                SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText(title)
                    .setContentText(content)
                    .show()
            }
            "failed" -> {
                SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title)
                    .setContentText(content)
                    .show()
            }
            "exit" -> {
                SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText(title)
                    .setContentText(content)
                    .setConfirmText("Yes")
                    .setConfirmClickListener {
                    }
                    .setCancelButton(
                        "No"
                    ) {  }
                    .show()
            }
        }
    }
}