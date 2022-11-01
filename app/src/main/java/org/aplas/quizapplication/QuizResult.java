package org.aplas.quizapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResult extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_result);

        TextView result = (TextView)findViewById(R.id.result);
        TextView score = (TextView)findViewById(R.id.score);

        result.setText("True Answer :"+MainActivity.answerTrue+"\nFalse Answer :"+MainActivity.answerFalse);
        score.setText(""+MainActivity.result);
    }

    public void repeat(View view){
        finish();
        Intent a = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(a);
    }
    
    public void logout(View view){
        finish();
        Intent a = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(a);
    }
}
