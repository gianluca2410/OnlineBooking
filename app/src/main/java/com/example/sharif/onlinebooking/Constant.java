package com.example.sharif.onlinebooking;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Constant {
    // italin language words
   static public String UPDATE = "AGGIORNARE";
  static public   String INSERT ="INSERIRE";
    static public   String DELETE ="ELIMINARE";
    static public  String USER ="UTENTE";
    static public  String ADMIN = "AMMINISTRATRICE";
    static public  String CONTACT ="CONTATTO VISIVO";


    // store selected language into sharedpreferances
    public static String getSelectedLanguage(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString("name","English");
    }

    public static void setSelectedLanguage(Context context , String s){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString("name", s).commit();
    }
}
