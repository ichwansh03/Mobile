package com.jrektor.mobile.verification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.jrektor.mobile.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var registUrl = "http://192.168.43.8/db_surau/verif/register.php"

        btndaftar.setOnClickListener {
            if(nama_reg.text.toString().isEmpty() || alamat_reg.text.toString().isEmpty() || telp_reg.text.toString().isEmpty()
                || email_reg.text.toString().isEmpty() || pw_reg.text.toString().isEmpty() || konfirpw_reg.text.toString().isEmpty()){
                Toast.makeText(applicationContext,"Lengkapi data terlebih dahulu",Toast.LENGTH_SHORT).show()
            } else {
                var request: RequestQueue = Volley.newRequestQueue(applicationContext)
                var stringRequest = StringRequest(Request.Method.GET, registUrl+"?name="+nama_reg.text.toString()+"&address="+alamat_reg.text.toString()
                +"&email="+email_reg.text.toString()+"&phone="+telp_reg.text.toString()+"&password="+pw_reg.text.toString(),
                    { response ->
                        if(response.equals("1")){
                            var intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(applicationContext, "sudah digunakan", Toast.LENGTH_SHORT).show()
                        }
                    },
                    { error ->
                        Log.d("error", error.toString())
                    })
                request.add(stringRequest)
            }
        }
    }
}