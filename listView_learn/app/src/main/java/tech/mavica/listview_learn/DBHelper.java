package tech.mavica.listview_learn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    Context context;
    static  String DB_NAME="students";
    static int DB_VERSION = 1;
    static  String table_name="students";
    static  String column_id="id";
    static String column_name="name";
    static  String column_section="section";

    DBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table students (id integer primary key autoincrement , name text , section text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
