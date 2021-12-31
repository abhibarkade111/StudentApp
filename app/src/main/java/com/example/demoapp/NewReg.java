package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewReg extends AppCompatActivity {

    EditText sname, sclass, semail, sbranch, smob;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reg);
        sname=findViewById(R.id.sname);
        semail=findViewById(R.id.semail);
        sclass=findViewById(R.id.sclass);
        sbranch=findViewById(R.id.sbranch);
        smob=findViewById(R.id.smob);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, email, branch, stuclass, mob;
                name=sname.getText().toString();
                email=semail.getText().toString();
                branch=sbranch.getText().toString();
                stuclass=sclass.getText().toString();
                mob= smob.getText().toString();

                SharedPreferences pref = getSharedPreferences("studentD",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name",name);
                editor.putString("email",email);
                editor.putString("branch", branch);
                editor.putString("stuclass",stuclass);
                editor.putString("mob",mob);
                editor.apply();

                Registrations studentsReg = new Registrations();
                studentsReg.setName(name);
                studentsReg.setEmail(email);
                studentsReg.setBranch(branch);
                studentsReg.setStuclass(stuclass);
                studentsReg.setMob(mob);
                DBHelper dbHelper = new DBHelper(NewReg.this,"Student", null, 1);
                dbHelper.registrationsNew(studentsReg);
                Toast.makeText(NewReg.this, "Added successfully", Toast.LENGTH_SHORT).show();



            }
        });


    }
}