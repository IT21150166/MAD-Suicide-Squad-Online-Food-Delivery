package com.feedbackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.feedbackapp.R.id;

public class MainActivity extends AppCompatActivity {

    EditText t1;
    TextView tvFeedback;
    RatingBar rbStars;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(EditText)findViewById(R.id.t1);

        tvFeedback = findViewById(id.tvFeedback);
        rbStars = findViewById(R.id.rbStars);

        rbStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                if(rating==0)
                {
                    tvFeedback.setText("Very Disatisfied");
                    
                }
                else if(rating==1)
                {
                    tvFeedback.setText(" Disatisfied");
                }
                else if(rating==2 || rating==3)
                {
                    tvFeedback.setText("OK");
                }
                else if(rating==4)
                {
                    tvFeedback.setText("Satisfied");
                }
                else
                {
                    tvFeedback.setText("Very Satisfied");
                }
            }
        });



    }

    public void addRecord(View view){
        DBHelper db=new DBHelper(this);
        db.insertFeedback(t1.getText().toString());

        String res = new String();
        Toast.makeText(this,res,Toast.LENGTH_LONG).show();

        t1.setText("");



    }
}