package com.example.uasmpr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void REGISTER(View view) {
        Intent intent=new Intent(this,Register.class);
        startActivity(intent);
    }

    public void LOGIN(View view) {
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }
}
