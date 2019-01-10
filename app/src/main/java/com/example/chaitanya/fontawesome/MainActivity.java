package com.example.chaitanya.fontawesome;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fa-regular-400.ttf");

        textView1 = findViewById(R.id.textView1);
        imageView = findViewById(R.id.imageView);


        textView1.setText("\uf2b9");
        textView1.setTypeface(fontAwesomeFont);


        Drawable iconDrawable = new FontIconDrawable(this, "f580", fontAwesomeFont).sizeDp(50);

        imageView.setImageDrawable(iconDrawable);
    }

}
