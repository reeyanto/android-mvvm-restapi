package com.riyanto.studentapp.repository;

import com.riyanto.studentapp.model.Student;
import com.riyanto.studentapp.network.ApiClient;
import com.riyanto.studentapp.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentRepository {

    private ApiService apiService;

    public StudentRepository() {
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    public interface StudentCallback {
        void onSuccess(List<Student> students);
        void onError(String message);
    }

    public void fetchStudent(StudentCallback callback) {
        apiService.getStudents().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if(response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Gagal memuat data: "+ response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                callback.onError("Terjadi kesalahan jaringan: "+ t.getMessage());
            }
        });
    }
}
