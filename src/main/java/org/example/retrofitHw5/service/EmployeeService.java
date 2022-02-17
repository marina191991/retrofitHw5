package org.example.retrofitHw5.service;

import org.example.retrofitHw5.DTO.GetEmployeeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmployeeService {
    @GET("employee/{id}")
    Call<GetEmployeeResponse> getEmployee(@Path("id") int id);
//    @GET("employees")
//    Call<GetEmployeeResponse> getEmployee();

}
