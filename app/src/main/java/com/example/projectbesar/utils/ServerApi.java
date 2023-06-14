package com.example.projectbesar.utils;

public class ServerApi {

    private static final String BASE_URL                = "http://192.168.43.41/web-services";

    //Akun
    public static final String URL_LOGIN                = BASE_URL + "/Api/Login";
    public static final String URL_REGISTRASI           = BASE_URL + "/Api/Register";
    public static final String URL_EDIT_AKUN            = BASE_URL + "/Api/UpdateAkun";
    public static final String URL_RIWAYAT              = BASE_URL + "";

    //Pertanyaan
    //KPSP
    public static final String URL_PERTANYAANKPSP24     = BASE_URL + "/Api/KPSP24?no_pertanyaan=";
    public static final String URL_PERTANYAANKPSP30     = BASE_URL + "";
    public static final String URL_PERTANYAANKPSP36     = BASE_URL + "";
    public static final String URL_PERTANYAANKPSP42     = BASE_URL + "";
    public static final String URL_PERTANYAANKPSP48     = BASE_URL + "";

    //Hasil
    //KPSP
    public static final String URL_HASILKPSP24          = BASE_URL + "";
    public static final String URL_HASILKPSP30          = BASE_URL + "";
    public static final String URL_HASILKPSP36          = BASE_URL + "";
    public static final String URL_HASILKPSP42          = BASE_URL + "";
    public static final String URL_HASILKPSP48          = BASE_URL + "";

}
