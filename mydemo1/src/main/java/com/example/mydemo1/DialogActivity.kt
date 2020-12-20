package com.example.mydemo1

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog2.*
import kotlinx.android.synthetic.main.layout_dialog.*

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog2)
    }
    fun click(v: View){
        val dialog:Dialog = Dialog(this)
        dialog.setContentView(R.layout.layout_dialog)
        dialog.window?.setGravity(Gravity.BOTTOM)
        dialog.window?.attributes?.y = 100
        dialog.show()
        dialog.setOnShowListener( {
            val array:IntArray = intArrayOf(0,0)
            bnt_1.getLocationOnScreen(array)
            val array1:IntArray = intArrayOf(0,0)
            bnt_dialog_button.getLocationOnScreen(array1)
            dialog.window?.attributes?.y =  800
        })
    }

    private fun test1() {
        val builder = AlertDialog.Builder(this);
        val dialog = builder.setTitle("test").setMessage("a test dialog").create()//.setCancelable(false)
        //.show();
//        val vt:Button = Button(this)
//        vt.text = "一个小按钮"
//        builder.setView(vt).show();

        val array:IntArray = intArrayOf(0,0)
        bnt_1.getLocationOnScreen(array)
        dialog.window?.attributes?.x = array[0]
        dialog.window?.attributes?.y = array[1]

        dialog.window?.setGravity(Gravity.BOTTOM)
        dialog.show()
    }
}