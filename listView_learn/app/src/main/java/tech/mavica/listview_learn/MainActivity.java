package tech.mavica.listview_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

ArrayList<String> names=new ArrayList<>();
//        {"Mohamad","Mohamad","Mohamad","Mohamad","Mohamad","Mohamad"};
ArrayList<String> sections=new ArrayList<>();
        //{"Cs","Cs","Cs","Cs","Cs","Cs"};
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.listview);
        CustomAdapter adapter = new CustomAdapter(this,names,sections);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "index of item : "+i, Toast.LENGTH_SHORT).show();
            }
        });
    }


}