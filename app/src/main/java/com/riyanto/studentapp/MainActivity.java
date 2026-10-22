package com.riyanto.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.riyanto.studentapp.viewmodel.StudentViewModel;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pbProgress;
    private ListView lvStudents;
    private StudentAdapter studentAdapter;
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbProgress = findViewById(R.id.pb_progress);
        lvStudents = findViewById(R.id.lv_students);
        studentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);

        // ambil data students
        studentViewModel.getStudents().observe(this, students -> {
            studentAdapter = new StudentAdapter(this, students);
            lvStudents.setAdapter(studentAdapter);
            pbProgress.setVisibility(View.GONE);
        });

        // ambil pesan error
        studentViewModel.getErrorMessage().observe(this, errorMessage -> {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        });
    }
}