package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
int Scorevalue = 0;
    ArrayList<String> dIcebreakers= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dIcebreakers.add("If you could go anywhere in the world, where would you go?");
        dIcebreakers.add("If you were stranded on a desert island, what three things would you want to take with you?");
        dIcebreakers.add("If you could eat only one food for the rest of your life, what would that be?");
        dIcebreakers.add("If you won a million dollars, what is the first thing you would buy?");
        dIcebreakers.add("If you could spaned the day with one fictional character, who would it be?");
        dIcebreakers.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void on_button_click(View view){
        TextView tv = this.findViewById(R.id.textView);
        Random r = new Random();
        int number = r.nextInt(6)+1;
        tv.setText(Integer.toString(number));

        TextView Score = this.findViewById(R.id.Score);
        EditText userInput;
        userInput = this.findViewById(R.id.editText2);
        String  guess= userInput.getText().toString();
        TextView message = this.findViewById(R.id.textView3);
        if (number==Integer.valueOf(guess)){
            Scorevalue++;
            Score.setText(Integer.toString(Scorevalue));
            message.setText("Congratulations");

        }
        else {
            message.setText("Try Again");
        }
    }
    public void Ice_Breaker (View view){
        TextView message = this.findViewById(R.id.textView3);
        Random r = new Random();
        int number = r.nextInt(dIcebreakers.size());
        message.setText(dIcebreakers.get(number));
    }
    public void newIcebreaker(View view) {
        Intent intent = new Intent(this, newIcebreaker.class);
        startActivityForResult(intent, 69);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String Icebreaker = data.getStringExtra("icebreaker");
        if(!Icebreaker.equals("0")){
            dIcebreakers.add(Icebreaker);
        }
    }
}