 package com.example.projectam.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.projectam.R;
import com.example.projectam.adapters.DepartmentAdapter;
import com.example.projectam.models.Faculty;
import java.util.Locale;

public class DepartmentActivity extends AppCompatActivity {

    private ListView listViewDepartments;
    private Faculty faculty;
    private ImageView ivFacultyLogo;
    private TextView tvFacultyNameHeader;
    private boolean isArabic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        isArabic = Locale.getDefault().getLanguage().equals("ar");

        faculty = (Faculty) getIntent().getSerializableExtra("faculty");

        if (faculty != null) {
            // Set faculty name as title
            String facultyName;
            if (isArabic) {
                facultyName = faculty.getNameAr();
            } else {
                int resId = getResources().getIdentifier(faculty.getNameKey(), "string", getPackageName());
                facultyName = getString(resId);
            }
            getSupportActionBar().setTitle(facultyName);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            initViews();
            displayFacultyLogo();
            setupDepartmentsList();
        }
    }

    private void initViews() {
        ivFacultyLogo = findViewById(R.id.iv_faculty_logo);
        tvFacultyNameHeader = findViewById(R.id.tv_faculty_name_header);
        listViewDepartments = findViewById(R.id.list_view_departments);
    }

    private void displayFacultyLogo() {
        // Display faculty logo
        int logoResId = getResources().getIdentifier(faculty.getLogoResourceName(), "drawable", getPackageName());
        if (logoResId != 0) {
            ivFacultyLogo.setImageResource(logoResId);
            ivFacultyLogo.setVisibility(View.VISIBLE);
        }

        // Display faculty name in header
        String facultyName;
        if (isArabic) {
            facultyName = faculty.getNameAr();
        } else {
            int resId = getResources().getIdentifier(faculty.getNameKey(), "string", getPackageName());
            facultyName = getString(resId);
        }
        tvFacultyNameHeader.setText(facultyName);
        tvFacultyNameHeader.setVisibility(View.VISIBLE);
    }

    private void setupDepartmentsList() {
        DepartmentAdapter adapter = new DepartmentAdapter(this, faculty.getDepartments());
        listViewDepartments.setAdapter(adapter);

        listViewDepartments.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(DepartmentActivity.this, DetailActivity.class);
            intent.putExtra("department", faculty.getDepartments().get(position));
            intent.putExtra("facultyName", faculty.getNameKey());
            intent.putExtra("facultyLogo", faculty.getLogoResourceName());
            startActivity(intent);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}