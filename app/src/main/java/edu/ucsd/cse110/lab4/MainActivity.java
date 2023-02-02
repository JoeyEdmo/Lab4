package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchProfileClicked(View view) {
        Intent starter = new Intent(this, ProfileActivity.class);
        startActivity(starter);
    }

    public void onShowCounterClicked(View view) {
        Intent intent = new Intent(this, CounterActivity.class);
        TextView maxCountView = findViewById(R.id.counterMax);
        String maxCountStr = maxCountView.getText().toString();
        Optional<Integer> maybeMaxCount = Utilities.parseCount(maxCountStr);
        if(!maybeMaxCount.isPresent()){
            Utilities.showAlert(this, "Not a number fool!!!!");
            return;
        }
        int maxCount = maybeMaxCount.get();
        if(!(maxCount>0)){
           Utilities.showAlert(this, "need positive num!!!");
           return;
        }
        //Utilities.showAlert(this, String.format("I got num %d", maxCount));
        Intent starter = new Intent(this, CounterActivity.class);
        starter.putExtra("maxCount", maxCount);
        startActivity(starter);
    }
}