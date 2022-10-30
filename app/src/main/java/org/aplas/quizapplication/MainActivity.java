package org.aplas.quizapplication;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView quiz;
    RadioGroup rg;
    RadioButton optionA, optionB, optionC, optionD;
    int number = 0;
    public static int result, answerTrue, answerFalse;

    //pertanyaan
    String[] question = new String[]{
            "1. Presiden Indonesia yang keenam adalah",
            "2. Lambang Negara Indonesia adalah",
            "3. Ibukota Indonesia adalah",
            "4. Lagu Kebangsaan Indonesia adalah",
            "5. Bendera Negara Indonesia adalah"
    };

    //pilihan jawaban a, b, c, d
    String[] option = new String[]{
            "Soekarno", "Habibie", "Susilo Bambang Yudhoyono", "Joko Widodo",
            "Gajah Putih", "Garuda", "Macan", "Elang",
            "Jakarta", "Bogor", "Tangerang", "Bekasi",
            "Indonesia Raya", "Tanah Airku", "Indonesia Pusaka", "Indonesia Merdeka",
            "Merah Biru Putih", "Merah Putih", "Putih Merah", "Belang-belang"
    };

    //jawaban benar
    String[] true_answer = new String[]{
            "Susilo Bambang Yudhoyono",
            "Garuda",
            "Jakarta",
            "Indonesia Raya",
            "Merah Putih"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quiz = (TextView) findViewById(R.id.quiz);
        rg = (RadioGroup) findViewById(R.id.option);
        optionA = (RadioButton) findViewById(R.id.optionA);
        optionB = (RadioButton) findViewById(R.id.optionB);
        optionC = (RadioButton) findViewById(R.id.optionC);
        optionD = (RadioButton) findViewById(R.id.optionD);

        quiz.setText(question[number]);
        optionA.setText(option[0]);
        optionB.setText(option[1]);
        optionC.setText(option[2]);
        optionD.setText(option[3]);

        rg.check(0);
        answerTrue = 0;
        answerFalse = 0;
    }

    public void next(View view) {
        if (optionA.isChecked() || optionB.isChecked() || optionC.isChecked() || optionD.isChecked()) {

            RadioButton user_answer = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String get_user_answer = user_answer.getText().toString();
            rg.check(0);
            if (get_user_answer.equalsIgnoreCase(true_answer[number])) answerTrue++;
            else answerFalse++;
            number++;
            if (number < question.length) {
                quiz.setText(question[number]);
                optionA.setText(option[(number * 4) + 0]);
                optionB.setText(option[(number * 4) + 1]);
                optionC.setText(option[(number * 4) + 2]);
                optionD.setText(option[(number * 4) + 3]);

            } else {
                result = answerTrue * 20;
                Intent finish = new Intent(getApplicationContext(), QuizResult.class);
                startActivity(finish);
            }
        }
        else {
            Toast.makeText(this,"You Need to Answer",Toast.LENGTH_LONG).show();
        }
    }
}
