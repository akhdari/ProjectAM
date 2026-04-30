package com.example.projectam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.projectam.R;
import com.example.projectam.models.Department;
import com.example.projectam.models.Faculty;
import com.example.projectam.utils.DataProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity {

    private SearchView searchView;
    private ListView listViewResults;
    private TextView tvEmptyState;
    private ArrayAdapter<String> adapter;
    private List<SearchItem> searchItems;
    private List<Faculty> faculties;
    private boolean isArabic;

    private static class SearchItem {
        String displayText;
        Object object;
        String type;

        SearchItem(String displayText, Object object, String type) {
            this.displayText = displayText;
            this.object = object;
            this.type = type;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        isArabic = Locale.getDefault().getLanguage().equals("ar");

        getSupportActionBar().setTitle(isArabic ? "بحث" : "Search");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initViews();
        setupSearch();
        setupListView();

        // Initially show empty state (nothing before search)
        showEmptyState();
    }

    private void initViews() {
        searchView = findViewById(R.id.search_view);
        listViewResults = findViewById(R.id.list_view_results);
        tvEmptyState = findViewById(R.id.tv_empty_state);

        // Configure search view
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setIconifiedByDefault(false);
        searchView.clearFocus();
    }

    private void setupSearch() {
        // Load all data once
        faculties = DataProvider.getAllFaculties();
        searchItems = new ArrayList<>();

        // Build search index with localized names
        for (Faculty faculty : faculties) {
            String facultyName = getLocalizedFacultyName(faculty);
            searchItems.add(new SearchItem(facultyName, faculty, "faculty"));

            for (Department dept : faculty.getDepartments()) {
                String deptName = getLocalizedDepartmentName(dept);
                String facultyNameForDept = getLocalizedFacultyName(faculty);
                String displayText = deptName + " (" + facultyNameForDept + ")";
                searchItems.add(new SearchItem(displayText, dept, "department"));
            }
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                performSearch(newText);
                return true;
            }
        });
    }

    private void performSearch(String query) {
        if (query == null || query.trim().isEmpty()) {
            showEmptyState();
            return;
        }

        List<SearchItem> results = new ArrayList<>();
        String lowerQuery = query.toLowerCase().trim();

        for (SearchItem item : searchItems) {
            if (item.displayText.toLowerCase().contains(lowerQuery)) {
                results.add(item);
            }
        }

        if (results.isEmpty()) {
            showNoResultsState();
        } else {
            showResults(results);
        }
    }

    private void showEmptyState() {
        tvEmptyState.setVisibility(View.VISIBLE);
        tvEmptyState.setText(isArabic ? "ابحث عن كلية أو قسم..." : "Search for a faculty or department...");
        listViewResults.setVisibility(View.GONE);
        adapter = null;
    }

    private void showNoResultsState() {
        tvEmptyState.setVisibility(View.VISIBLE);
        tvEmptyState.setText(isArabic ? "لا توجد نتائج" : "No results found");
        listViewResults.setVisibility(View.GONE);
        adapter = null;
    }

    private void showResults(List<SearchItem> results) {
        tvEmptyState.setVisibility(View.GONE);
        listViewResults.setVisibility(View.VISIBLE);

        List<String> displayItems = new ArrayList<>();
        for (SearchItem item : results) {
            String prefix = item.type.equals("faculty") ?
                    (isArabic ? "كلية: " : "Faculty: ") :
                    (isArabic ? "قسم: " : "Department: ");
            displayItems.add(prefix + item.displayText);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayItems);
        listViewResults.setAdapter(adapter);

        // Store results for click handling
        listViewResults.setOnItemClickListener((parent, view, position, id) -> {
            SearchItem selected = results.get(position);
            if (selected.object instanceof Faculty) {
                Intent intent = new Intent(SearchActivity.this, DepartmentActivity.class);
                intent.putExtra("faculty", (Faculty) selected.object);
                startActivity(intent);
            } else if (selected.object instanceof Department) {
                Intent intent = new Intent(SearchActivity.this, DetailActivity.class);
                intent.putExtra("department", (Department) selected.object);
                startActivity(intent);
            }
        });
    }

    private void setupListView() {
        listViewResults.setOnItemClickListener(null);
    }

    private String getLocalizedFacultyName(Faculty faculty) {
        if (isArabic) {
            return faculty.getNameAr();
        } else {
            int resId = getResources().getIdentifier(faculty.getNameKey(), "string", getPackageName());
            return getString(resId);
        }
    }

    private String getLocalizedDepartmentName(Department department) {
        if (isArabic) {
            return department.getNameAr();
        } else {
            int resId = getResources().getIdentifier(department.getNameKey(), "string", getPackageName());
            return getString(resId);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}