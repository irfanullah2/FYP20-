package com.example.mcqschecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcqschecker.databinding.ActivityLoginBinding;
import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

   FirebaseAuth Firebase =FirebaseAuth.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.homepage_menu,menu);
        return true;
    }
    public void GenerateKey (View view)
        {

            Intent i = new Intent(this, GenerateKey.class);
            startActivity(i);
    }


    public void Examcheck(View view) {
        startActivity(new Intent(this,ExamActivity.class));

    };

    public void Setting(View view) {
        startActivity(new Intent(this,SettingActivity.class));
    }
}


