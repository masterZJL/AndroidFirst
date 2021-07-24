package com.example.fragmentstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListener listener = new MyListener();
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(listener);

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(listener);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("kk", "knight9");
        fragment.setArguments(bundle);
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    BlankFragment blankFragment = new BlankFragment();
                    blankFragment.setFragmentCallback(new SimpleFragmentCallback() {
                        @Override
                        public void setMessageToActivity(String msg) {
                            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public String getMessageFromActivity() {
                            return "nihao,along...";
                        }
                    });
                    replaceFragment(blankFragment);
                    break;
                case R.id.btn2:
                    replaceFragment(new ItemFragment());
                    break;
            }
        }


    }
}
