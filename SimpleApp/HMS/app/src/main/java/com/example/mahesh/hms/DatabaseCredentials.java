package com.example.mahesh.hms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by mahesh on 9/15/2015.
 */
public class DatabaseCredentials extends SQLiteOpenHelper {
public static final String DATABASE_NAME="HotelDetails";
public static final String TABLE_NAME="CustomerDetails";
    public static final String KEY_CUSTOMER_ID="customer_id";
    public static final String KEY_PASSWORD="password";
   // public static final String KEY_MAC_ADDRESS="mac_address";
    String str="CREATE TABLE "+TABLE_NAME + "("+"c_id integer primary key autoincrement,"+KEY_CUSTOMER_ID+" ,"+KEY_PASSWORD+")";
    DatabaseCredentials(Context context){
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


db.execSQL(str);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseCredentials.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
db.execSQL("drop table if exists CustomerDetails");
        onCreate(db);
    }

boolean addCustomerDetails(DeviceDetails deviceDetails){
    boolean check=false;
    try {
        Log.w("Data Qurey",""+str);

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_CUSTOMER_ID, deviceDetails.get_customer_id());
        contentValues.put(KEY_PASSWORD, deviceDetails.get_password());
        //contentValues.put(KEY_MAC_ADDRESS, deviceDetails.get_mac_addr());
        long row = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        if (row!=-1) {
            Log.w(DatabaseCredentials.class.getName(),
                    "Data added to database successfully " + deviceDetails.get_customer_id() + "  "
            );
            check=true;

        } else {
            check=false;
            Log.w(DatabaseCredentials.class.getName(),
                    "Data is not added to database  "
            );

        }

        sqLiteDatabase.close();
    }catch (Exception e){
        e.printStackTrace();
    }
return check;
}

    boolean checkLoginCredentials(LoginCredentials loginCredentials){
boolean check_user=false;
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cur=sqLiteDatabase.rawQuery("select password from CustomerDetails where customer_id=?",new String[]{loginCredentials.getUser()});
        cur.moveToFirst();
String pass=cur.getString(cur.getColumnIndex(KEY_PASSWORD));
        String password=loginCredentials.getPass();

    Log.e("Password",cur.getString(cur.getColumnIndex(KEY_PASSWORD)));
Log.e("User",loginCredentials.getUser());
    Log.e("Pass",loginCredentials.getPass());
    if(pass.equals(password)){
    check_user= true;
}
Log.e("Sat",""+pass.equals(password)+"status"+check_user);

return check_user;
    }


}
