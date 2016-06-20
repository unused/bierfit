package bierfit.mybierfit;

import android.content.Context;
import android.util.Log;

/**
 * Created by kosha on 20/06/2016.
 */
public class AccountHandler {

    private DatabaseHelper dbHelper;

    public AccountHandler(Context context) {
        dbHelper = new DatabaseHelper(context);
//        Log.e("database", dbHelper.getReadableDatabase().toString());
    }

    public boolean registerUser(String name, String password) {

         if(!dbHelper.existUser(name)) {
             dbHelper.createUser(name, password);
             Log.e(AccountHandler.class.getName(), "registered User: " + name);
             return true;
         }

        return false;
    }

    public boolean loginUser(String name, String password) {
        //TODO check password
        return !dbHelper.existUser(name);
    }
}
