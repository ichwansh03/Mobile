package com.jrektor.mobile.verification

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.jrektor.mobile.R
import com.jrektor.mobile.admin.AdminActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginAdminActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txlogin_admin.visibility = View.GONE
        btndaftar.visibility = View.GONE

        btnlogin.setOnClickListener {
            var intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
        }
    }
}
