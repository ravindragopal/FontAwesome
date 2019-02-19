package com.example.chaitanya.fontawesome;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chaitanya.fontawesome.font.FontAwesome;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    ImageView imageView;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fa-regular.ttf");

        textView1 = findViewById(R.id.textView1);
        imageView = findViewById(R.id.imageView);
        btnOk = findViewById(R.id.btnOk);

//       textView1.setText("\uf2b9");
//       textView1.setTypeface(fontAwesomeFont);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(FontAwesome.getInstance(MainActivity.this).getFontAwesomeCode("fa-adn"));
                textView1.setTypeface(FontAwesome.getInstance(MainActivity.this).getTypeface("fab"));
                textView1.setTextColor(Color.parseColor("#333333"));
            }
        });

//        Drawable iconDrawable = new FontIconDrawable(this, "f580", fontAwesomeFont).sizeDp(50);
//        imageView.setImageDrawable(iconDrawable);
    }

}
