package com.jrektor.mobile.user

class UserItem {

    var id: Int
    var nama: String = String()
    var gambar: String = String()
    var keterangan: String = String()
    var harga: Int

    constructor(id: Int, nama: String, gambar: String, keterangan: String, harga: Int) {
        this.id = id
        this.nama = nama
        this.gambar = gambar
        this.keterangan = keterangan
        this.harga = harga
    }
}