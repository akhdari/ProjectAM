package com.example.projectam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;  // ← ADD THIS IMPORT
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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
    private ImageView ivFacultyLogo;
    private TextView tvFacultyNameHeader;
    private boolean isArabic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        isArabic = Locale.getDefault().getLanguage().equals("ar");

        getSupportActionBar().setTitle(isArabic ? "الكليات" : "Faculties");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize views - FIXED: remove ivFacultyLogo and tvFacultyNameHeader if not in layout
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

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}