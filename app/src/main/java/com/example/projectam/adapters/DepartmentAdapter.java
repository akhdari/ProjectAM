package com.example.projectam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.projectam.R;
import com.example.projectam.models.Department;
import java.util.List;
import java.util.Locale;

public class DepartmentAdapter extends ArrayAdapter<Department> {

    private Context context;
    private boolean isArabic;

    public DepartmentAdapter(Context context, List<Department> departments) {
        super(context, 0, departments);
        this.context = context;
        this.isArabic = Locale.getDefault().getLanguage().equals("ar");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_department, parent, false);
        }

        Department department = getItem(position);

        TextView tvName = convertView.findViewById(R.id.tv_item_name);
        TextView tvHead = convertView.findViewById(R.id.tv_item_subtitle);

        // Get localized name from string resources - NO EMOJIS
        String deptName;
        if (isArabic) {
            deptName = department.getNameAr();
        } else {
            int resId = context.getResources().getIdentifier(department.getNameKey(), "string", context.getPackageName());
            deptName = context.getString(resId);
        }

        tvName.setText(deptName);
        tvHead.setText(department.getHead());

        return convertView;
    }
}