package com.example.projectam.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.projectam.R;
import com.example.projectam.utils.DataProvider;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button btnFaculties, btnSearch, btnAbout;
    private TextView tvUniversityInfo, tvUniversityName;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupListeners();
        displayUniversityInfo();
    }

    private void initViews() {
        btnFaculties = findViewById(R.id.btn_faculties);
        btnSearch = findViewById(R.id.btn_search);
        btnAbout = findViewById(R.id.btn_about);
        tvUniversityInfo = findViewById(R.id.tv_university_info);
        tvUniversityName = findViewById(R.id.tv_university_name);
        ivLogo = findViewById(R.id.iv_logo);

        // Set UMBB logo
        ivLogo.setImageResource(R.drawable.logo_of_umbb);
    }

    private void setupListeners() {
        btnFaculties.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, FacultyActivity.class));
        });

        btnSearch.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SearchActivity.class));
        });

        btnAbout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.about_title));
            builder.setMessage(getString(R.string.about_message));
            builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
            builder.show();
        });
    }

    private void displayUniversityInfo() {
        tvUniversityInfo.setText(getString(R.string.university_presentation));
    }
}