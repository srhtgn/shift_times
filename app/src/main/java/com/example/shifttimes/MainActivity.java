package com.example.shifttimes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

//    NavOptions options;
//    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_graph);
//        NavOptions.Builder builder = new NavOptions.Builder();
//        builder.setLaunchSingleTop(true);
//        options = builder.build();
//        assert navHostFragment != null;
//        navController = navHostFragment.getNavController();
    }
}