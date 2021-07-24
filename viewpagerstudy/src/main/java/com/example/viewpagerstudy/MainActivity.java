package com.example.viewpagerstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 pager2 = findViewById(R.id.vpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter();
        pager2.setAdapter(adapter);
    }
}