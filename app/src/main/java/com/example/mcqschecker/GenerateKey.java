package com.example.mcqschecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Layer;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GenerateKey extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ScrollView layout = new ScrollView(this);
       //layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(444);
        LinearLayout layout1 = new LinearLayout(this);
        layout1.setOrientation(LinearLayout.VERTICAL);



        //  ROWS & Buttons
        for (int i = 1; i<30; i++) {

            LinearLayout row = new LinearLayout(this);

            Button A = new Button(this);
            Button B = new Button(this);
            Button C = new Button(this);
            Button D = new Button(this);

            int id = i;

            A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    A.setText("K");
                    A.setBackgroundColor(468);
                }
            });
            A.setText("A#" + id);
            B.setText("B#" + id);
            C.setText("C#" + id);
            D.setText("D#" + id);

            A.setId(id);
            B.setId(id);
            C.setId(id);
            D.setId(id);

            row.addView(A);
            row.addView(B);
            row.addView(C);
            row.addView(D);


            layout1.addView(row);
        }

        layout.addView(layout1);
        setContentView(layout);


    }


}