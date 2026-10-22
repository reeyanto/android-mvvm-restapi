package com.riyanto.studentapp.network;

import com.riyanto.studentapp.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("students")
    Call<List<Student>> getStudents();
}
