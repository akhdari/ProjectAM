package com.example.projectam.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.projectam.R;
import com.example.projectam.models.Department;
import com.example.projectam.models.Faculty;
import com.example.projectam.utils.DataProvider;
import java.util.List;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    private Department department;
    private String facultyNameKey;
    private String facultyAddress;
    private TextView tvName, tvDescription, tvHead, tvPhone, tvEmail, tvSpecialties, tvAddress;
    private Button btnCall, btnSMS, btnEmail, btnMap;
    private boolean isArabic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        isArabic = Locale.getDefault().getLanguage().equals("ar");

        department = (Department) getIntent().getSerializableExtra("department");
        facultyNameKey = getIntent().getStringExtra("facultyName");

        if (department != null) {
            // Get faculty info
            List<Faculty> faculties = DataProvider.getAllFaculties();
            for (Faculty f : faculties) {
                for (Department d : f.getDepartments()) {
                    if (d.getId() == department.getId()) {
                        facultyAddress = f.getCampus();
                        break;
                    }
                }
            }

            // Set title with localized department name
            String deptName;
            if (isArabic) {
                deptName = department.getNameAr();
            } else {
                int resId = getResources().getIdentifier(department.getNameKey(), "string", getPackageName());
                deptName = getString(resId);
            }
            getSupportActionBar().setTitle(deptName);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            initViews();
            displayDetails();
            setupContactButtons();
        }
    }

    private void initViews() {
        tvName = findViewById(R.id.tv_detail_name);
        tvDescription = findViewById(R.id.tv_detail_description);
        tvHead = findViewById(R.id.tv_detail_head);
        tvPhone = findViewById(R.id.tv_detail_phone);
        tvEmail = findViewById(R.id.tv_detail_email);
        tvSpecialties = findViewById(R.id.tv_detail_specialties);
        tvAddress = findViewById(R.id.tv_detail_address);
        btnCall = findViewById(R.id.btn_call);
        btnSMS = findViewById(R.id.btn_sms);
        btnEmail = findViewById(R.id.btn_email);
        btnMap = findViewById(R.id.btn_map);

        // Update button texts based on language
        btnCall.setText(getString(R.string.call));
        btnSMS.setText(getString(R.string.sms));
        btnEmail.setText(getString(R.string.email));
        btnMap.setText(getString(R.string.map));
    }

    private void displayDetails() {
        // Get localized name
        String deptName;
        if (isArabic) {
            deptName = department.getNameAr();
        } else {
            int resId = getResources().getIdentifier(department.getNameKey(), "string", getPackageName());
            deptName = getString(resId);
        }
        tvName.setText(deptName);

        // Get localized description
        String description;
        if (isArabic) {
            description = department.getDescriptionAr();
        } else {
            description = department.getDescription();
        }
        tvDescription.setText(description);

        String headText = (isArabic ? "رئيس القسم: " : "Department Head: ") + department.getHead();
        tvHead.setText(headText);

        tvPhone.setText(department.getPhone());
        tvEmail.setText(department.getEmail());

        String specialtiesText = (isArabic ? "التخصصات:\n• " : "Specialties:\n• ") + department.getSpecialties().replace(", ", "\n• ");
        tvSpecialties.setText(specialtiesText);

        tvAddress.setText(facultyAddress);
    }

    private void setupContactButtons() {
        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + department.getPhone()));
            startActivity(intent);
        });

        btnSMS.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:" + department.getPhone()));
            String message = isArabic ?
                    "مرحباً، أود الحصول على معلومات حول قسم " + department.getNameAr() :
                    "Hello, I would like information about the " + department.getNameKey() + " department";
            intent.putExtra("sms_body", message);
            startActivity(intent);
        });

        btnEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + department.getEmail()));
            String subject = isArabic ?
                    "طلب معلومات - " + department.getNameAr() :
                    "Information Request - " + department.getNameKey();
            String body = isArabic ?
                    "السيد/السيدة المحترم،\n\nأود الحصول على معلومات حول قسم " + department.getNameAr() + ".\n\nتحياتي." :
                    "Dear Sir/Madam,\n\nI would like to request information about the " + department.getNameKey() + " department.\n\nBest regards.";
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(intent);
        });

        btnMap.setOnClickListener(v -> {
            String address = facultyAddress + ", Boumerdes, Algeria";
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                Toast.makeText(this, isArabic ? "خرائط جوجل غير مثبتة" : "Google Maps not installed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}