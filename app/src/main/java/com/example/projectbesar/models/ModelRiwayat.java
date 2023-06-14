package com.example.projectbesar.models;

public class ModelRiwayat {String id_user, id_kategori, id_umur, jumlah_ya, jumlah_tidak, hasil, saran, nama_kategori, umur;

    public ModelRiwayat(){}

    public ModelRiwayat(String id_user, String id_kategori, String id_umur, String jumlah_ya, String jumlah_tidak, String hasil, String saran, String nama_kategori, String umur) {
        this.id_user       = id_user;
        this.id_kategori   = id_kategori;
        this.id_umur       = id_umur;
        this.jumlah_ya     = jumlah_ya;
        this.jumlah_tidak  = jumlah_tidak;
        this.hasil         = hasil;
        this.saran         = saran;
        this.nama_kategori = nama_kategori;
        this.umur          = umur;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getId_umur() {
        return id_umur;
    }

    public void setId_umur(String id_umur) {
        this.id_umur = id_umur;
    }

    public String getJumlah_ya() {
        return jumlah_ya;
    }

    public void setJumlah_ya(String jumlah_ya) {
        this.jumlah_ya = jumlah_ya;
    }

    public String getJumlah_tidak() {
        return jumlah_tidak;
    }

    public void setJumlah_tidak(String jumlah_tidak) {
        this.jumlah_tidak = jumlah_tidak;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }
}
