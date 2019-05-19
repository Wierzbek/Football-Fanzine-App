package com.example.invernessct.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.invernessct.models.User;

public class SharedPreferenceManager {

    private static final String SHARED_PREFERENCE_NAME = "my_shared_pref";

    private static SharedPreferenceManager mInstance;
    // Context object to handle shared preferences
    private Context mContext;

    // Object constructors
    private SharedPreferenceManager(Context mContext){
        this.mContext = mContext;
    }


    public static synchronized SharedPreferenceManager getInstance(Context mContext){
        if (mInstance == null){
            mInstance = new SharedPreferenceManager(mContext);
        }
        return mInstance;
    }

    public void saveUser(User user){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("user_id", user.getUser_id());
        editor.putString("email", user.getEmail());
        editor.putString("first_name", user.getFirst_name());
        editor.putString("last_name", user.getLast_name());
        editor.putString("reg_date", user.getReg_date());
        editor.putString("user_type", user.getUser_type());

        editor.apply();

    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);

        return sharedPreferences.getInt("user_id", -1) != -1;
    }

    public User getUser(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt("user_id", -1),
                sharedPreferences.getString("email",null),
                sharedPreferences.getString("first_name",null),
                sharedPreferences.getString("last_name",null),
                sharedPreferences.getString("reg_date",null),
                sharedPreferences.getString("user_type", null)
        );
    }

    public void clear(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
