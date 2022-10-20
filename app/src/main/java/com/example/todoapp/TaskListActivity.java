package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class TaskListActivity extends SingleFragmentActivity {
    Fragment fragment;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment=createFragment();
        if (fragment == null) {
            fragment = new TaskFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
    @Override
    protected Fragment createFragment() {
        fragmentManager = getSupportFragmentManager();
        Fragment fragmentx = fragmentManager.findFragmentById(R.id.fragment_container);
        return fragmentx;
    }
}