package com.example.mydemo1

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.util.*

class PermissionActivity : AppCompatActivity() {
    val READ_PHONE_STATE_REQUEST_CODE:Int = 0
    val WRITE_EXTERNAL_STORAGE_REQUEST_CODE:Int = 1
    val map = mapOf(Manifest.permission.READ_PHONE_STATE to READ_PHONE_STATE_REQUEST_CODE, Manifest.permission.WRITE_EXTERNAL_STORAGE to WRITE_EXTERNAL_STORAGE_REQUEST_CODE)
//    val permissionArray = arrayOf(Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_PHONE_NUMBERS,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_NETWORK_STATE)
    val permissions: List<String> = arrayListOf(
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun test(view: View) {
        val list: MutableList<String> = arrayListOf();
//
//        val permissions: List<String> = arrayListOf(
//                Manifest.permission.READ_PHONE_STATE,
//                Manifest.permission.READ_PHONE_NUMBERS,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                Manifest.permission.ACCESS_NETWORK_STATE)

        permissions.forEach { str ->
            val shouldStr = ActivityCompat.shouldShowRequestPermissionRationale(this, str);
            Log.d("ddebug", "$str  shouldStr = $shouldStr")
            if (ActivityCompat.checkSelfPermission(this, str) != PackageManager.PERMISSION_GRANTED) {
                list.add(str)
            }

        }

        Log.d("ddebug", "list = ${list.toString()}")
        if (list.size > 0) {
            //val str = list.removeAt(0)
            ActivityCompat.requestPermissions(this, list.toTypedArray(), 10001)
        }


//        ActivityCompat.requestPermissions(this,
//                array,
//                2)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val mPermissions: Array<String> = permissions as Array<String>
        if (grantResults.size > 0) {
            for (i in grantResults.indices) {
                if (grantResults[i] == -1 ) {
                    //ARouter.getInstance().build("/utils/").withString("mPermission", mPermissions[i]).navigation(this, 1)
                    Log.d("ddebug", "grantResults[$i] = ${grantResults[i]}  --- ${permissions[i]}")
                }
            }
        }
    }
}