package tech.mavica.listview_learn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    DBHelper dbHelper;
    SQLiteDatabase dbManager;
    Context context;
    static  String DB_NAME="students";
    static int DB_VERSION = 1;
    static  String table_name="students";
    static  String column_id="id";
    static String column_name="name";
    static  String column_section="section";

    DBManager(Context context,DBHelper dbHelper){
        this.context=context;
        this.dbHelper=dbHelper;
    }

    long insert(String name,String section){
       dbManager= dbHelper.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("section",section);
      long x =  dbManager.insert(table_name,null,cv);
       dbHelper.close();
       return  x;
    }

    Cursor display(){
        dbManager=dbHelper.getWritableDatabase();
        Cursor cursor = dbManager.rawQuery("select * from students",null);

        return cursor;
    }


}
