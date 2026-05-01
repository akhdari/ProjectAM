package com.example.projectam.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;           // ← ADD THIS IMPORT
import android.view.MenuItem;      // ← ADD THIS IMPORT
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.projectam.R;
import com.example.projectam.adapters.FacultyAdapter;
import com.example.projectam.models.Faculty;
import com.example.projectam.utils.DataProvider;
import java.util.List;
import java.util.Locale;

public class FacultyActivity extends AppCompatActivity {

    private ListView listViewFaculties;
    private List<Faculty> faculties;
    private boolean isArabic = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_faculty);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        updateActionBarTitle();

        listViewFaculties = findViewById(R.id.list_view_faculties);
        faculties = DataProvider.getAllFaculties();

        FacultyAdapter adapter = new FacultyAdapter(this, faculties);
        listViewFaculties.setAdapter(adapter);

        listViewFaculties.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(FacultyActivity.this, DepartmentActivity.class);
            intent.putExtra("faculty", faculties.get(position));
            startActivity(intent);
        });
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
        } else if (item.getItemId() == android.R.id.home) {
            finish();
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

    private void updateActionBarTitle() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.browse_faculties));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}