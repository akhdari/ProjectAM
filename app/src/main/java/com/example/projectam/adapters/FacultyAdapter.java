package com.example.projectam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.projectam.R;
import com.example.projectam.models.Faculty;
import java.util.List;
import java.util.Locale;

public class FacultyAdapter extends ArrayAdapter<Faculty> {

    private Context context;
    private boolean isArabic;

    public FacultyAdapter(Context context, List<Faculty> faculties) {
        super(context, 0, faculties);
        this.context = context;
        this.isArabic = Locale.getDefault().getLanguage().equals("ar");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_faculty, parent, false);
        }

        Faculty faculty = getItem(position);

        TextView tvName = convertView.findViewById(R.id.tv_item_name);
        TextView tvCampus = convertView.findViewById(R.id.tv_item_subtitle);

        // Get localized name from string resources
        String facultyName;
        if (isArabic) {
            facultyName = faculty.getNameAr();
        } else {
            int resId = context.getResources().getIdentifier(faculty.getNameKey(), "string", context.getPackageName());
            facultyName = context.getString(resId);
        }

        tvName.setText(facultyName);
        tvCampus.setText(faculty.getCampus());

        return convertView;
    }
}