package org.aplas.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

//    Button button = true;
//    String password = "student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
//
//        final EditText txtUser = findViewById(R.id.txtUser);
//        final EditText txtPass = findViewById(R.id.txtPass);
        Button btnStart = findViewById(R.id.btnStart);


        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent a = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(a);

            }
        });
    }
}
