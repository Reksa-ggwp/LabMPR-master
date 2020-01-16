package com.example.uasmpr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.URI;
import java.net.URISyntaxException;

public class DetailActivity extends AppCompatActivity {
    TextView name,detail;
    ImageView imageIV;
    Button btntokopedia;
    Button btnbukalapak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        name = findViewById(R.id.name);
        detail = findViewById(R.id.detail);
        imageIV = findViewById(R.id.image_detail);
        btntokopedia=findViewById(R.id.tokopedia);
        btnbukalapak=findViewById(R.id.bukalapak);

//        ambil data dari intent
        byte[] bytes = getIntent().getByteArrayExtra("image");
        final String Name = getIntent().getStringExtra("name").replace(" ","");
        String Detail = getIntent().getStringExtra("detail");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes,0,bytes.length);

//        set data ke views
        name.setText(Name);
        detail.setText(Detail);
        imageIV.setImageBitmap(bmp);
        getSupportActionBar().setTitle(Name);
        btntokopedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(mergePaths("http://cutt.ly/",Name)));
                startActivity(intent);
            }
        });

        btnbukalapak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(mergePaths("http://bit.ly/",Name)));
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    
    public String mergePaths(String oldPath, String newPath) {
        try {
            URI oldUri = new URI(oldPath);
            URI resolved = oldUri.resolve(newPath);
            return resolved.toString();
        } catch (URISyntaxException e) {
            return oldPath;
        }
    }


}
