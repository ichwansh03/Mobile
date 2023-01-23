package com.jrektor.mobile.user

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jrektor.mobile.GlobalData
import com.jrektor.mobile.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_produk.view.*

class ItemAdapter (var context: Context, var list: ArrayList<UserItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    class itemAdapter(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun produk(name: String, price: Int, image: String){
            itemView.nama_produk.text = name
            itemView.harga_produk.text = "Rp.${price.toString()}"
            Picasso.get().load(image).into(itemView.img_produk)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view:View = LayoutInflater.from(context).inflate(R.layout.item_produk, parent, false)

        return itemAdapter(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as itemAdapter).produk(list[position].nama, list[position].harga, list[position].gambar)
        (holder as itemAdapter).itemView.img_produk.setOnClickListener {
            var intent = Intent(context, DetailProdukActivity::class.java)
            GlobalData.ids = list[position].id
            GlobalData.name = list[position].nama
            GlobalData.price = list[position].harga
            GlobalData.image = list[position].gambar
            GlobalData.description = list[position].keterangan
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}