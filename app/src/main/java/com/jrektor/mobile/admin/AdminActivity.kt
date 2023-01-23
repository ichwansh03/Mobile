package com.jrektor.mobile.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jrektor.mobile.R
import kotlinx.android.synthetic.main.activity_admin.*

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        addFragment(MasukFragment())

        frame_masuk.setOnClickListener {
            addFragment(MasukFragment())
        }

        frame_keluar.setOnClickListener {
            addFragment(KeluarFragment())
        }

    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_admin, fragment)
            .commit()
    }
}