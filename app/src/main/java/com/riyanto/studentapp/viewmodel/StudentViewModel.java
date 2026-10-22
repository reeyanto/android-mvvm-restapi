package com.riyanto.studentapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.riyanto.studentapp.model.Student;
import com.riyanto.studentapp.repository.StudentRepository;

import java.util.List;

public class StudentViewModel extends ViewModel {

    private StudentRepository repository;

    private MutableLiveData<List<Student>> studentLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorMessageLiveData = new MutableLiveData<>();

    public StudentViewModel() {
        repository = new StudentRepository();
        loadStudents();
    }

    private void loadStudents() {
        repository.fetchStudent(new StudentRepository.StudentCallback() {
            @Override
            public void onSuccess(List<Student> students) {
                studentLiveData.setValue(students);
            }

            @Override
            public void onError(String message) {
                errorMessageLiveData.setValue(message);
            }
        });
    }

    public LiveData<List<Student>> getStudents() {
        return studentLiveData;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessageLiveData;
    }
}
