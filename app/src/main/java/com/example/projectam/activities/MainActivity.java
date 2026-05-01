package com.example.projectam.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;           // ← ADD THIS IMPORT
import android.view.MenuItem;      // ← ADD THIS IMPORT
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.projectam.R;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button btnFaculties, btnSearch, btnAbout;
    private TextView tvUniversityInfo, tvUniversityName;
    private ImageView ivLogo;
    private boolean isArabic = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load saved language preference
        loadLocale();

        setContentView(R.layout.activity_main);

        initViews();
        setupListeners();
        displayUniversityInfo();
        updateTexts();
    }

    // ========== PUT THE MENU CODE HERE ==========
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_language) {
            showLanguageDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // ========== END OF MENU CODE ==========

    private void showLanguageDialog() {
        String[] languages = {"English", "العربية"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Language");
        builder.setItems(languages, (dialog, which) -> {
            if (which == 0) {
                setLocale("en");
            } else if (which == 1) {
                setLocale("ar");
            }
        });
        builder.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Resources res = getResources();
        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(locale);
        res.updateConfiguration(config, res.getDisplayMetrics());

        getSharedPreferences("Settings", MODE_PRIVATE)
                .edit()
                .putString("My_Lang", lang)
                .apply();

        recreate();
    }

    private void loadLocale() {
        String lang = getSharedPreferences("Settings", MODE_PRIVATE)
                .getString("My_Lang", "en");

        isArabic = lang.equals("ar");

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Resources res = getResources();
        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(locale);
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

    private void initViews() {
        btnFaculties = findViewById(R.id.btn_faculties);
        btnSearch = findViewById(R.id.btn_search);
        btnAbout = findViewById(R.id.btn_about);
        tvUniversityInfo = findViewById(R.id.tv_university_info);
        tvUniversityName = findViewById(R.id.tv_university_name);
        ivLogo = findViewById(R.id.iv_logo);
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

    private void updateTexts() {
        btnFaculties.setText(getString(R.string.browse_faculties));
        btnSearch.setText(getString(R.string.search));
        btnAbout.setText(getString(R.string.about));
        tvUniversityName.setText(getString(R.string.university_name));
    }
}