package tech.mavica.listview_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentsActivityInfo extends AppCompatActivity {
Button btn_delete;
Button btn_update;
Button btn_insert;
EditText et_name;
EditText et_section;
String id;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studnets_info);


        et_name=findViewById(R.id.et_name);
        et_section=findViewById(R.id.et_section);
        btn_insert=findViewById(R.id.btn_insert);
        btn_update=findViewById(R.id.btn_update);
        btn_delete=findViewById(R.id.btn_delete);
        Intent intent = getIntent();
        id=intent.getStringExtra("id");
        Toast.makeText(this, "getted id in intent : "+id, Toast.LENGTH_SHORT).show();
        et_name.setText(intent.getStringExtra("name"));
        et_section.setText(intent.getStringExtra("section"));

    }

    public void deleteStudent(View view){
       long x = MainActivity.dbManager.deleteStudent(et_name.getText().toString());
        Toast.makeText(this, "deleted id : "+id + "nom. rows : "+x, Toast.LENGTH_SHORT).show();
    startActivity(new Intent(StudentsActivityInfo.this,MainActivity.class));
    }

    public void updateStudentInfo(View view){
    MainActivity.dbManager.updateStudentInfo(et_name.getText().toString(),et_section.getText().toString());
        startActivity(new Intent(this,MainActivity.class));
    }

    public void insertStudent(View view){
        MainActivity.dbManager.insert(et_name.getText().toString(),et_section.getText().toString());
        startActivity(new Intent(this,MainActivity.class));
    }
}