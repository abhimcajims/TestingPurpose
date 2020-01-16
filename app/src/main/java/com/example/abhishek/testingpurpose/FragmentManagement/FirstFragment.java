package com.example.abhishek.testingpurpose.FragmentManagement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.abhishek.testingpurpose.R;

public class FirstFragment extends Fragment {

    View view;
    Button firstButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.first_fragment, container, false);

        Log.d("Fragment1: ", "onCreateView");

        firstButton = (Button) view.findViewById(R.id.firstButton);
        // perform setOnClickListener on first Button
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* SecondFragment secondFragment = new SecondFragment();

               FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_main, secondFragment);
                ft.addToBackStack(null);
                ft.commit();*/

                //ft.replace(R.id.frame_main,new SecondFragment()).addToBackStack(null).commit();


                getFragmentManager().beginTransaction().replace(R.id.frame_main, new SecondFragment()).addToBackStack(null).commit();

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Fragment1: ", "onAttach");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment1: ", "onCreate");

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Fragment1: ", "onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Fragment1: ", "onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment1: ", "onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment1: ", "onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragment1: ", "onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment1: ", "onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment1: ", "onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Fragment1: ", "onDetach");

    }
}
