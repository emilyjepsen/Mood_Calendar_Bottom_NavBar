package com.example.moodcalendarbottomnavbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigation;
    FrameLayout frameLayout;
    //fragments
    private Calendar calendarFragment;
    private Resources resourcesFragment;
    private Quotes quotesFragment;
    private Notes notesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);

        //Fragment initialization
        calendarFragment = new Calendar();
        resourcesFragment = new Resources();
        quotesFragment = new Quotes();
        notesFragment = new Notes();


        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //Switch to select which case is chosen:

                switch (menuItem.getItemId()) {
                    case R.id.navigation_calendar :
                        // code to be executed when item 1 selected
                        InitializeFragment(calendarFragment);
                        return true;

                    case R.id.navigation_resources :
                        InitializeFragment(resourcesFragment);
                        return true;

                    case R.id.navigation_quotes :
                        InitializeFragment(quotesFragment);
                        return true;

                    case R.id.navigation_notes :
                        InitializeFragment(notesFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }
    private void InitializeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

    }
}
