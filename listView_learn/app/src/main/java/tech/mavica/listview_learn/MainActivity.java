package tech.mavica.listview_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

static ArrayList<String> names=new ArrayList<>();

static ArrayList<String> jobs=new ArrayList<>();

static ArrayList<String> salaries=new ArrayList<>();

static ListView list;
static DBManager dbManager;
static DBHelper dbHelper;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.listview);
        dbHelper=new DBHelper(this);
        dbManager=new DBManager(this,dbHelper);
//        dbManager.insert("alaa hammad","Software engineer","800");
//        dbManager.insert("alaa hammad 2","Software engineer","800");
//        dbManager.insert("alaa hammad 3","Software engineer","800");
       refreshUI(dbManager.display());
        CustomAdapter adapter = new CustomAdapter(this,names,jobs,salaries);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent =new Intent(MainActivity.this,StudentsActivityInfo.class);
                Toast.makeText(MainActivity.this, "sent id : "+i, Toast.LENGTH_SHORT).show();
                intent.putExtra("id",""+i);
                intent.putExtra("name",names.get(i));
                intent.putExtra("job",jobs.get(i));
                intent.putExtra("salary",salaries.get(i));
                startActivity(intent);
                }
        });
    }

    void refreshUI(Cursor c) {
        names.clear();
        jobs.clear();
        salaries.clear();
   while(c.moveToNext()){
       names.add(c.getString(1));
       jobs.add(c.getString(2));
       salaries.add(c.getString(3));
   }

    }

}