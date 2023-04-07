package com.example.mcqschecker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mcqschecker.databinding.ActivityHomeBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore  firebaseFirestore;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        progressDialog = new ProgressDialog(this);

        binding.SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.UserName.getText().toString();
                String Phone = binding.phone.getText().toString();
                String Email = binding.email.getText().toString().trim();
                String password = binding.password.getText().toString();

firebaseAuth.createUserWithEmailAndPassword(Email,password)
        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                progressDialog.cancel();
                firebaseFirestore.collection("User")
                        .document(FirebaseAuth.getInstance().getUid())
                        .set(new UserModel(username,Phone,Email));
                startActivity(new Intent(HomeActivity.this,HomePage.class));
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(HomeActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.cancel();
            }
        });


            }
        });


        binding.Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));

            }
    });
}}