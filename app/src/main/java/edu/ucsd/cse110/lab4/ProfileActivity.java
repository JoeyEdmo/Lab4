package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

    }

    public void loadProfile(){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String pname = prefs.getString("pname", "not found");
        String sname = prefs.getString("sname", "not found");
        TextView personName =  findViewById(R.id.editPersonName);
        TextView statusName =  findViewById(R.id.editStatusName);
        if(!sname.equals("not found")){
            statusName.setText(sname);
        }
        if(!pname.equals("not found")){
            personName.setText(pname);
        }
    }

    public void saveProfile(){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        TextView personName =  findViewById(R.id.editPersonName);
        TextView statusName =  findViewById(R.id.editStatusName);
        editor.putString("sname", statusName.getText().toString());
        editor.putString("pname", personName.getText().toString());
        editor.apply();
    }

    public void onGoBackClicked(View view) {
        saveProfile();
        finish();
    }
}