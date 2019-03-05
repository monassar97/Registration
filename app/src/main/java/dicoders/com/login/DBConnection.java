package dicoders.com.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBConnection extends SQLiteOpenHelper {
    public  static  final int VERSION=1;
    public static final String DbName="parent.db";
    String COLUMN_USER_ID="id";
    public DBConnection( Context context) {
        super(context, DbName, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS \"parent\" (\"id\"INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\"name\"TEXT NOT NULL," +
                "\"email\"TEXT NOT NULL,\"phone\"INTEGER NOT NULL,\"password\"TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVErsion, int newVersion) {
        db.execSQL("DROP table if EXISTS parent");
        onCreate(db);

    }

    public void insertRowParents(String name,String email,String phone, String password) {
        SQLiteDatabase db =this.getWritableDatabase();
        try {


            ContentValues newValues = new ContentValues();

            newValues.put("name",name);
            newValues.put("email", email);
            newValues.put("phone",phone);
            newValues.put("password", password);

            long result=db.insert("parent", null, newValues);
            db.close();

        }catch(Exception ex) {
            ex.printStackTrace();
        }

    }
    public ArrayList getAllRecords(){
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from parent",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            arrayList.add("Email : "+cursor.getString(cursor.getColumnIndex("email"))+" Password : "+cursor.getString(cursor.getColumnIndex("password")));
            cursor.moveToNext();
        }
        return arrayList;
    }

    //add new Parent
    public void addParent(Parent parent) {
        /*SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",parent.getName());
        values.put("email", parent.getEmail());
        values.put("phone",parent.getPhoneNumber());
        values.put("password", parent.getPasswsord());

        // Inserting Row
        //db.insert("parent", null, values);*/
        insertRowParents(parent.getName(),parent.getEmail(),parent.getPhoneNumber(),parent.getPasswsord());
        //db.close();
    }


    public boolean checkUser(String name,String password){
        SQLiteDatabase db=this.getReadableDatabase();
        String[] selectionArgs = {name, password};
        String[] columns = {
                COLUMN_USER_ID
        };
        String selection = "name" + " = ?" + " AND " + "password" + " = ?";

        // selection arguments
        //Cursor cursor=db.rawQuery("select count(*) from parent where email="+email+"and password="+password,null);
        Cursor cursor = db.query("parent", //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;



    }
    public boolean checkUser(String name){
        SQLiteDatabase db=this.getReadableDatabase();
        String[] selectionArgs = {name};
        String[] columns = {
                COLUMN_USER_ID
        };
        String selection = "name" + " = ?";

        // selection arguments
        //Cursor cursor=db.rawQuery("select count(*) from parent where email="+email+"and password="+password,null);
        Cursor cursor = db.query("parent", //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;



    }
    public boolean checkUserEmail(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        String[] selectionArgs = {email};
        String[] columns = {
                COLUMN_USER_ID
        };
        String selection = "email" + " = ?";

        // selection arguments
        //Cursor cursor=db.rawQuery("select count(*) from parent where email="+email+"and password="+password,null);
        Cursor cursor = db.query("parent", //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;



    }

    public boolean checkUserPhoneNumber(String phoneNumber){
        SQLiteDatabase db=this.getReadableDatabase();
        String[] selectionArgs = {phoneNumber};
        String[] columns = {
                COLUMN_USER_ID
        };
        String selection = "phone" + " = ?";

        // selection arguments
        //Cursor cursor=db.rawQuery("select count(*) from parent where email="+email+"and password="+password,null);
        Cursor cursor = db.query("parent", //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;



    }

}
