package com.example.projectbesar.models;

public class User {
    private String idPengguna;
    private String username;
    private String nama_anak;
    private String jenis_kelamin;
    private String tempat_lahir;
    private String tgl_lahir;
    private String nama_ibu;
    private String telepone;


    public User(String idPengguna, String username, String nama_anak, String jenis_kelamin, String tempat_lahir, String tgl_lahir, String nama_ibu, String telepone) {
        this.idPengguna = idPengguna;
        this.username = username;
        this.nama_anak = nama_anak;
        this.jenis_kelamin = jenis_kelamin;
        this.tempat_lahir = tempat_lahir;
        this.tgl_lahir = tgl_lahir;
        this.nama_ibu = nama_ibu;
        this.telepone = telepone;

    }

    public String getIdPengguna() {
        return idPengguna;
    }

    public String getUsername() {
        return username;
    }

    public String getNama_anak() {return nama_anak;}

    public String getJenis_kelamin() {return jenis_kelamin;}
    public String getTempat_lahir(){return tempat_lahir;}
    public String getTgl_lahir(){return tgl_lahir;}
    public String getNama_ibu(){return nama_ibu;}
    public String getTelepone(){return telepone;}
}
