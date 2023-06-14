package com.example.projectbesar.utils;

public class ServerApi {

    private static final String BASE_URL                = "http://192.168.43.41/web-services";
    //Akun
    public static final String URL_LOGIN                = BASE_URL + "/Api/Login";
    public static final String URL_REGISTRASI           = BASE_URL + "/Api/Register";
    public static final String URL_EDIT_AKUN            = BASE_URL + "/Api/UpdateAkun";
    public static final String URL_RIWAYAT              = BASE_URL + "/Api/Riwayat?id_user=";
    public static final String URL_RIWAYATALL           = BASE_URL + "/Api/RiwayatAll?id_user=";
    //KPSP
    public static final String URL_PERTANYAANKPSP24     = BASE_URL + "/Api/KPSP24?no_pertanyaan=";
    public static final String URL_PERTANYAANKPSP30     = BASE_URL + "/Api/KPSP30?no_pertanyaan=";
    public static final String URL_PERTANYAANKPSP36     = BASE_URL + "/Api/KPSP36?no_pertanyaan=";
    public static final String URL_PERTANYAANKPSP42     = BASE_URL + "/Api/KPSP42?no_pertanyaan=";
    public static final String URL_PERTANYAANKPSP48     = BASE_URL + "/Api/KPSP48?no_pertanyaan=";
    //TDD
    public static final String URL_PERTANYAANTDD1       = BASE_URL + "/Api/TDD1?no_pertanyaan=";
    public static final String URL_PERTANYAANTDD2       = BASE_URL + "/Api/TDD2?no_pertanyaan=";
    public static final String URL_PERTANYAANTDD3       = BASE_URL + "/Api/TDD3?no_pertanyaan=";
    //TDL
    public static final String URL_PERTANYAANTDL        = BASE_URL + "/Api/TDL?no_pertanyaan=";
    //KMME
    public static final String URL_PERTANYAANKMME       = BASE_URL + "/Api/KMME?no_pertanyaan=";
    //CHAT
    public static final String URL_PERTANYAANCHATA      = BASE_URL + "/Api/CHATA?no_pertanyaan=";
    public static final String URL_PERTANYAANCHATB      = BASE_URL + "/Api/CHATB?no_pertanyaan=";
    public static final String URL_PERTANYAANGPPH       = BASE_URL + "/Api/GPPH?no_pertanyaan=";
    public static final String URL_HASILKPSP            = BASE_URL + "/Api/HasilKPSP?kode_status=";
    public static final String URL_HASILTDD             = BASE_URL + "/Api/HasilTDD?kode_status=";
    public static final String URL_HASILTDL             = BASE_URL + "/Api/HasilTDL?kode_status=";
    public static final String URL_HASILKMME            = BASE_URL + "/Api/HasilKMME?kode_status=";
    public static final String URL_HASILCHAT            = BASE_URL + "/Api/HasilCHAT?kode_status=";
    public static final String URL_HASILGPPH            = BASE_URL + "/Api/HasilGPPH?kode_status=";
    //Simpan Hasil
    public static final String URL_SIMPAN_HASIL         = BASE_URL + "/Api/SimpanHasil";

}
