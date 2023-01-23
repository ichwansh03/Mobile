package com.jrektor.mobile.verification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.jrektor.mobile.R
import com.jrektor.mobile.user.UserActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var loginUrl = "http://192.168.43.8/db_surau/verif/login.php"

        btnlogin.setOnClickListener {
            var request: RequestQueue = Volley.newRequestQueue(applicationContext)
            var strRequest = StringRequest(Request.Method.GET, loginUrl+"?email="+emailLogin.text.toString()+"&password="+pwLogin.text.toString(),
                { response ->
                    if (response.equals("0")){
                        Toast.makeText(applicationContext,"Login Berhasil", Toast.LENGTH_SHORT).show()
                        var intent = Intent(this, UserActivity::class.java)
                        startActivity(intent)
                    }
                },{
                    error ->
                    Log.d("error",error.toString())
                })
            request.add(strRequest)
        }

        btndaftar.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        txlogin_admin.setOnClickListener {
            var intent = Intent(this, LoginAdminActivity::class.java)
            startActivity(intent)
        }
    }
}