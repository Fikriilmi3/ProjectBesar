package com.example.projectbesar.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.projectbesar.models.User;

public class SessionHandler {
    private static final String PREF_NAME = "UserSession";
    private static final String KEY_ID = "id_pengguna";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_NAMA_ANAK = "nama_anak";
    private static final String KEY_JENIS_KELAMIN = "jenis_kelamin";
    private static final String KEY_TEMPAT_LAHIR = "tempat_lahir";
    private static final String KEY_TGL_LAHIR = "tgl_lahir";
    private static final String KEY_NAMA_IBU = "nama_ibu";
    private static final String KEY_TELEPONE = "telepone";
    private static final String KEY_EMPTY = "";
    private Context mContext;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mPreferences;

    public SessionHandler(Context mContext) {
        this.mContext = mContext;
        mPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.mEditor = mPreferences.edit();
    }

    public void loginUser(String idPengguna, String username, String nama_anak, String jenis_kelamin, String tempat_lahir, String tgl_lahir, String nama_ibu, String telepone) {
        mEditor.putString(KEY_ID, idPengguna);
        mEditor.putString(KEY_USERNAME, username);
        mEditor.putString(KEY_NAMA_ANAK, nama_anak);
        mEditor.putString(KEY_JENIS_KELAMIN, jenis_kelamin);
        mEditor.putString(KEY_TEMPAT_LAHIR, tempat_lahir);
        mEditor.putString(KEY_TGL_LAHIR, tgl_lahir);
        mEditor.putString(KEY_NAMA_IBU, nama_ibu);
        mEditor.putString(KEY_TELEPONE, telepone);
        mEditor.commit();
    }

    public User getUserDetails() {
        User user = new User(mPreferences.getString(KEY_ID, KEY_EMPTY), mPreferences.getString(KEY_USERNAME, KEY_EMPTY), mPreferences.getString(KEY_NAMA_ANAK, KEY_EMPTY), mPreferences.getString(KEY_JENIS_KELAMIN, KEY_EMPTY), mPreferences.getString(KEY_TEMPAT_LAHIR, KEY_EMPTY), mPreferences.getString(KEY_TGL_LAHIR, KEY_EMPTY), mPreferences.getString(KEY_NAMA_IBU, KEY_EMPTY),mPreferences.getString(KEY_TELEPONE, KEY_EMPTY));
        return user;
    }

    public void logoutUser() {
        mEditor.clear();
        mEditor.commit();
    }
}
