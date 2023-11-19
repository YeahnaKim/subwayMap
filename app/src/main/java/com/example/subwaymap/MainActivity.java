package com.example.subwaymap;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(new main());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelectedAction);

        addFragment(new StationSearchFragment());
    }

    private void addFragment(StationSearchFragment stationSearchFragment) {
    }

    private void addFragment(main main) {
        addFragment(new main());
    }

    private boolean onNavigationItemSelectedAction(MenuItem item) {
        int id = item.getItemId();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (id == R.id.navigation1) {
            transaction.replace(R.id.r_main, new main());
        } else if (id == R.id.navigation2) {

            transaction.replace(R.id.r_congestion, new CongestionFregment());
        } else if (id == R.id.navigation3) {
            transaction.replace(R.id.r_mypath, new MypathFragment());
        } else if (id == R.id.navigation4) {
            transaction.replace(R.id.r_mypage, new MypageFragment());
        } else {
            return false;
        }

        transaction.commit();
        return true;
    }


}
