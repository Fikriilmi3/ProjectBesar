package com.example.projectbesar.models;

public class ModelDataPertanyaan {String id_soal, id_kategori, id_umur, no_pertanyaan, pertanyaan, gambar ;

    public ModelDataPertanyaan(){}

    public ModelDataPertanyaan(String id_soal, String id_kategori, String id_umur, String no_pertanyaan, String pertanyaan, String gambar){
        this.id_soal       = id_soal;
        this.id_kategori   = id_kategori;
        this.id_umur       = id_umur;
        this.no_pertanyaan = no_pertanyaan;
        this.pertanyaan    = pertanyaan;
        this.gambar        = gambar;
    }

    public String getId_soal() {
        return id_soal;
    }

    public void setId_soal(String id_soal) {
        this.id_soal = id_soal;
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

    public String getNo_pertanyaan() {
        return no_pertanyaan;
    }

    public void setNo_pertanyaan(String no_pertanyaan) {
        this.no_pertanyaan = no_pertanyaan;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
