package com.example.projectbesar.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    static final String KEY_USERNAME ="username";
    static final String KEY_PASSWORD ="password";
    static final String KEY_ID ="id";
    static final String KEY_NAMA_ANAK = "nama_anak";
    static final String KEY_JENIS_KELAMIN = "jenis_kelamin";
    static final String KEY_TEMPAT_LAHIR = "tempat_lahir";
    static final String KEY_TGL_LAHIR = "tgl_lahir";
    static final String KEY_NAMA_IBU = "nama_ibu";
    static final String KEY_TELEPONE = "telepone";

    public static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setKeyUsername(Context context, String username){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_USERNAME, username);
        editor.apply();
    }

    public static String getKeyUsername(Context context) {
        return getSharedPreference(context).getString(KEY_USERNAME,"");
    }

    public static void setKeyPassword(Context context, String password){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }

    public static String getKeyPassword(Context context) {
        return getSharedPreference(context).getString(KEY_PASSWORD,"");
    }

    public static void setKeyId(Context context, String id){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_ID, id);
        editor.apply();
    }

    public static String getKeyId(Context context) {
        return getSharedPreference(context).getString(KEY_ID,"");
    }

    public static void setKeyNamaAnak(Context context, String nama_anak){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NAMA_ANAK, nama_anak);
        editor.apply();
    }

    public static String getKeyNamaAnak(Context context) {
        return getSharedPreference(context).getString(KEY_NAMA_ANAK,"");
    }

    public static void setKeyJenisKelamin(Context context, String jenis_kelamin){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_JENIS_KELAMIN, jenis_kelamin);
        editor.apply();
    }

    public static String getKeyJenisKelamin(Context context) {
        return getSharedPreference(context).getString(KEY_JENIS_KELAMIN,"");
    }

    public static void setKeyTempatLahir(Context context, String tempat_lahir){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_TEMPAT_LAHIR, tempat_lahir);
        editor.apply();
    }

    public static String getKeyTempatLahir(Context context) {
        return getSharedPreference(context).getString(KEY_TEMPAT_LAHIR,"");
    }

    public static void setKeyTglLahir(Context context, String tgl_lahir){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_TGL_LAHIR, tgl_lahir);
        editor.apply();
    }

    public static String getKeyTglLahir(Context context) {
        return getSharedPreference(context).getString(KEY_TGL_LAHIR,"");
    }

    public static void setKeyNamaIbu(Context context, String nama_ibu){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_NAMA_IBU, nama_ibu);
        editor.apply();
    }

    public static String getKeyNamaIbu(Context context) {
        return getSharedPreference(context).getString(KEY_NAMA_IBU,"");
    }

    public static void setKeyTelepone(Context context, String telepone){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY_TELEPONE, telepone);
        editor.apply();
    }

    public static String getKeyTelepone(Context context) {
        return getSharedPreference(context).getString(KEY_TELEPONE,"");
    }

    public static void clearLoggedInUser (Context context){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.remove(KEY_ID);
        editor.remove(KEY_USERNAME);
        editor.remove(KEY_NAMA_ANAK);
        editor.remove(KEY_JENIS_KELAMIN);
        editor.remove(KEY_TGL_LAHIR);
        editor.remove(KEY_TEMPAT_LAHIR);
        editor.remove(KEY_NAMA_IBU);
        editor.remove(KEY_TELEPONE);
        editor.remove(KEY_PASSWORD);
        editor.apply();
    }
}
