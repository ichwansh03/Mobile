package com.jrektor.mobile.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.jrektor.mobile.R
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    var list = ArrayList<UserItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        getProduct()
    }

    private fun getProduct() {
        var queue: RequestQueue = Volley.newRequestQueue(this)
        var request = JsonArrayRequest(Request.Method.GET, "http://192.168.43.8/db_surau/produk/tampil_produk.php",null,
            { response ->
                for (i in 0 until response.length() - 1){
                    var jsonObj = response.getJSONObject(i)
                    var id = jsonObj.getInt("id")
                    var name = jsonObj.getString("nama")
                    var price = jsonObj.getInt("harga")
                    var image = jsonObj.getString("gambar").replace("127.0.0.1","192.168.43.8")
                    var description = jsonObj.getString("deskripsi")

                    list.add(UserItem(id, name, image, description, price))
                    var adapter = ItemAdapter(this, list)
                    rv_produk.layoutManager = GridLayoutManager(this,2)
                    rv_produk.adapter = adapter
                }
            }, { error ->
                Log.d("error",error.toString())
            })
        queue.add(request)
    }
}