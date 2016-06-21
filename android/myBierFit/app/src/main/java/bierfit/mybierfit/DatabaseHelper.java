package bierfit.mybierfit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kosha on 20/06/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    // Logcat tag
    private static final String LOG = DatabaseHelper.class.getName();

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = R.string.app_name + ".db";

    // Table Names

    private static final String TABLE_BEER = "BEER";
    private static final String TABLE_CONSUMEEVENT = "CONSUME_EVENT";

    //----------------- TABLE NAME
    private static final String TABLE_USER = "USER";
    //----------------- USER
    public static final String USER_COLUMN_ID = "id";
    public static final String USER_COLUMN_EMAIL = "email";
    public static final String USER_COLUMN_ENC_PW = "encrypted_password";
    public static final String USER_COLUMN_RES_PW_TOKEN = "reset_password_token";
    public static final String USER_COLUMN_PW_SENT_AT = "reset_password_sent_at";
    public static final String USER_COLUMN_REM_CREATED_AT = "remember_created_at";
    public static final String USER_COLUMN_SIGN_IN_COUNT = "sign_in_count";

    public static final String USER_COLUMN_CUR_SIGN_IN = "current_sign_in_at";
    public static final String USER_COLUMN_LAST_SIGN_IN = "last_sign_in_at";
    public static final String USER_COLUMN_LAST_SIGN_IN_IP = "last_sign_in_ip";

    public static final String USER_COLUMN_CREATED_AT = "created_at";
    public static final String USER_COLUMN_UPDATED_AT = "updated_at";

    public static final String USER_COLUMN_CNF_TOKEN = "confirmation_token";
    public static final String USER_COLUMN_CNF_AT = "confirmed_at";
    public static final String USER_COLUMN_CNF_SENT_AT = "confirmation_sent_at";

    public static final String USER_COLUMN_ADMIN = "admin";
    public static final String USER_COLUMN_USERNAME = "username";
    public static final String USER_COLUMN_NAME = "name";
    public static final String USER_COLUMN_PUBLIC = "public";
    public static final String USER_COLUMN_SLUG= "slug";
    public static final String USER_COLUMN_LOGEDIN= "isLogedIn";


    // Table Create Statements
    // USER table create statement
    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" +
            USER_COLUMN_ID + " INTEGER PRIMARY KEY," +
            USER_COLUMN_EMAIL + " VARCHAR(255)," +
            USER_COLUMN_ENC_PW + " VARCHAR(255)," +
            USER_COLUMN_RES_PW_TOKEN + " VARCHAR(255)," +
            USER_COLUMN_PW_SENT_AT + " DATETIME," +
            USER_COLUMN_REM_CREATED_AT + " DATETIME," +
            USER_COLUMN_SIGN_IN_COUNT + " INTEGER" +
            USER_COLUMN_CUR_SIGN_IN + " DATETIME," +
            USER_COLUMN_LAST_SIGN_IN + " DATETIME," +
            USER_COLUMN_LAST_SIGN_IN_IP + " VARCHAR(255)," +
            USER_COLUMN_CREATED_AT + " DATETIME" +
            USER_COLUMN_UPDATED_AT + " DATETIME," +
            USER_COLUMN_CNF_TOKEN + " VARCHAR(255)," +
            USER_COLUMN_CNF_AT + " DATETIME," +
            USER_COLUMN_CNF_SENT_AT + " DATETIME" +
            USER_COLUMN_ADMIN + " BOOLEAN," +
            USER_COLUMN_USERNAME + " VARCHAR(255)," +
            USER_COLUMN_NAME + " VARCHAR(255)," +
            USER_COLUMN_PUBLIC + " BOOLEAN," +
            USER_COLUMN_SLUG + " VARCHAR(255)," +
            USER_COLUMN_LOGEDIN + " BOOLEAN" + ")";


    private HashMap hp;

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_USER);
        onCreate(db);
    }

    public boolean existUser(String name) {

        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery =
                "SELECT " + "*" + " FROM " + TABLE_USER +
                " WHERE " + USER_COLUMN_NAME + " = \"" + name + "\"";

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

//        if(c != null) {
//            c.moveToFirst();
//        } else
//            return true;
        if( c.moveToFirst()) {
            Log.e(LOG, c.getString(0));
            closeDB();
            Log.e("exist User", "true");
            return true;
        } else {
            closeDB();
            Log.e("exist User", "false");
            return false;
        }
    }

    public long createUser(String name, String password) {
        User user = new User(name, name+"@student.tugraz.at", password);
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_COLUMN_NAME, user.getUsername());
        values.put(USER_COLUMN_EMAIL, user.getUsername() + "@student.tugraz.at");
        values.put(USER_COLUMN_ENC_PW, user.getEncrypted_password());

        //insert row
        long user_id = db.insert(TABLE_USER, null, values);

        closeDB();

        return user_id;
    }

    public void logoutUser() {
        User loggedUser = getLogedUser();
        if(loggedUser != null) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(USER_COLUMN_LOGEDIN, false);

            //insert row
            long user_id = db.update(TABLE_USER, values, USER_COLUMN_NAME + " LIKE ?",
                    new String[]{String.valueOf(loggedUser.getUsername())});

            closeDB();
        }


    }

    public boolean loginUser(String name, String password) {


        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery =
                "SELECT " + "*" + " FROM " + TABLE_USER +
                        " WHERE " + USER_COLUMN_NAME + " = \"" + name +"\"";

        Log.e("login: ", name +" with pw: " + password);

        Cursor c = db.rawQuery(selectQuery, null);

        if( c.moveToFirst()) {

            User logedUser = new User();
            logedUser.setUsername(c.getString(c.getColumnIndex(USER_COLUMN_NAME)));
            logedUser.setEmail(c.getString(c.getColumnIndex(USER_COLUMN_EMAIL)));
            logedUser.setEncrypted_password(c.getString(c.getColumnIndex(USER_COLUMN_ENC_PW)));

//            Log.e("loged User: ", logedUser.toString());
//            Log.e("login data: ", name + ", " + password);

            if (logedUser.getUsername().equals(name) && logedUser.getEncrypted_password().equals(password)) {
                db = this.getWritableDatabase();

//                Log.e("loged User: ", logedUser.toString());
                ContentValues values = new ContentValues();
                values.put(USER_COLUMN_LOGEDIN, "true");

                //insert row
                long user_id = db.update(TABLE_USER, values, USER_COLUMN_NAME + " LIKE ?",
                        new String[]{String.valueOf(name)});

                closeDB();

                return true;
            }
        }
        return false;
    }
    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public User getLogedUser() {

        SQLiteDatabase db = this.getReadableDatabase();

        //TODO instead of name logedIn
        String selectQuery =
                "SELECT " + " * " + " FROM " + TABLE_USER +
                        " WHERE " + USER_COLUMN_LOGEDIN + " = 1";

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if( c.moveToFirst()) {

            User logedUser = new User();
            logedUser.setUsername(c.getString(c.getColumnIndex(USER_COLUMN_NAME)));
            logedUser.setEmail(c.getString(c.getColumnIndex(USER_COLUMN_EMAIL)));
//            Log.e("User", logedUser.getUsername());
            return logedUser;
        }

        closeDB();
        return null;
    }
//    public boolean insertContact  (String name, String phone, String email, String street,String place)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", name);
//        contentValues.put("phone", phone);
//        contentValues.put("email", email);
//        contentValues.put("street", street);
//        contentValues.put("place", place);
//        db.insert("contacts", null, contentValues);
//        return true;
//    }
//
//    public Cursor getData(int id){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
//        return res;
//    }
//
//    public int numberOfRows(){
//        SQLiteDatabase db = this.getReadableDatabase();
//        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
//        return numRows;
//    }
//
//    public boolean updateContact (Integer id, String name, String phone, String email, String street,String place)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", name);
//        contentValues.put("phone", phone);
//        contentValues.put("email", email);
//        contentValues.put("street", street);
//        contentValues.put("place", place);
//        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
//        return true;
//    }
//
//    public Integer deleteContact (Integer id)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete("contacts",
//                "id = ? ",
//                new String[] { Integer.toString(id) });
//    }
//
//    public ArrayList<String> getAllCotacts()
//    {
//        ArrayList<String> array_list = new ArrayList<String>();
//
//        //hp = new HashMap();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res =  db.rawQuery( "select * from contacts", null );
//        res.moveToFirst();
//
//        while(res.isAfterLast() == false){
//            array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
//            res.moveToNext();
//        }
//        return array_list;
//    }
}
