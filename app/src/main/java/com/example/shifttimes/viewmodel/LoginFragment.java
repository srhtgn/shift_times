package com.example.shifttimes.viewmodel;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shifttimes.R;

public class LoginFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @SuppressLint("CutPasteId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button loginButton;
        loginButton = view.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
            }
        });

        Button goToRegisterPageButton;
        goToRegisterPageButton = view.findViewById(R.id.goToRegisterPageButton);
        goToRegisterPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegisterPage(view);
            }
        });

    }
    private void initComponents(){

    }

    public void goToRegisterPage(View view) {
        NavDirections action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment();
        Navigation.findNavController(view).navigate(action);
    }
}