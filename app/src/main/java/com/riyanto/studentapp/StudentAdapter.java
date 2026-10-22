package com.riyanto.studentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.riyanto.studentapp.model.Student;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_student, null);
        }

        TextView tvNis = view.findViewById(R.id.tv_nis);
        TextView tvName= view.findViewById(R.id.tv_name);

        tvNis.setText(students.get(i).nis());
        tvName.setText(students.get(i).name());

        return view;
    }
}
