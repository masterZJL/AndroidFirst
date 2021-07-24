package com.example.pagerfragmentstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 vp;
    private LinearLayout tabChat, tabContact, tabFind, tabProfile;
    private ImageView imgChat, imgContact, imgFind, imgProfile, imgCurrent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPager();
        initTabView();
    }

    private void initPager() {
        vp = findViewById(R.id.vp);
        List<Fragment> list = new ArrayList<>();
        list.add(BlankFragment.newInstance("微信"));
        list.add(BlankFragment.newInstance("通讯录"));
        list.add(BlankFragment.newInstance("发现"));
        list.add(BlankFragment.newInstance("我"));
        SimpleVPFAdapter adapter = new SimpleVPFAdapter(getSupportFragmentManager(), getLifecycle(), list);
        vp.setAdapter(adapter);
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                selectTabByPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void selectTabByPosition(int position) {
        imgCurrent.setSelected(false);
        switch (position) {
            case 0:
                imgChat.setSelected(true);
                imgCurrent = imgChat;
                break;
            case 1:
                imgContact.setSelected(true);
                imgCurrent = imgContact;
                break;
            case 2:
                imgFind.setSelected(true);
                imgCurrent = imgFind;
                break;
            case 3:
                imgProfile.setSelected(true);
                imgCurrent = imgProfile;
                break;
        }

    }

    private void selectTabByViewId(int vid) {
        imgCurrent.setSelected(false);
        switch (vid) {
            case R.id.tab_chat:
                vp.setCurrentItem(0);
                imgChat.setSelected(true);
                imgCurrent = imgChat;
                break;
            case R.id.tab_contact:
                vp.setCurrentItem(1);
                imgContact.setSelected(true);
                imgCurrent = imgContact;
                break;
            case R.id.tab_find:
                vp.setCurrentItem(2);
                imgFind.setSelected(true);
                imgCurrent = imgFind;
                break;
            case R.id.tab_profile:
                vp.setCurrentItem(3);
                imgProfile.setSelected(true);
                imgCurrent = imgProfile;
                break;
        }
    }

    private void initTabView() {
        TabClickListener listener = new TabClickListener();

        tabChat = findViewById(R.id.tab_chat);
        tabChat.setOnClickListener(listener);
        tabContact = findViewById(R.id.tab_contact);
        tabContact.setOnClickListener(listener);
        tabFind = findViewById(R.id.tab_find);
        tabFind.setOnClickListener(listener);
        tabProfile = findViewById(R.id.tab_profile);
        tabProfile.setOnClickListener(listener);

        imgChat = findViewById(R.id.img_chat);
        imgContact = findViewById(R.id.img_contact);
        imgFind = findViewById(R.id.img_find);
        imgProfile = findViewById(R.id.img_profile);

        imgCurrent = imgChat;
        imgChat.setSelected(true);
    }

    class TabClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            selectTabByViewId(v.getId());
        }
    }

}