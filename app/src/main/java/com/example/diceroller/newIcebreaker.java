package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class newIcebreaker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_icebreaker);
    }
    public void cancel(View view){
        message(1);
    }
    public void save(View view){
        message(0);
    }
    public void message(int option){
        String message;
        if(option== 1){
            message= "0";
        }
        else{
            EditText editText = (EditText) findViewById(R.id.editText);
            message= editText.getText().toString();
        }
        Intent intent = new Intent();
        intent.putExtra("icebreaker", message);
        setResult(RESULT_OK, intent);
        finish();
    }
}
